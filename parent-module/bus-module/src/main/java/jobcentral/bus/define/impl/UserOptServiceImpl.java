package jobcentral.bus.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobcentral.bus.define.IUserOtpService;
import jobcentral.dao.entity.UserOtp;
import jobcentral.dao.repository.UserOtpRepository;

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
		}
		
		t.setCreatedBy(t.getAppUser().getId());
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

}
