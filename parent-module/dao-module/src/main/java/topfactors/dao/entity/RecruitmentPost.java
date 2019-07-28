package topfactors.dao.entity;
// Generated Jul 10, 2019 11:32:10 PM by Hibernate Tools 4.3.1.Final

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import topfactors.common.base.UserDateAudit;

@Entity
@Table(name = "recruitment_post", catalog = "topfactors")
public class RecruitmentPost extends UserDateAudit {

	private static final long serialVersionUID = -6680587827726856071L;
	private String id;
	private AppUser appUser;
	private String title;
	private Date expiredDate;
	private String shortDescription;
	private Integer offerFrom;
	private Integer offerTo;
	private String requirement;
	private String benefit;
	private Set<Cv> cvs = new HashSet<Cv>(0);
	private Set<Experience> experiences = new HashSet<Experience>(0);
	private Set<Skill> skills = new HashSet<Skill>(0);
	private Set<Tag> tags = new HashSet<Tag>(0);
	private Set<Major> majors = new HashSet<Major>(0);

	public RecruitmentPost() {
	}

	public RecruitmentPost(String id, AppUser appUser, String title, Date expiredDate, String shortDescription,
			String requirement, String benefit) {
		this.id = id;
		this.appUser = appUser;
		this.title = title;
		this.expiredDate = expiredDate;
		this.shortDescription = shortDescription;
		this.requirement = requirement;
		this.benefit = benefit;
	}

	public RecruitmentPost(String id, AppUser appUser, String title, Date expiredDate, String shortDescription,
			Integer offerFrom, Integer offerTo, String requirement, String benefit, Set<Cv> cvs,
			Set<Experience> experiences, Set<Skill> skills, Set<Tag> tags, Set<Major> majors) {
		this.id = id;
		this.appUser = appUser;
		this.title = title;
		this.expiredDate = expiredDate;
		this.shortDescription = shortDescription;
		this.offerFrom = offerFrom;
		this.offerTo = offerTo;
		this.requirement = requirement;
		this.benefit = benefit;
		this.cvs = cvs;
		this.experiences = experiences;
		this.skills = skills;
		this.tags = tags;
		this.majors = majors;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recruitment_id", nullable = false)
	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "expired_date", nullable = false, length = 10)
	public Date getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Column(name = "short_description", nullable = false, length = 200)
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Column(name = "offer_from")
	public Integer getOfferFrom() {
		return this.offerFrom;
	}

	public void setOfferFrom(Integer offerFrom) {
		this.offerFrom = offerFrom;
	}

	@Column(name = "offer_to")
	public Integer getOfferTo() {
		return this.offerTo;
	}

	public void setOfferTo(Integer offerTo) {
		this.offerTo = offerTo;
	}

	@Column(name = "requirement", nullable = false, length = 300)
	public String getRequirement() {
		return this.requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	@Column(name = "benefit", nullable = false, length = 300)
	public String getBenefit() {
		return this.benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cv_recruitment_post", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "cv_id", nullable = false, updatable = false) })
	public Set<Cv> getCvs() {
		return this.cvs;
	}

	public void setCvs(Set<Cv> cvs) {
		this.cvs = cvs;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recruitment_post_experience", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "experience_id", nullable = false, updatable = false) })
	public Set<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recruitment_post_skill", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "skill_id", nullable = false, updatable = false) })
	public Set<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recruitment_post_tag", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "tag_id", nullable = false, updatable = false) })
	public Set<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recruitment_post_major", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "major_id", nullable = false, updatable = false) })
	public Set<Major> getMajors() {
		return this.majors;
	}

	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}

}