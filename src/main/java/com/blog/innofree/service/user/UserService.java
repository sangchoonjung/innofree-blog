package com.blog.innofree.service.user;

import com.blog.innofree.domain.User;
import com.blog.innofree.dto.user.AddUserRequest;
import com.blog.innofree.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //    public Long save(AddUserRequest dto) {
//        return userRepository.save(User.builder()
//                .email(dto.getEmail())
//                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
//                .build()).getId();
//    }

    //    인증성공시 실행할 핸들러
    public Long save(AddUserRequest dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .build()).getId();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()->new IllegalArgumentException("Unexpected user"));
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(("UnExpected user")));
    }



}
