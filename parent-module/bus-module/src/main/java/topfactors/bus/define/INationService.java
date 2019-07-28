/** Copyright Jul 21, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.bus.define;

import topfactors.common.base.IBaseDao;
import topfactors.dao.entity.Nation;

public interface INationService extends IBaseDao<Nation>{
	Nation findByNationName(String nationName);
}
