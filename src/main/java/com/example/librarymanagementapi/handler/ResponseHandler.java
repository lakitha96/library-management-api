package com.example.librarymanagementapi.handler;

import com.example.librarymanagementapi.exception.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author lakithaprabudh
 */
public class ResponseHandler {
    public ResponseEntity<?> successResponseDataSaving(Object object) {
        return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, object, "Successfully data saved."));
    }

    public ResponseEntity<?> successResponseDataRetrieve(Object object) {
        return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, object, "Success"));
    }
}
