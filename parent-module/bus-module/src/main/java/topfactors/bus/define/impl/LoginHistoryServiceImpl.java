/** Copyright Jul 21, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.bus.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topfactors.bus.define.ILoginHistoryService;
import topfactors.bus.define.IUserService;
import topfactors.dao.entity.AppUser;
import topfactors.dao.entity.LoginHistory;
import topfactors.dao.repository.LoginHistoryRepository;

@Service
public class LoginHistoryServiceImpl implements ILoginHistoryService{

	@Autowired
	private LoginHistoryRepository loginHistoryRepository;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public LoginHistory findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdate(LoginHistory t, boolean updateOnly) {
		this.loginHistoryRepository.saveAndFlush(t);
	}

	@Override
	public void delete(LoginHistory t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePermanently(LoginHistory t) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Dùng để lưu lại lịch sử đăng nhập của người dùng, bao gồm accessToken và appUser
	 */
	@Override
	public void insertOrUpdate(String usernameOrPhoneNumberOrEmail, String accessToken) {
		AppUser appUser = this.userService.findByUsernameOrPhoneNumberOrEmail(usernameOrPhoneNumberOrEmail);
		LoginHistory loginHistory = new LoginHistory(appUser, accessToken);
		this.insertOrUpdate(loginHistory, false);
		
	}

}
