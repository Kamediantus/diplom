package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.rodichev.webBlog.models.Notes;

public interface NotesRepository extends CrudRepository<Notes, Long> {

    @Query(value = "SELECT * FROM `notes` ORDER by id DESC", nativeQuery = true)
    Iterable<Notes> reverseFindAll();


}
