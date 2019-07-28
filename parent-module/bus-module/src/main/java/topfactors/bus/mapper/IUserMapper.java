package topfactors.bus.mapper;

import topfactors.common.form.CandidateSignUpRequest;
import topfactors.common.form.RecruitmentSignUpRequest;
import topfactors.dao.entity.AppUser;
import topfactors.dao.entity.Company;

public interface IUserMapper {
	void mapCandidateSignUpRequestToUser(CandidateSignUpRequest candidateSignUpRequest, AppUser appUser);
	void mapRecruitmentSignUpRequestToUser(RecruitmentSignUpRequest recruitmentSignUpRequest, AppUser appUser, Company company);
}
