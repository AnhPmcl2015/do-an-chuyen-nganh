package topfactors.bus.define;

import topfactors.common.dto.ApiResponseDto;
import topfactors.common.form.CandidateSignUpRequest;

public interface IUserService {
	ApiResponseDto registerNewCandidate(CandidateSignUpRequest form);
}
