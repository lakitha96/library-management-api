package com.example.librarymanagementapi.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * @author lakithaprabudh
 */
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id", referencedColumnName = "id")
    private Borrower borrower;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    private Date borrowedDate;
    private Date returnedDate;
    private Boolean returned;

    public Reservation() {
    }

    public Reservation(Long id, Borrower borrower, Book book, Date borrowedDate, Date returnedDate, Boolean returned) {
        this.id = id;
        this.borrower = borrower;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.returned = returned;
    }

    public Reservation(Borrower borrower, Book book, Date borrowedDate, Date returnedDate, Boolean returned) {
        this.borrower = borrower;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.returned = returned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Boolean isReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
