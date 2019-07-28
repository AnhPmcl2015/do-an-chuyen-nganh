/** Copyright Jul 21, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.bus.define;

import topfactors.common.base.IBaseDao;
import topfactors.dao.entity.LoginHistory;

public interface ILoginHistoryService extends IBaseDao<LoginHistory>{
	void insertOrUpdate(String usernameOrPhoneNumberOrEmail, String accessToken);
}
