package ru.rodichev.webBlog.entity;

import org.hibernate.annotations.GeneratorType;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/***
 * Admin - update roles of user, edit contacts and AboutUs info
 * Moderator - moderate notes before it will be posted
 * User - basic user, that can odd comments to notes
 * Supertramp - me, who can add new notes, update and delete it
 */
public enum Role {
    ROLE_ADMIN, ROLE_MODERATOR, ROLE_USER, ROLE_SUPERTRAMP
}