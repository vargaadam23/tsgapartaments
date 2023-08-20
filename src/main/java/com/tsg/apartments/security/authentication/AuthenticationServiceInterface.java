package com.tsg.apartments.security.authentication;

import com.tsg.apartments.http.authentication.AuthenticationResponseInterface;
import com.tsg.apartments.http.authentication.SignInRequestInterface;
import com.tsg.apartments.http.authentication.SignUpRequestInterface;

public interface AuthenticationServiceInterface {
    AuthenticationResponseInterface signup(SignUpRequestInterface signUpRequest);

    AuthenticationResponseInterface signin(SignInRequestInterface signInRequest);
}
