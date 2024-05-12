package com.example.librarymanagementapi.service;

import com.example.librarymanagementapi.dto.BookDTO;
import com.example.librarymanagementapi.model.Book;
import com.example.librarymanagementapi.respository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author lakithaprabudh
 */
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testRegisterBook_ExistingISBN() throws Exception {
        // Mock existing book data
        Book existingBook = new Book(1L, "Test Title", "Test Author", "1234567890", 2);
        when(bookRepository.findBookByISBN("1234567890")).thenReturn(Optional.of(existingBook));

        // BookDTO with matching ISBN
        BookDTO bookDTO = new BookDTO("Test Title", "Test Author", "1234567890", 1);

        // Call the method and verify results
        BookDTO registeredBook = bookService.registerBook(bookDTO);
        assertThat(registeredBook.getId()).isEqualTo(existingBook.getId());
        assertThat(registeredBook.getAvailableCopies()).isEqualTo(3);

        // Verify repository calls
        verify(bookRepository).findBookByISBN("1234567890");
        verify(bookRepository).save(existingBook);
    }

    @Test
    public void testRegisterBook_NewISBN() throws Exception {
        // Mock no existing book
        when(bookRepository.findBookByISBN("9876543210")).thenReturn(Optional.empty());

        // BookDTO with new ISBN
        BookDTO bookDTO = new BookDTO("New Title", "New Author", "9876543210", 5);
        Book expectedBook = new Book(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getIsbn(), bookDTO.getAvailableCopies());
        when(bookRepository.save(argThat(book -> book.getISBN().equals("9876543210")))).thenReturn(expectedBook);

        // Call the method and verify results
        BookDTO registeredBook = bookService.registerBook(bookDTO);
        assertThat(registeredBook.getTitle()).isEqualTo(bookDTO.getTitle());
        assertThat(registeredBook.getAvailableCopies()).isEqualTo(bookDTO.getAvailableCopies());

        // Verify repository calls
        verify(bookRepository).findBookByISBN("9876543210");
    }
}
