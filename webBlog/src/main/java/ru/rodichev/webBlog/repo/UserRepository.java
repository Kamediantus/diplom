package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.rodichev.webBlog.entity.Notes;
import ru.rodichev.webBlog.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Modifying
    @Query(value = "DELETE FROM 't_user' t where t.id = :id", nativeQuery = true)
    boolean deleteUserById(@Param("id")Long id);




}
