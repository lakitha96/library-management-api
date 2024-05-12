package com.example.librarymanagementapi.service;

import com.example.librarymanagementapi.dto.BorrowerDTO;
import com.example.librarymanagementapi.exception.CustomInternalServerException;
import com.example.librarymanagementapi.model.Borrower;
import com.example.librarymanagementapi.respository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author lakithaprabudh
 */
@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    public BorrowerDTO registerBorrower(BorrowerDTO borrowerDTO) {
        try {
            Borrower savedBorrower = borrowerRepository.save(new Borrower(borrowerDTO.getName(), borrowerDTO.getEmail()));
            return new BorrowerDTO(savedBorrower.getId(), savedBorrower.getName(), savedBorrower.getEmail());
        } catch (DataAccessException e) {
            throw new CustomInternalServerException("Failed to register borrower", e);
        }
    }
}
