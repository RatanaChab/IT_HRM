package com.example.IT_HRM.GlobalException;

import com.example.IT_HRM.Utils.CommonUse;
import jakarta.persistence.UniqueConstraint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler
    public ResponseEntity<?> handleApiException( ApiException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getHttpStatus(),e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(errorResponse);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<?> handleDuplicateKeyException( ApiException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getHttpStatus(),e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(errorResponse);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<?> handleValidKeyException( ApiException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getHttpStatus(), CommonUse.extractDuplicateKeyDetail(e.getMessage()));
        return ResponseEntity.status(e.getHttpStatus()).body(errorResponse);
    }

//    @ExceptionHandler(DataIntegrityException.class)
//    public ResponseEntity<?> handleValidKeyException2( UniqueConstraint e){
//        //ErrorResponse errorResponse = new ErrorResponse(e.getHttpStatus(), CommonUse.extractDuplicateKeyDetail(e.getMessage()));
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.name());
//        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
//    }
}
