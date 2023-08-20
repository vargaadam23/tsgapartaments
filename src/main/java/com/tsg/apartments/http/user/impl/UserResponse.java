package com.tsg.apartments.http.user.impl;

import com.tsg.apartments.http.user.UserResponseInterface;

//Work in progress, added for manual testing
public record UserResponse(String firstName, String email) implements UserResponseInterface {
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
