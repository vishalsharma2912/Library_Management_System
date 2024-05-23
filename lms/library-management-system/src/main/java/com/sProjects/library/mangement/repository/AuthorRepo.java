package com.sProjects.library.mangement.repository;

import com.sProjects.library.mangement.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
