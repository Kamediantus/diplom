package ru.rodichev.webBlog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rodichev.webBlog.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
