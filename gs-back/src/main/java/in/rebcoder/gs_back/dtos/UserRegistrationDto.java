package in.rebcoder.gs_back.dtos;

import in.rebcoder.gs_back.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;  // e.g., {"ROLE_BUYER", "ROLE_SELLER"}
}
