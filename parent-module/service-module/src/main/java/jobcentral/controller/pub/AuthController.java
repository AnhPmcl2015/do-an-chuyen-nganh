package jobcentral.controller.pub;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jobcentral.common.form.SignUpRequestForm;
import jobcentral.common.form.UserLoginForm;
import jobcentral.config.security.JwtTokenProvider;
import jobcentral.constant.ApiConstant;

@RestController
@RequestMapping(ApiConstant.AUTH_API)
public class AuthController {
	@Autowired
	private AuthenticationManager authenticaltionManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserLoginForm loginForm){
//		Authentication authentication = authenticaltionManager.authenticate(
//				new UsernamePasswordAuthenticationToken(
//						loginForm.getUsernameOrEmail(), loginForm.getPassword())
//		);
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		String jwt = tokenProvider.generateToken(authentication);
//		
//		return ResponseEntity.ok(new JwtAuthenticationResponseDto(jwt));
		
		return null;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequestForm signUpForm){
//		if(userRepository.existsByUsername(signUpForm.getUsername())) {
//			return new ResponseEntity<>(new ApiResponseDto(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
//		}
//		
//		// Creating user account
//		User user = new User(signUpForm.getUsername(), signUpForm.getEmail(), signUpForm.getPassword());
//		
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		
//		Role userRole = roleRepository.findByRoleName(RoleName.ROLE_USER)
//				.orElseThrow(()->new AppException("User role not set"));
//		
//		user.setRoles(Collections.singleton(userRole));
//		
//		User user1 = new User("anh-pt2","anhpmcl@gmail.com" ,passwordEncoder.encode("123"));
//		user1.setRoles(Collections.singleton(userRole));
//		
//		userRepository.saveAndFlush(user1);
//		
//		user.setCreatedBy(user1);
//		
//		User result = userRepository.saveAndFlush(user);
//		
//		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
//				.path("/api/users/{username}")
//				.buildAndExpand(result.getUsername()).toUri();
//		
//		return ResponseEntity.created(location).body(new ApiResponseDto(true, "User registed successful"));
		return null;
	}
}
