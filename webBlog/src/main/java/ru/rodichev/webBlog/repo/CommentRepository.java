package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.rodichev.webBlog.entity.Comment;
import ru.rodichev.webBlog.entity.Notes;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM t_comment WHERE post_id = :id", nativeQuery = true)
    Iterable<Comment> reverseFindById(@Param("id") Long id);

}
