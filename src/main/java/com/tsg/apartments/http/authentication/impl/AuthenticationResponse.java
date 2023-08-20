package com.tsg.apartments.http.authentication.impl;

import com.tsg.apartments.http.authentication.AuthenticationResponseInterface;

public record AuthenticationResponse(String token) implements AuthenticationResponseInterface {
}
