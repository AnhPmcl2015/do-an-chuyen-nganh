package jobcentral.bus.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobcentral.bus.define.IUserOtpService;
import jobcentral.bus.define.IUserService;
import jobcentral.bus.mapper.IUserMapper;
import jobcentral.common.base.IBaseDao;
import jobcentral.common.dto.ApiResponseDto;
import jobcentral.common.exception.AppException;
import jobcentral.common.form.CandidateSignUpRequest;
import jobcentral.common.utils.AppUtils;
import jobcentral.constant.Constant;
import jobcentral.constant.ErrorMessage;
import jobcentral.dao.entity.AppUser;
import jobcentral.dao.entity.UserOtp;
import jobcentral.dao.repository.UserRepository;

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
