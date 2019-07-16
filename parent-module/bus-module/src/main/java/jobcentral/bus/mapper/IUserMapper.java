package jobcentral.bus.mapper;

import jobcentral.common.form.CandidateSignUpRequest;
import jobcentral.dao.entity.AppUser;

public interface IUserMapper {
	void mapCandidateSignUpRequestToUser(CandidateSignUpRequest candidateSignUpRequest, AppUser appUser);
}
