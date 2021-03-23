package ru.rodichev.webBlog.repo;

import org.springframework.data.repository.CrudRepository;
import ru.rodichev.webBlog.models.Notes;

public interface NotesRepository extends CrudRepository<Notes, Long> {


}
