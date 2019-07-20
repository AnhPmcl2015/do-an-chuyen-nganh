package topfactors.controller.pub;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import topfactors.bus.define.IUserService;
import topfactors.common.dto.ApiResponseDto;
import topfactors.common.dto.JwtAuthenticationResponseDto;
import topfactors.common.form.CandidateSignUpRequest;
import topfactors.common.form.RecruitmentLoginForm;
import topfactors.common.form.UserLoginForm;
import topfactors.common.utils.AppUtils;
import topfactors.config.security.JwtTokenProvider;
import topfactors.constant.ApiConstant;

@RestController
@RequestMapping(ApiConstant.AUTH_API)
public class AuthController {
	@Autowired
	private AuthenticationManager authenticaltionManager;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private AppUtils appUtils;
	
	@Autowired
	private IUserService userServiceImpl;
	
	@PostMapping("/ung-vien/dang-nhap")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserLoginForm loginForm){
		Authentication authentication = authenticaltionManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginForm.getUsernameOrPhoneNumber(), loginForm.getPassword())
		);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new JwtAuthenticationResponseDto(jwt));

	}
	
	@PostMapping("/nha-tuyen-dung/dang-nhap")
	public ResponseEntity<?> authenticateRecruitment(@Valid @RequestBody RecruitmentLoginForm loginForm){
		Authentication authentication = authenticaltionManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginForm.getUsernameOrEmail(), loginForm.getPassword())
		);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new JwtAuthenticationResponseDto(jwt));
	}
	
	/**
	 * Dùng để đăng ký tài khoản của ứng viên
	 * @param candidateSignUpForm
	 * @return
	 * 	 1. ApiResponseDto
	 * 		* success: tình trạng (true, false)
	 * 		* message: Lời nhắn trả về
	 * 
	 * 	2. HTTPResponseStatus: 
	 * 		Status của HTTP Response
	 */
	@PostMapping("/ung-vien/dang-ky")
	public ResponseEntity<?> registerUser(@Valid @RequestBody CandidateSignUpRequest candidateSignUpForm){
		
//		String validateErrorMessage = appUtils.validateCandidateSignUpRequest(candidateSignUpForm);
//		
//		if(!"".equals(validateErrorMessage)) {
//			return new ResponseEntity<>(new ApiResponseDto(false, validateErrorMessage), HttpStatus.BAD_REQUEST);
//		}
		
		ApiResponseDto dto = userServiceImpl.registerNewCandidate(candidateSignUpForm);
		
		if(!dto.getSuccess()) {
			return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
		}else {

			return new ResponseEntity<>(dto, HttpStatus.OK);
		}

	}
	
	@PostMapping("/nha-tuyen-dung/dang-ky")
	public ResponseEntity<ApiResponseDto> registerRecruitment(){
		return null;
	}
}
