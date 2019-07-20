package topfactors.dao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import topfactors.common.base.UserDateAudit;

@Entity
@Table(name = "cv", catalog = "topfactors")
public class Cv extends UserDateAudit {

	private static final long serialVersionUID = -6218492953509945405L;
	private long id;
	private AppUser appUser;
	private CvTemplate cvTemplate;
	private Date dateOfBirth;
	private String lastestStudyPlace;
	private String website;
	private String shortDescription;
	private Set<RecruitmentPost> recruitmentPosts = new HashSet<RecruitmentPost>(0);
	private Set<CvAchievement> cvAchievements = new HashSet<CvAchievement>(0);
	private Set<CvWorkExperience> cvWorkExperiences = new HashSet<CvWorkExperience>(0);
	private Set<CvEducation> cvEducations = new HashSet<CvEducation>(0);
	private Set<CvSkill> cvSkills = new HashSet<CvSkill>(0);

	public Cv() {
	}

	public Cv(long id, AppUser appUser, Date dateOfBirth, String lastestStudyPlace, String shortDescription) {
		this.id = id;
		this.appUser = appUser;
		this.dateOfBirth = dateOfBirth;
		this.lastestStudyPlace = lastestStudyPlace;
		this.shortDescription = shortDescription;
	}

	public Cv(long id, AppUser appUser, CvTemplate cvTemplate, Date dateOfBirth, String lastestStudyPlace,
			String website, String shortDescription, Set<RecruitmentPost> recruitmentPosts,
			Set<CvAchievement> cvAchievements, Set<CvWorkExperience> cvWorkExperiences, Set<CvEducation> cvEducations,
			Set<CvSkill> cvSkills) {
		this.id = id;
		this.appUser = appUser;
		this.cvTemplate = cvTemplate;
		this.dateOfBirth = dateOfBirth;
		this.lastestStudyPlace = lastestStudyPlace;
		this.website = website;
		this.shortDescription = shortDescription;
		this.recruitmentPosts = recruitmentPosts;
		this.cvAchievements = cvAchievements;
		this.cvWorkExperiences = cvWorkExperiences;
		this.cvEducations = cvEducations;
		this.cvSkills = cvSkills;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id", nullable = false)
	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_template_id")
	public CvTemplate getCvTemplate() {
		return this.cvTemplate;
	}

	public void setCvTemplate(CvTemplate cvTemplate) {
		this.cvTemplate = cvTemplate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", nullable = false, length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "lastest_study_place", nullable = false, length = 100)
	public String getLastestStudyPlace() {
		return this.lastestStudyPlace;
	}

	public void setLastestStudyPlace(String lastestStudyPlace) {
		this.lastestStudyPlace = lastestStudyPlace;
	}

	@Column(name = "website", length = 100)
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "short_description", nullable = false, length = 300)
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cv_recruitment_post", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "cv_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) })
	public Set<RecruitmentPost> getRecruitmentPosts() {
		return this.recruitmentPosts;
	}

	public void setRecruitmentPosts(Set<RecruitmentPost> recruitmentPosts) {
		this.recruitmentPosts = recruitmentPosts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cv")
	public Set<CvAchievement> getCvAchievements() {
		return this.cvAchievements;
	}

	public void setCvAchievements(Set<CvAchievement> cvAchievements) {
		this.cvAchievements = cvAchievements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cv")
	public Set<CvWorkExperience> getCvWorkExperiences() {
		return this.cvWorkExperiences;
	}

	public void setCvWorkExperiences(Set<CvWorkExperience> cvWorkExperiences) {
		this.cvWorkExperiences = cvWorkExperiences;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cv")
	public Set<CvEducation> getCvEducations() {
		return this.cvEducations;
	}

	public void setCvEducations(Set<CvEducation> cvEducations) {
		this.cvEducations = cvEducations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cv")
	public Set<CvSkill> getCvSkills() {
		return this.cvSkills;
	}

	public void setCvSkills(Set<CvSkill> cvSkills) {
		this.cvSkills = cvSkills;
	}

}
