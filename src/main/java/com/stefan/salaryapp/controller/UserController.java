package com.stefan.salaryapp.controller;

import com.stefan.jooq.model.tables.pojos.Users;
import com.stefan.salaryapp.service.AuthenticationService;
import com.stefan.salaryapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final AuthenticationService authenticationService;

    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/user/authenticate")
    public Users authenticate(@RequestHeader("Authorization") String authToken) {
        return authenticationService.authenticate(authToken);
    }

    @PostMapping("/user/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Users register(@RequestBody Users user) {
        logger.debug("Registering user: {}", user);
        return userService.registerUser(user);
    }

}
