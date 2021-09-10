package Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import Web.dto.UserRegistrationDto;
import model.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);

}
