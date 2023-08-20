package com.tsg.apartments;

import com.tsg.apartments.http.authentication.SignUpRequestInterface;
import com.tsg.apartments.http.authentication.impl.SignUpRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthenticationTest {

    @Test
    public void signUpTest(){
        SignUpRequestInterface signUpRequestInterface = new SignUpRequest(
                "adam","varga","adam@varga.com","password","077777777777");
        // call the function from the authentication service
        // set up a new test profile that will use h2 database instead of production database
        // assert that user was created and valid token was returned
    }
}
