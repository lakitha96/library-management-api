package com.example.librarymanagementapi.dto;

import java.util.Date;

/**
 * @author lakithaprabudh
 */
public class ReservationDTO {
    private Long id;
    private Long borrowerId;
    private Long bookId;
    private Date borrowedDate;
    private Date returnedDate;
    private boolean returned;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id, Long borrowerId, Long bookId, Date borrowedDate, Date returnedDate, boolean returned) {
        this.id = id;
        this.borrowerId = borrowerId;
        this.bookId = bookId;
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

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
