package jobcentral.bus.mapper.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jobcentral.bus.mapper.IUserMapper;
import jobcentral.common.exception.AppException;
import jobcentral.common.form.CandidateSignUpRequest;
import jobcentral.common.utils.AppUtils;
import jobcentral.constant.ErrorMessage;
import jobcentral.constant.RoleName;
import jobcentral.constant.UserCategoryName;
import jobcentral.dao.entity.AppRole;
import jobcentral.dao.entity.AppUser;
import jobcentral.dao.entity.UserCategory;
import jobcentral.dao.repository.RoleRepository;
import jobcentral.dao.repository.UserCategoryRepository;

@Component
public class UserMapperImpl implements IUserMapper{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AppUtils appUtils;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserCategoryRepository userCategoryRepository;
	
	@Override
	public void mapCandidateSignUpRequestToUser(CandidateSignUpRequest candidateSignUpRequest, AppUser appUser) {
		if(candidateSignUpRequest == null) {
			return;
		}
		
		if(appUser == null) {
			appUser = new AppUser();
		}
		
		appUser.setFullname(candidateSignUpRequest.getFullName());
		appUser.setPhoneNumber(candidateSignUpRequest.getPhoneNumber());
		appUser.setUsername(candidateSignUpRequest.getUsername());
		appUser.setUserPassword(passwordEncoder.encode(candidateSignUpRequest.getPassword()));
		appUser.setId(appUtils.generateIdUsingHex());
		
		AppRole appRole = roleRepository.findByRoleName(RoleName.ROLE_CANDIDATE)
				.orElseThrow(() -> new AppException(String.format(ErrorMessage.ROLE_NOT_SET, RoleName.ROLE_CANDIDATE)));
		
		appUser.setAppRoles(Collections.singleton(appRole));
		
		appUser.setCreatedBy(appUser.getId());
		
		UserCategory userCategory = userCategoryRepository.findByUserCategoryName(UserCategoryName.CANDIDATE)
				.orElseThrow(() -> new AppException(String.format(ErrorMessage.USER_CATEGORY_NOT_SET, UserCategoryName.CANDIDATE)));
		appUser.setUserCategory(userCategory);
		
	}
	
}
