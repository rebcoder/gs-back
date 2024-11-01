package in.rebcoder.gs_back.services;

import in.rebcoder.gs_back.dtos.UserRegistrationDto;
import in.rebcoder.gs_back.exception.ResourceNotFoundException;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // For password hashing
    @Override
    public User registerNewUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));  // Hash the password
        user.setRoles(userRegistrationDto.getRoles());
        return userRepository.save(user);  // Save the user with roles
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }
}
