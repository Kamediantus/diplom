package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.rodichev.webBlog.entity.Note;

public interface NotesRepository extends CrudRepository<Note, Long> {

    //revers list for main page
    @Query(value = "SELECT * FROM `t_notes` ORDER by id DESC", nativeQuery = true)
    Iterable<Note> reverseFindAll();

    // get tags for details page
    @Query(value = "SELECT tags FROM `t_notes` WHERE id = :id", nativeQuery = true)
    String getTagsById(@Param("id") Long id);

    // get tags for details page
    @Query(value = "SELECT * FROM t_notes WHERE id = :id", nativeQuery = true)
    Note getById(@Param("id") Long id);

    // revers search by substring in text
    @Query(value = "SELECT * FROM `t_notes` WHERE full_text like :text ORDER by id DESC", nativeQuery = true)
    Iterable<Note> reverseFindByText(@Param("text") String text);

    // reverse search by tags
    @Query(value = "SELECT * FROM `t_notes` WHERE tags like :tag ORDER by id DESC", nativeQuery = true)
    Iterable<Note> reverseFindByTag(@Param("tag") String tag);

    // search only unchecked notes for moderator
    @Query(value = "SELECT * FROM t_notes WHERE is_checked = false order by id desc", nativeQuery = true)
    Iterable<Note> getOnlyUnchecked();

    // search only checked notes for visible list
    @Query(value = "SELECT * FROM t_notes WHERE is_checked = true order by id desc", nativeQuery = true)
    Iterable<Note> getOnlyChecked();

}
