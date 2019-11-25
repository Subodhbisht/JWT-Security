package sb.security.jwtsecurity.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sb.security.jwtsecurity.dao.UserRepository;

@Service
public class UserPrincipalDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username is "+username);
		sb.security.jwtsecurity.entity.User user= userRepository.findByUserName(username);
		UserDetails userDetails = (UserDetails)new User(user.getUserName(), user.getPassword(), Collections.emptyList());
		return userDetails;
	}

}
