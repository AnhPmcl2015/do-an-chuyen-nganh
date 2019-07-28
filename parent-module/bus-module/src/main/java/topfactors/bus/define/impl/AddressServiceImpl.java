/** Copyright Jul 21, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.bus.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topfactors.bus.define.IAddressService;
import topfactors.dao.entity.Address;
import topfactors.dao.repository.AddressRepository;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdate(Address t, boolean updateOnly) {
		this.addressRepository.saveAndFlush(t);
	}

	@Override
	public void delete(Address t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePermanently(Address t) {
		// TODO Auto-generated method stub
		
	}
}
