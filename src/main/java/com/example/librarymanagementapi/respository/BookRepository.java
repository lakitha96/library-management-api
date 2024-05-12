package com.example.librarymanagementapi.respository;

import com.example.librarymanagementapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author lakithaprabudh
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByISBN(String isbn);
}
