package com.tsg.apartments.user;

import com.tsg.apartments.http.user.UserResponseInterface;
import com.tsg.apartments.http.user.impl.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Work in progress, made for testing
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/data")
    public ResponseEntity<UserResponseInterface> getUserData(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(new UserResponse(user.getFirstName(), user.getEmail()));
    }
}
