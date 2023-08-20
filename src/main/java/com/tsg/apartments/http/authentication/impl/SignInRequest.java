package com.tsg.apartments.http.authentication.impl;

import com.tsg.apartments.http.authentication.SignInRequestInterface;

public record SignInRequest(
        String email,
        String password
) implements SignInRequestInterface{
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
