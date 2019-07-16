package jobcentral.bus.define;

import jobcentral.common.base.IBaseDao;
import jobcentral.dao.entity.UserOtp;

public interface IUserOtpService extends IBaseDao<UserOtp>{
	void deleteAllOtpByUserId(String userId);
}
