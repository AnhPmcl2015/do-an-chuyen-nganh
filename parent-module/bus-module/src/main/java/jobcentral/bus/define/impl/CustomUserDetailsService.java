package jobcentral.bus.define.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jobcentral.dao.entity.User;
import jobcentral.dao.entity.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService{


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
//				.orElseThrow(()-> new UsernameNotFoundException("User not found with username or email: "));
//		
		
		User user = null;
		return UserPrincipal.create(user);
	}
	
	@Transactional
	public UserDetails loadUserById(Long id) {
//		User user = userRepository.findById(id)
//				.orElseThrow(()-> new UsernameNotFoundException("User not found with id "));
		
		User user = null;
		return UserPrincipal.create(user);
	}

}
