package com.tsg.apartments.security;

import com.tsg.apartments.http.authentication.AuthenticationResponseInterface;
import com.tsg.apartments.http.authentication.SignInRequestInterface;
import com.tsg.apartments.http.authentication.SignUpRequestInterface;
import com.tsg.apartments.http.authentication.impl.SignInRequest;
import com.tsg.apartments.http.authentication.impl.SignUpRequest;
import com.tsg.apartments.security.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponseInterface> signup(@RequestBody SignUpRequest requestInterface){
        return ResponseEntity.ok(authenticationService.signup(requestInterface));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponseInterface> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
