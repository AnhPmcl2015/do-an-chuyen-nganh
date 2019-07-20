package topfactors.bus.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import topfactors.constant.ErrorMessage;
import topfactors.dao.entity.AppUser;
import topfactors.dao.entity.UserPrincipal;
import topfactors.dao.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmailOrPhoneNumber) throws UsernameNotFoundException {

		AppUser user = userRepository.findByUsernameOrEmailOrPhoneNumber(usernameOrEmailOrPhoneNumber, usernameOrEmailOrPhoneNumber, usernameOrEmailOrPhoneNumber)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(ErrorMessage.USERNAME_NOT_FOUND, usernameOrEmailOrPhoneNumber)));
		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails loadUserById(String id) {

		AppUser user = userRepository.findById(id)
				.orElseThrow(()->new UsernameNotFoundException(String.format(ErrorMessage.USER_ID_NOT_FOUND, id)));
		return UserPrincipal.create(user);
	}
	
	@Transactional
	public UserDetails loadUserByEmail(String email) {
		AppUser user = userRepository.findByEmail(email)
				.orElseThrow(()->new UsernameNotFoundException(String.format(ErrorMessage.USER_EMAIL_NOT_FOUND, email)));
		return UserPrincipal.create(user);
	}
	
	@Transactional
	public UserDetails loadUserByPhoneNumber(String phoneNumber) {
		AppUser user = userRepository.findByPhoneNumber(phoneNumber)
				.orElseThrow(()->new UsernameNotFoundException(String.format(ErrorMessage.USER_PHONE_NUMBER_NOT_FOUND, phoneNumber)));
		return UserPrincipal.create(user);
	}

}
