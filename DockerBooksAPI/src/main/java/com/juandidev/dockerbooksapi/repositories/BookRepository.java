package com.juandidev.dockerbooksapi.repositories;

import com.juandidev.dockerbooksapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
