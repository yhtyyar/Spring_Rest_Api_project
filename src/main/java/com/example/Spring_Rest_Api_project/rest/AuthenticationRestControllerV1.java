package com.example.Spring_Rest_Api_project.rest;

import com.example.Spring_Rest_Api_project.model.User;
import com.example.Spring_Rest_Api_project.repository.UserRepository;
import com.example.Spring_Rest_Api_project.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;


    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, UserRepository userRepository,
                                          JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO requestDTO) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getEmail(),
                    requestDTO.getPassword()));
            User user = userRepository.findByEmail(requestDTO.getEmail()).orElseThrow(() ->
                    new UsernameNotFoundException("User doesn't exists (Пользователь не существует)"));
            String token = jwtTokenProvider.createToken(requestDTO.getEmail(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", requestDTO.getEmail());
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email/password combination " +
                    "(Неверная комбинация адреса электронной почты и пароля.)", HttpStatus.FORBIDDEN);
        }
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(httpServletRequest, httpServletResponse, null);
        return null;
    }
}
