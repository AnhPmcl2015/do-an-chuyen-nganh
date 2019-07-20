package topfactors.bus.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topfactors.bus.define.IUserOtpService;
import topfactors.bus.define.IUserService;
import topfactors.bus.mapper.IUserMapper;
import topfactors.common.base.IBaseDao;
import topfactors.common.dto.ApiResponseDto;
import topfactors.common.exception.AppException;
import topfactors.common.form.CandidateSignUpRequest;
import topfactors.common.utils.AppUtils;
import topfactors.constant.ErrorMessage;
import topfactors.dao.entity.AppUser;
import topfactors.dao.entity.UserOtp;
import topfactors.dao.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService, IBaseDao<AppUser> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IUserMapper userMapperImpl;
	
	@Autowired
	private AppUtils appUtils;
	
	@Autowired
	private IUserOtpService userOtpServiceImpl;

	@Override
	public ApiResponseDto registerNewCandidate(CandidateSignUpRequest form) {

		String errorMessage = "";

		if (userRepository.existsByUsername(form.getUsername())) {
			errorMessage += String.format(ErrorMessage.USERNAME_IS_EXISTED, form.getUsername()) + " - ";
		}

		if (userRepository.existsByPhoneNumber(form.getPhoneNumber())) {
			errorMessage += String.format(ErrorMessage.PHONE_NUMBER_IS_EXISTED, form.getPhoneNumber());
		}

		if (!"".equals(errorMessage))
			return new ApiResponseDto(false, errorMessage);

		AppUser appUser = new AppUser();
		userMapperImpl.mapCandidateSignUpRequestToUser(form, appUser);

		String otp = appUtils.generateOTPAndAccessCode();
		
//		userOtpServiceImpl.deleteAllOtpByUserId(appUser.getId());
		
		UserOtp userOtp = new UserOtp(appUser, otp, true);
		
		this.insertOrUpdate(appUser, false);
		
		userOtpServiceImpl.insertOrUpdate(userOtp, false);
		
//		appUtils.sendSMS("", "123456");

		return new ApiResponseDto(true, otp);
	}

	@Override
	public AppUser findById(Object id) {
		return userRepository.findById((String) id)
				.orElseThrow(() -> new AppException(String.format(ErrorMessage.USER_ID_NOT_FOUND, (String) id)));
	}

	@Override
	public void insertOrUpdate(AppUser t, boolean updateOnly) {
		if(!updateOnly) {
			t.setIsEnable(false);
		}
		
		t.setIsDeleted(false);
		t.setIsEditable(true);
		userRepository.saveAndFlush(t);
	}

	@Override
	public void delete(AppUser t) {
		t.setIsDeleted(true);
		userRepository.saveAndFlush(t);
	}

	@Override
	public long count() {
		return userRepository.countByIsDeletedFalse();
	}

	@Override
	public void deletePermanently(AppUser t) {
		userRepository.delete(t);
	}

}
