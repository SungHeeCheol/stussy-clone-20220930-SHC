package com.stussy.stussyclone20220903SHC.api.advice;

import com.stussy.stussyclone20220903SHC.dto.CMRespDto;
import com.stussy.stussyclone20220903SHC.exception.CustomValidationException;
import com.stussy.stussyclone20220903SHC.exception.CustominternalServerErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationErrorException(CustomValidationException e){

        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

    @ExceptionHandler(CustominternalServerErrorException.class)
    public ResponseEntity<?> internalServerErrorException(CustominternalServerErrorException e){

        return ResponseEntity.internalServerError().body(new CMRespDto<>(e.getMessage(), null));
    }
}
