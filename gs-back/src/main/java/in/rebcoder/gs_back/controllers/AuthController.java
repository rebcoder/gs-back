package in.rebcoder.gs_back.controllers;

import in.rebcoder.gs_back.dtos.JwtResponse;
import in.rebcoder.gs_back.dtos.LoginDto;
import in.rebcoder.gs_back.dtos.UserRegistrationDto;
import in.rebcoder.gs_back.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Endpoint for standard registration
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDto user) {
        authService.register(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    // Endpoint for standard login
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginDto loginRequest) {
        return ResponseEntity.ok(authService.authenticate(loginRequest));
    }

    // Endpoint for Google OAuth login callback
    @GetMapping("/oauth2/google")
    public ResponseEntity<JwtResponse> googleLogin(OAuth2AuthenticationToken authentication) {
        return ResponseEntity.ok(authService.handleGoogleLogin(authentication));
    }
}
