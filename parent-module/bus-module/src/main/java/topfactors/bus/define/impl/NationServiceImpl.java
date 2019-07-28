/** Copyright Jul 21, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.bus.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topfactors.bus.define.INationService;
import topfactors.common.exception.AppException;
import topfactors.constant.ErrorMessage;
import topfactors.dao.entity.Nation;
import topfactors.dao.repository.NationRepository;

@Service
public class NationServiceImpl implements INationService {

	@Autowired
	private NationRepository nationRepository;

	@Override
	public Nation findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdate(Nation t, boolean updateOnly) {
		this.nationRepository.saveAndFlush(t);
	}

	@Override
	public void delete(Nation t) {
		// TODO Auto-generated method stub

	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePermanently(Nation t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Nation findByNationName(String nationName) {
		return nationRepository.findByNationName(nationName)
				.orElseThrow(() -> new AppException(String.format(ErrorMessage.NATION_NOT_SET, nationName)));
	}

}
