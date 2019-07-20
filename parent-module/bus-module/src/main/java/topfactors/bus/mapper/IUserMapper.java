package topfactors.bus.mapper;

import topfactors.common.form.CandidateSignUpRequest;
import topfactors.dao.entity.AppUser;

public interface IUserMapper {
	void mapCandidateSignUpRequestToUser(CandidateSignUpRequest candidateSignUpRequest, AppUser appUser);
}
