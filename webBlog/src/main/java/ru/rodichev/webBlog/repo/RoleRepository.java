package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rodichev.webBlog.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
