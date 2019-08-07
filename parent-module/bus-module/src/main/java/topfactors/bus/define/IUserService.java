package topfactors.bus.define;

import topfactors.common.dto.ApiResponseDto;
import topfactors.common.form.CandidateSignUpRequest;
import topfactors.common.form.RecruitmentSignUpRequest;
import topfactors.dao.entity.AppUser;

public interface IUserService {
	ApiResponseDto registerNewCandidate(CandidateSignUpRequest form);
	ApiResponseDto registerNewRecruitment(RecruitmentSignUpRequest form);
	AppUser findByUsernameOrPhoneNumberOrEmail(String usernameOrPhoneNumberOrEmail);
	boolean enableAccount(String username, String accessCode);
}
