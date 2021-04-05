package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.rodichev.webBlog.entity.BlockOfSite;
import ru.rodichev.webBlog.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT * FROM T_contact WHERE id = :id", nativeQuery = true)
    Contact getContactById(@Param("id") Long id);

    @Query(value = "SELECT * FROM T_contact WHERE is_visible = 'true'", nativeQuery = true)
    Iterable<Contact> getVisibleContacts();
}
