package com.example.IT_HRM.GlobalException;
import org.springframework.http.HttpStatus;


public class DataIntegrityException extends ApiException{

    public DataIntegrityException(String resourceName, String e) {
        super(HttpStatus.BAD_REQUEST, String.format("%s in Bank Entity = %s Duplicate",resourceName,e));
    }



}
