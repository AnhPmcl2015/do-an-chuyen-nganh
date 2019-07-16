package jobcentral.bus.define;

import jobcentral.common.dto.ApiResponseDto;
import jobcentral.common.form.CandidateSignUpRequest;

public interface IUserService {
	ApiResponseDto registerNewCandidate(CandidateSignUpRequest form);
}
