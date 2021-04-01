package ru.rodichev.webBlog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.rodichev.webBlog.repo.UserRepository;
import ru.rodichev.webBlog.service.UserService;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Order
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;



    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().disable();
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/aboutMe").hasRole("ADMIN")
                .antMatchers("/contacts").hasRole("MODERATOR")
                //Доступ разрешен всем пользователей
                .antMatchers("/**").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }


    @Autowired
    protected void configureGlobalTwo(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}