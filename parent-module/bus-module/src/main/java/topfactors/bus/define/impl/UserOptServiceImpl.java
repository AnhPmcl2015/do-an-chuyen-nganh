package topfactors.bus.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topfactors.bus.define.IUserOtpService;
import topfactors.common.exception.BadRequestException;
import topfactors.constant.ErrorMessage;
import topfactors.dao.entity.AppUser;
import topfactors.dao.entity.UserOtp;
import topfactors.dao.repository.UserOtpRepository;

@Service
public class UserOptServiceImpl implements IUserOtpService{

	@Autowired
	private UserOtpRepository userOtpRepository;
	
	@Override
	public UserOtp findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdate(UserOtp t, boolean updateOnly) {
		if(!updateOnly) {
			t.setIsEnable(true);
			t.setCreatedBy(t.getAppUser().getId());
		}else {
			t.setIsEnable(false);
			t.setUpdatedBy(t.getAppUser().getId());
		}
		
		userOtpRepository.saveAndFlush(t);
	}

	@Override
	public void delete(UserOtp t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePermanently(UserOtp t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllOtpByUserId(String userId) {
		userOtpRepository.deleteUserOtpByUserId(userId);
		
	}

	/**
	 * Lấy
	 */
	@Override
	public UserOtp findByAppUserAndOtpAndIsEnableTrue(AppUser appUser, String otp) {
		
		return this.userOtpRepository.findByAppUserAndOtpAndIsEnableTrue(appUser, otp)
				.orElseThrow(()->new BadRequestException(ErrorMessage.OTP_NOT_FOUND));
	}

}
