package in.rebcoder.gs_back.services;

import in.rebcoder.gs_back.dtos.JwtResponse;
import in.rebcoder.gs_back.dtos.LoginDto;
import in.rebcoder.gs_back.dtos.UserRegistrationDto;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface AuthService {
    void register(UserRegistrationDto userRegistrationDTO);
    JwtResponse authenticate(LoginDto loginDTO);

    JwtResponse handleGoogleLogin(OAuth2AuthenticationToken authentication);
}
