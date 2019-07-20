package topfactors.dao.entity;

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

import topfactors.common.base.UserDateAudit;
@Entity
@Table(name = "app_user", catalog = "topfactors")
public class AppUser extends UserDateAudit {
	private static final long serialVersionUID = -8230446261522282146L;
	private String id;
	private Company company;
	private UserCategory userCategory;
	private String fullname;
	private String username;
	private String userPassword;
	private Boolean isDeleted;
	private Boolean isEditable;
	private String phoneNumber;
	private String email;
	private Boolean isEnable;
	private Set<AppRole> appRoles = new HashSet<AppRole>(0);
	private Set<AccountVerificationQueue> accountVerificationQueues = new HashSet<AccountVerificationQueue>(0);
	private Set<LoginHistory> loginHistories = new HashSet<LoginHistory>(0);
	private Set<Address> addresses = new HashSet<Address>(0);
	private Set<Identity> identities = new HashSet<Identity>(0);
	private Set<Evalution> evalutions = new HashSet<Evalution>(0);
	private Set<RecruitmentPost> recruitmentPosts = new HashSet<RecruitmentPost>(0);
	private Set<UserOtp> userOtps = new HashSet<UserOtp>(0);
	private Set<Cv> cvs = new HashSet<Cv>(0);
	private Set<Major> majors = new HashSet<Major>(0);

	public AppUser() {
	}

	public AppUser(String id, Company company, UserCategory userCategory, String fullname, String username,
			String userPassword) {
		this.id = id;
		this.company = company;
		this.userCategory = userCategory;
		this.fullname = fullname;
		this.username = username;
		this.userPassword = userPassword;
	}

	public AppUser(String id, Company company, UserCategory userCategory, String fullname, String username,
			String userPassword, Boolean isDeleted, Boolean isEditable, String phoneNumber, String email,
			Boolean isEnable, Set<AppRole> appRoles, Set<AccountVerificationQueue> accountVerificationQueues,
			Set<LoginHistory> loginHistories, Set<Address> addresses, Set<Identity> identities,
			Set<Evalution> evalutions, Set<RecruitmentPost> recruitmentPosts, Set<UserOtp> userOtps, Set<Cv> cvs,
			Set<Major> majors) {
		this.id = id;
		this.company = company;
		this.userCategory = userCategory;
		this.fullname = fullname;
		this.username = username;
		this.userPassword = userPassword;
		this.isDeleted = isDeleted;
		this.isEditable = isEditable;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isEnable = isEnable;
		this.appRoles = appRoles;
		this.accountVerificationQueues = accountVerificationQueues;
		this.loginHistories = loginHistories;
		this.addresses = addresses;
		this.identities = identities;
		this.evalutions = evalutions;
		this.recruitmentPosts = recruitmentPosts;
		this.userOtps = userOtps;
		this.cvs = cvs;
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
	@JoinColumn(name = "company_id", nullable = true)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_category_id", nullable = false)
	public UserCategory getUserCategory() {
		return this.userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

	@Column(name = "fullname", nullable = false, length = 100)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "user_password", nullable = false, length = 100)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "is_deleted")
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "is_editable")
	public Boolean getIsEditable() {
		return this.isEditable;
	}

	public void setIsEditable(Boolean isEditable) {
		this.isEditable = isEditable;
	}

	@Column(name = "phone_number", length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "is_enable")
	public Boolean getIsEnable() {
		return this.isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", nullable = false, updatable = false) })
	public Set<AppRole> getAppRoles() {
		return this.appRoles;
	}

	public void setAppRoles(Set<AppRole> appRoles) {
		this.appRoles = appRoles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
	public Set<AccountVerificationQueue> getAccountVerificationQueues() {
		return this.accountVerificationQueues;
	}

	public void setAccountVerificationQueues(Set<AccountVerificationQueue> accountVerificationQueues) {
		this.accountVerificationQueues = accountVerificationQueues;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
	public Set<LoginHistory> getLoginHistories() {
		return this.loginHistories;
	}

	public void setLoginHistories(Set<LoginHistory> loginHistories) {
		this.loginHistories = loginHistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
	public Set<Identity> getIdentities() {
		return this.identities;
	}

	public void setIdentities(Set<Identity> identities) {
		this.identities = identities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
	public Set<Evalution> getEvalutions() {
		return this.evalutions;
	}

	public void setEvalutions(Set<Evalution> evalutions) {
		this.evalutions = evalutions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
	public Set<RecruitmentPost> getRecruitmentPosts() {
		return this.recruitmentPosts;
	}

	public void setRecruitmentPosts(Set<RecruitmentPost> recruitmentPosts) {
		this.recruitmentPosts = recruitmentPosts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
	public Set<UserOtp> getUserOtps() {
		return this.userOtps;
	}

	public void setUserOtps(Set<UserOtp> userOtps) {
		this.userOtps = userOtps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
	public Set<Cv> getCvs() {
		return this.cvs;
	}

	public void setCvs(Set<Cv> cvs) {
		this.cvs = cvs;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_major", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "major_id", nullable = false, updatable = false) })
	public Set<Major> getMajors() {
		return this.majors;
	}

	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}

}
