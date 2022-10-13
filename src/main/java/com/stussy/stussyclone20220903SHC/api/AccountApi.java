package com.stussy.stussyclone20220903SHC.api;

import com.stussy.stussyclone20220903SHC.aop.annotation.LogAspect;
import com.stussy.stussyclone20220903SHC.dto.CMRespDto;
import com.stussy.stussyclone20220903SHC.dto.RegisterReqDto;
import com.stussy.stussyclone20220903SHC.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220903SHC.exception.CustomValidationException;
import com.stussy.stussyclone20220903SHC.service.AccountService;
import lombok.RequiredArgsConstructor;
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
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

//    public AccountApi(AccountService accountService) {
//        this.accountService = accountService;
//    } => @RequiredArgsConstructor가 이거임

    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto,
                                      BindingResult bindingResult) throws Exception{

        accountService.duplicateEmail(registerReqDto);
        accountService.register(registerReqDto);

        return ResponseEntity.created(URI.create("/account/login")).body(new CMRespDto<>("회원가입 성공", registerReqDto.getEmail()));
    }

}



























