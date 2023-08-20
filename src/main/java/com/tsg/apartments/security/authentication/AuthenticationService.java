package com.tsg.apartments.security.authentication;

import com.tsg.apartments.http.authentication.AuthenticationResponseInterface;
import com.tsg.apartments.http.authentication.SignInRequestInterface;
import com.tsg.apartments.http.authentication.SignUpRequestInterface;
import com.tsg.apartments.http.authentication.impl.AuthenticationResponse;
import com.tsg.apartments.security.jwt.JwtService;
import com.tsg.apartments.security.jwt.JwtServiceInterface;
import com.tsg.apartments.user.Role;
import com.tsg.apartments.user.User;
import com.tsg.apartments.user.UserRepository;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService implements AuthenticationServiceInterface {
    private static final String USER_NOT_FOUND_MESSAGE = "Invalid email address provided!";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceInterface jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseInterface signup(SignUpRequestInterface signUpRequest) {
        User user = User.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .phoneNumber(signUpRequest.getPhoneNumber())
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .role(Role.USER)
                .build();
        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

    @Override
    public AuthenticationResponseInterface signin(SignInRequestInterface signInRequest) {
        authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
                );

        User user = userRepository
                .findByEmail(
                        signInRequest.getEmail())
                            .orElseThrow(() -> new IllegalArgumentException(USER_NOT_FOUND_MESSAGE));

        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}
