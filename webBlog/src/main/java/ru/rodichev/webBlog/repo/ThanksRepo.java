package ru.rodichev.webBlog.repo;

import org.springframework.data.repository.CrudRepository;
import ru.rodichev.webBlog.models.Thanks;

public interface ThanksRepo extends CrudRepository<Thanks, Long> {
}
