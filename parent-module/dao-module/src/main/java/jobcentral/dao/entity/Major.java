package jobcentral.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "major", catalog = "topfactors")
public class Major implements java.io.Serializable {

	private static final long serialVersionUID = 3055560176259063811L;
	private Long id;
	private String majorName;
	private String marjorUrl;
	private Set<Company> companies = new HashSet<Company>(0);
	private Set<RecruitmentPost> recruitmentPosts = new HashSet<RecruitmentPost>(0);
	private Set<AppUser> appUsers = new HashSet<AppUser>(0);

	public Major() {
	}

	public Major(String majorName, String marjorUrl, Set<Company> companies, Set<RecruitmentPost> recruitmentPosts,
			Set<AppUser> appUsers) {
		this.majorName = majorName;
		this.marjorUrl = marjorUrl;
		this.companies = companies;
		this.recruitmentPosts = recruitmentPosts;
		this.appUsers = appUsers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "major_name", length = 50)
	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Column(name = "marjor_url", length = 50)
	public String getMarjorUrl() {
		return this.marjorUrl;
	}

	public void setMarjorUrl(String marjorUrl) {
		this.marjorUrl = marjorUrl;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "company_major", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "major_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "company_id", nullable = false, updatable = false) })
	public Set<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recruitment_post_major", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "major_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) })
	public Set<RecruitmentPost> getRecruitmentPosts() {
		return this.recruitmentPosts;
	}

	public void setRecruitmentPosts(Set<RecruitmentPost> recruitmentPosts) {
		this.recruitmentPosts = recruitmentPosts;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_major", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "major_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set<AppUser> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(Set<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

}
