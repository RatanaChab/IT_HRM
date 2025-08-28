package com.example.IT_HRM.GlobalException;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistsException  extends ApiException {


    public ResourceAlreadyExistsException (String resourceName, String code) {
        super(HttpStatus.BAD_REQUEST, String.format("%s in = %s is Exist",resourceName,code));
    }
}
