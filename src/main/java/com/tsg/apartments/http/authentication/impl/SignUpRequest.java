package com.tsg.apartments.http.authentication.impl;

import com.tsg.apartments.http.authentication.SignUpRequestInterface;

public record SignUpRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber
) implements SignUpRequestInterface {

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
