/** Copyright Jul 21, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.bus.define;


import topfactors.common.base.IBaseDao;
import topfactors.dao.entity.Company;

public interface ICompanyService extends IBaseDao<Company>{
	Company findByAbbreviation(String abbreviation);
}
