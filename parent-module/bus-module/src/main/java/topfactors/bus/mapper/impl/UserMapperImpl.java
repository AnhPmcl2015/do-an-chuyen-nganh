package topfactors.bus.mapper.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import topfactors.bus.mapper.IUserMapper;
import topfactors.common.exception.AppException;
import topfactors.common.form.CandidateSignUpRequest;
import topfactors.common.form.RecruitmentSignUpRequest;
import topfactors.common.utils.AppUtils;
import topfactors.constant.Constant;
import topfactors.constant.ErrorMessage;
import topfactors.constant.RoleName;
import topfactors.constant.UserCategoryName;
import topfactors.dao.entity.AppRole;
import topfactors.dao.entity.AppUser;
import topfactors.dao.entity.Company;
import topfactors.dao.entity.UserCategory;
import topfactors.dao.repository.RoleRepository;
import topfactors.dao.repository.UserCategoryRepository;

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

	@Override
	public void mapRecruitmentSignUpRequestToUser(RecruitmentSignUpRequest recruitmentSignUpRequest, AppUser appUser, Company company) {
		if(recruitmentSignUpRequest == null) {
			return;
		}
		
		if(appUser == null) {
			appUser = new AppUser();
		}
		
		appUser.setFullname(Constant.DEFAULT_FULLNAME_RECRUITMENT);
		appUser.setUsername(recruitmentSignUpRequest.getUsername());
		appUser.setEmail(recruitmentSignUpRequest.getEmail());
		appUser.setUserPassword(passwordEncoder.encode(recruitmentSignUpRequest.getPassword()));
		appUser.setId(appUtils.generateIdUsingHex());
		
		AppRole appRole = roleRepository.findByRoleName(RoleName.ROLE_RECRUITMENT)
				.orElseThrow(() -> new AppException(String.format(ErrorMessage.ROLE_NOT_SET, RoleName.ROLE_RECRUITMENT)));
		
		appUser.setAppRoles(Collections.singleton(appRole));
		appUser.setCreatedBy(appUser.getId());
		
		UserCategory userCategory = userCategoryRepository.findByUserCategoryName(UserCategoryName.RECRUITMENT)
				.orElseThrow(() -> new AppException(String.format(ErrorMessage.USER_CATEGORY_NOT_SET, UserCategoryName.RECRUITMENT)));
		appUser.setUserCategory(userCategory);
		
		appUser.setCompany(company);
	}
	
}
