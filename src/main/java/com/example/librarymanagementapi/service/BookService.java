package com.example.librarymanagementapi.service;

import com.example.librarymanagementapi.dto.BookDTO;
import com.example.librarymanagementapi.exception.CustomBadRequestException;
import com.example.librarymanagementapi.exception.CustomInternalServerException;
import com.example.librarymanagementapi.model.Book;
import com.example.librarymanagementapi.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lakithaprabudh
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookDTO registerBook(BookDTO bookDTO) {
        try {
            Book book;
            Optional<Book> bookOptional = bookRepository.findBookByISBN(bookDTO.getIsbn());
            if (bookOptional.isPresent()) {
                book = bookOptional.get();
                if (book.getISBN().equals(bookDTO.getIsbn()) &&
                        book.getAuthor().equalsIgnoreCase(bookDTO.getAuthor()) &&
                        book.getTitle().equalsIgnoreCase(bookDTO.getTitle())) {
                    int availableCopies = book.getAvailableCopies();
                    book.setAvailableCopies(availableCopies + 1);
                    bookRepository.save(book);
                }
            } else {
                book = bookRepository.save(new Book(bookDTO.getTitle(), bookDTO.getAuthor(),
                        bookDTO.getIsbn(), bookDTO.getAvailableCopies()));
            }
            return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(),
                    book.getISBN(), book.getAvailableCopies());
        } catch (DataAccessException e) {
            throw new CustomInternalServerException("Failed to register book", e);
        }
    }

    public List<BookDTO> getAllBooks(int pageNumber, int pageSize) {
        if (pageNumber < 1 || pageSize < 1) {
            throw new CustomBadRequestException("Invalid page number or page size");
        }

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        List<Book> books = bookRepository.findAll(pageable).getContent();
        return books.stream()
                .map(book -> new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getISBN(), book.getAvailableCopies()))
                .collect(Collectors.toList());
    }
}
