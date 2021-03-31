package ru.rodichev.webBlog.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfigDialect {

    /* Заменил AbstractProcessorDialect на AbstractDialect в 7-м уроке,
       так-как SpringSecurityDialect не наследует AbstractProcessorDialect.
    */
//    @Bean
//    public ViewResolver viewResolver(List<AbstractDialect> dialects, SpringTemplateEngine templateEngine) {
//        templateEngine.setDialects(new HashSet<>(dialects));
//
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine);
//        resolver.setCharacterEncoding("UTF-8");
//        return resolver;
//    }

//    @Bean
//    public ThymeleafCourseDialect thymeleafCourseDialect() {
//        return new ThymeleafCourseDialect();
//    }
//
//    @Bean
//    public FunctionDialect functionDialect() {
//        return new FunctionDialect();
//    }
//
//    @Bean
//    public SpringSecurityDialect springSecurityDialect() {
//        return new SpringSecurityDialect();
//    }
}
