package com.stussy.stussyclone20220903SHC.service;

import com.stussy.stussyclone20220903SHC.domain.User;
import com.stussy.stussyclone20220903SHC.exception.CustominternalServerErrorException;
import com.stussy.stussyclone20220903SHC.repository.AccountRepository;
import com.stussy.stussyclone20220903SHC.security.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDatailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = null;

        try {
            user = accountRepository.findUserByEmail(email);
        }catch (Exception e) {
            throw new CustominternalServerErrorException("회원 정보 조회 오류");
        }

        if(user == null){
            throw new UsernameNotFoundException("잘못된 사용자 정보");
        }

        return new PrincipalDetails(user);
    }
}
