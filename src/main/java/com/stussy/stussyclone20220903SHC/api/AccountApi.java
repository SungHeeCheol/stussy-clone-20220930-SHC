package com.stussy.stussyclone20220903SHC.api;

import com.stussy.stussyclone20220903SHC.dto.RegisterReqDto;
import com.stussy.stussyclone20220903SHC.dto.validation.ValidationSequence;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.stream.Location;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/account")
@RestController
public class AccountApi {

    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult){
//        System.out.println("회원가입 요청 데이터" + registerReqDto);
        Map<String, String> errorMap = new HashMap<String, String>();
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                System.out.println("필드명" + fieldError.getField());
                System.out.println("에러 메시지" + fieldError.getDefaultMessage());
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errorMap);
        }

        return ResponseEntity.ok().body(null);
    }

}
