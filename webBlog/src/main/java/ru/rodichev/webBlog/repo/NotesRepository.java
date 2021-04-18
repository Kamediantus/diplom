package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.rodichev.webBlog.entity.Note;

public interface NotesRepository extends CrudRepository<Note, Long> {


    /***
     * find tags for display them as links to search another notes with same tags
     * @param id id of note that tags will be returned
     * @return tags of note as String line
     */
    @Query(value = "SELECT tags FROM `t_notes` WHERE id = :id", nativeQuery = true)
    String getTagsById(@Param("id") Long id);

    /***
     * find Note by id
     * @param id id for search Note
     * @return Note with ID from param
     */
    @Query(value = "SELECT * FROM t_notes WHERE id = :id", nativeQuery = true)
    Note getById(@Param("id") Long id);

    /***
     * find notes that include substring from params
     * @param text substring to search. Must have structure: %substring%
     * @return List of Notes that include in final full text substring from param
     */
    @Query(value = "SELECT * FROM `t_notes` WHERE final_full_text like :text ORDER by id DESC", nativeQuery = true)
    Iterable<Note> reverseFindByText(@Param("text") String text);

    /***
     * find notes that include tag from params
     * @param tag tag to search. Must have structure: %tag%
     * @return List of Notes which have tags like tag from param
     */
    @Query(value = "SELECT * FROM `t_notes` WHERE tags like :tag ORDER by id DESC", nativeQuery = true)
    Iterable<Note> reverseFindByTag(@Param("tag") String tag);

    /***
     *  search only unchecked notes for moderator
     * @return  List of Notes which have not been verified yet
     */
    @Query(value = "SELECT * FROM t_notes WHERE is_checked = false order by id desc", nativeQuery = true)
    Iterable<Note> getOnlyUnchecked();

    /***
     * search only checked but not fixed yet notes for Supertramp to fix
     * @return  List of Notes which have not been fixed yet, but already checked
     */
    @Query(value = "SELECT * FROM t_notes WHERE is_checked = true and is_fixed = false order by id desc", nativeQuery = true)
    Iterable<Note> getOnlyUnfixed();

    /***
     *  search only checked and fixed Notes
     * @return  List of Notes which already checked and fixed
     */
    @Query(value = "SELECT * FROM t_notes WHERE is_checked = true and is_fixed = true order by id desc", nativeQuery = true)
    Iterable<Note> getOnlyChecked();

}
