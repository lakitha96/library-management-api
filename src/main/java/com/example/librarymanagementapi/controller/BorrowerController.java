package com.example.librarymanagementapi.controller;

import com.example.librarymanagementapi.dto.BorrowerDTO;
import com.example.librarymanagementapi.handler.ResponseHandler;
import com.example.librarymanagementapi.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lakithaprabudh
 */
@RestController
@RequestMapping("/v1/borrowers")
public class BorrowerController extends ResponseHandler {

    @Autowired
    private BorrowerService borrowerService;

    @PostMapping
    public ResponseEntity<?> registerBorrower(@RequestBody BorrowerDTO borrowerDTO) {
        return successResponseDataSaving(borrowerService.registerBorrower(borrowerDTO));
    }
}
