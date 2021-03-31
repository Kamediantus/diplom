package ru.rodichev.webBlog.entity;

import org.hibernate.annotations.GeneratorType;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;


public enum Role {
    ROLE_ADMIN, ROLE_MODERATOR, ROLE_USER
}