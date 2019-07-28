/** Copyright Jul 21, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.bus.define.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topfactors.bus.define.ICompanyService;
import topfactors.dao.entity.Company;
import topfactors.dao.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements ICompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdate(Company t, boolean updateOnly) {
		this.companyRepository.saveAndFlush(t);
	}

	@Override
	public void delete(Company t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePermanently(Company t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company findByAbbreviation(String abbreviation) {
		Optional<Company> companyOpt = this.companyRepository.findByAbbreviation(abbreviation);
		
		if(companyOpt.isPresent()) {
			return companyOpt.get();
		}
		return null;
	}

}
