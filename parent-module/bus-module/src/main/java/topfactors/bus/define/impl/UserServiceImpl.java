package topfactors.bus.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topfactors.bus.define.IAddressService;
import topfactors.bus.define.ICompanyService;
import topfactors.bus.define.INationService;
import topfactors.bus.define.IUserOtpService;
import topfactors.bus.define.IUserService;
import topfactors.bus.mapper.IUserMapper;
import topfactors.common.base.IBaseDao;
import topfactors.common.dto.ApiResponseDto;
import topfactors.common.exception.AppException;
import topfactors.common.exception.BadRequestException;
import topfactors.common.form.CandidateSignUpRequest;
import topfactors.common.form.RecruitmentSignUpRequest;
import topfactors.common.utils.AppUtils;
import topfactors.constant.Constant;
import topfactors.constant.ErrorMessage;
import topfactors.dao.entity.Address;
import topfactors.dao.entity.AppUser;
import topfactors.dao.entity.Company;
import topfactors.dao.entity.Nation;
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

	@Autowired
	private ICompanyService companyServiceImpl;

	@Autowired
	private IAddressService addressService;

	@Autowired
	private INationService nationService;

	/**
	 * Dùng để đăng ký người dùng là mới là ứng viên
	 */
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

		UserOtp userOtp = new UserOtp(appUser, otp, true);

		this.insertOrUpdate(appUser, false);

		userOtpServiceImpl.insertOrUpdate(userOtp, false);

		return new ApiResponseDto(true, "");
	}

	/**
	 * Lấy thông tin người dùng dựa vào 3 tham số: username, phoneNumber hoặc email
	 */
	@Override
	public AppUser findByUsernameOrPhoneNumberOrEmail(String usernameOrPhoneNumberOrEmail) {

		return this.userRepository
				.findByUsernameOrEmailOrPhoneNumber(usernameOrPhoneNumberOrEmail, usernameOrPhoneNumberOrEmail,
						usernameOrPhoneNumberOrEmail)
				.orElseThrow(() -> new BadRequestException(String
						.format(ErrorMessage.USERNAME_PHONENUMBER_EMAIL_NOT_FOUND, usernameOrPhoneNumberOrEmail)));
	}

	@Override
	public AppUser findById(Object id) {
		return userRepository.findById((String) id)
				.orElseThrow(() -> new AppException(String.format(ErrorMessage.USER_ID_NOT_FOUND, (String) id)));
	}

	@Override
	public void insertOrUpdate(AppUser t, boolean updateOnly) {
		if (!updateOnly) {
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

	/**
	 * Dùng để đăng ký thành viên mới cho nhà tuyển dụng
	 */
	@Override
	public ApiResponseDto registerNewRecruitment(RecruitmentSignUpRequest form) {

		String errorMessage = "";

		if (userRepository.existsByUsername(form.getUsername())) {
			errorMessage += String.format(ErrorMessage.USERNAME_IS_EXISTED, form.getUsername()) + " - ";
		}

		if (userRepository.existsByEmail(form.getEmail())) {
			errorMessage += String.format(ErrorMessage.EMAIL_IS_EXISTED, form.getEmail());
		}

		if (!"".equals(errorMessage)) {
			return new ApiResponseDto(false, errorMessage);
		}

		AppUser appUser = new AppUser();

		String abbreviation = appUtils.getSymbolAfterAtInEmail(form.getEmail());
		if ("".equals(abbreviation)) {
			throw new BadRequestException(String.format(ErrorMessage.INCORRECT_EMAIL_FORMAT, form.getEmail()));
		}

		Company company = this.companyServiceImpl.findByAbbreviation(abbreviation);

		if (company != null) {
			appUser.setCompany(company);
		} else {
			company = new Company();

			company.setId(appUtils.generateIdUsingHex());
			company.setCompanyName(form.getCompanyName());
			company.setAbbreviation(abbreviation);

			Nation nation = this.nationService.findByNationName(topfactors.constant.Nation.VIET_NAM);
			Address address = new Address(nation, form.getCompanyAddress());
			this.addressService.insertOrUpdate(address, false);

			this.companyServiceImpl.insertOrUpdate(company, false);

		}

		this.userMapperImpl.mapRecruitmentSignUpRequestToUser(form, appUser, company);

		this.insertOrUpdate(appUser, false);

		String otp = appUtils.generateOTPAndAccessCode();

		UserOtp userOtp = new UserOtp(appUser, otp, true);

		userOtpServiceImpl.insertOrUpdate(userOtp, false);

		appUtils.sendTextMail(form.getEmail(), "Xác nhận đăng ký thành viên TopFactors",
				String.format(Constant.RECRUITMENT_CONFIRM_REGISTRATION, appUser.getId(), otp));

		return new ApiResponseDto(true, String.format("Vui lòng xác nhận đăng ký tại địa chỉ email: %s", form.getEmail()));
	}

	/**
	 * Bật flag người dùng lên để có tài khoản đó được active
	 */
	@Override
	public boolean enableAccount(String username, String accessCode) {
		AppUser appUser = this.userRepository.findByUsernameAndIsDeletedFalse(username).orElseThrow(() -> new BadRequestException(ErrorMessage.USERNAME_IS_EXISTED));
		
		UserOtp userOtp = this.userOtpServiceImpl.findByAppUserAndOtpAndIsEnableTrue(appUser, accessCode);
		
		if(userOtp != null) {
			this.userOtpServiceImpl.insertOrUpdate(userOtp, true);
			this.insertOrUpdate(appUser, true);
			return true;
		}
		
		return false;
	}

}
