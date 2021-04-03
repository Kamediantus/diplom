package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.rodichev.webBlog.entity.Notes;

public interface NotesRepository extends CrudRepository<Notes, Long> {

    @Query(value = "SELECT * FROM `t_notes` ORDER by id DESC", nativeQuery = true)
    Iterable<Notes> reverseFindAll();

//    @Query(value = "SELECT * FROM 't_notes' WHERE id = :id", nativeQuery = true)
//    Notes getNoteById(@Param("id") Long id);

}
