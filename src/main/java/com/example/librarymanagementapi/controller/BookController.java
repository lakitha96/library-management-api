package com.example.librarymanagementapi.controller;

import com.example.librarymanagementapi.dto.BookDTO;
import com.example.librarymanagementapi.handler.ResponseHandler;
import com.example.librarymanagementapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author lakithaprabudh
 */
@RestController
@RequestMapping("/v1/books")
public class BookController extends ResponseHandler {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<?> registerBook(BookDTO bookDTO) {
        return successResponseDataSaving(bookService.registerBook(bookDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks(@RequestParam int pageNumber,
                                         @RequestParam int pageSize) {
        return successResponseDataRetrieve(bookService.getAllBooks(pageNumber, pageSize));
    }
}
