package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rodichev.webBlog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
