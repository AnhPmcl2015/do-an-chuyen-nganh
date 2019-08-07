package topfactors.bus.define;

import topfactors.common.base.IBaseDao;
import topfactors.dao.entity.AppUser;
import topfactors.dao.entity.UserOtp;

public interface IUserOtpService extends IBaseDao<UserOtp>{
	void deleteAllOtpByUserId(String userId);
	UserOtp findByAppUserAndOtpAndIsEnableTrue(AppUser appUser, String otp);
}
