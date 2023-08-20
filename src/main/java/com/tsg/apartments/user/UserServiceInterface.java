package com.tsg.apartments.user;

import com.tsg.apartments.http.user.UserResponseInterface;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface {
    UserDetailsService userDetailsService();
}
