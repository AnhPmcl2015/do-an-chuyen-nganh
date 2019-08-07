/** Copyright Aug 4, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import topfactors.bus.define.IUserService;
import topfactors.common.dto.ApiResponseDto;
import topfactors.common.form.CandidateSignUpRequest;
import topfactors.dao.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserSerivceTest {
	
	@InjectMocks IUserService userServiceImpl;
	
	@Test
	public void registerNewCandidate() {
		CandidateSignUpRequest form = new CandidateSignUpRequest();
		form.setUsername("AnhPmcl2015123");
		form.setFullName("Phan Thế Anh");
		form.setPhoneNumber("01283440245");
		form.setPassword("AnhPmcl2015");
		
		
		ApiResponseDto dto = new ApiResponseDto(true, "");
		
		assertEquals(dto, 
				this.userServiceImpl.registerNewCandidate(form));
	}
}
