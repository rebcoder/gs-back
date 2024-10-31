package in.rebcoder.gs_back.controllers;

import in.rebcoder.gs_back.dtos.UserRegistrationDto;
import in.rebcoder.gs_back.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        userService.registerNewUser(registrationDto);
        return ResponseEntity.ok("User registered successfully");
    }
}
