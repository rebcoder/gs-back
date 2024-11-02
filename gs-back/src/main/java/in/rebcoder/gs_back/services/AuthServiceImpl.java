package in.rebcoder.gs_back.services;

import in.rebcoder.gs_back.utils.JwtTokenProvider;
import in.rebcoder.gs_back.dtos.JwtResponse;
import in.rebcoder.gs_back.dtos.LoginDto;
import in.rebcoder.gs_back.dtos.UserRegistrationDto;
import in.rebcoder.gs_back.models.Role;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void register(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setRoles(userRegistrationDto.getRoles());

        userRepository.save(user);
    }

    @Override
    public JwtResponse authenticate(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);

        return new JwtResponse(jwt);
    }

    @Override
    public JwtResponse handleGoogleLogin(OAuth2AuthenticationToken authentication) {
            // Extract user details
            String email = authentication.getPrincipal().getAttribute("email");
            String name = authentication.getPrincipal().getAttribute("name");

            // Check if user exists in your database
            User user = userRepository.findByEmail(email);
            if (user == null) {
                // Create a new user if not found
                user = new User();
                user.setEmail(email);
                user.setUsername(name); // or some default username logic
                user.setRoles(Set.of(Role.SELLER)); // Assign default roles
                userRepository.save(user);
            } else {
                // Update existing user information if needed
                user.setUsername(name); // Optionally update username
                userRepository.save(user);
            }

            // Generate JWT token or handle further logic
           // String token = jwtTokenProvider.createToken(user.getUsername(), user.getPassword());
            // Return token or continue with authentication process

        Authentication authentication1 = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);

        return new JwtResponse(jwt);

    }
}


