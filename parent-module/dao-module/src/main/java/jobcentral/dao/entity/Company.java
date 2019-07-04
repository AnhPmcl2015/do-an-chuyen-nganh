package jobcentral.dao.entity;
// Generated Jul 5, 2019 1:02:35 AM by Hibernate Tools 4.3.1.Final

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

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name = "company", catalog = "jobcentral")
public class Company implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3505950358274076585L;
	private String id;
	private TypeOfBusiness typeOfBusiness;
	private String companyName;
	private String summary;
	private String shortDescription;
	private String workingTime;
	private String logo;
	private String abbreviation;
	private Set<AppUser> appUsers = new HashSet<AppUser>(0);
	private Set<Major> majors = new HashSet<Major>(0);
	private Set<Address> addresses = new HashSet<Address>(0);

	public Company() {
	}

	public Company(String id, TypeOfBusiness typeOfBusiness, String companyName, String summary,
			String shortDescription, String workingTime, String logo) {
		this.id = id;
		this.typeOfBusiness = typeOfBusiness;
		this.companyName = companyName;
		this.summary = summary;
		this.shortDescription = shortDescription;
		this.workingTime = workingTime;
		this.logo = logo;
	}

	public Company(String id, TypeOfBusiness typeOfBusiness, String companyName, String summary,
			String shortDescription, String workingTime, String logo, String abbreviation, Set<AppUser> appUsers,
			Set<Major> majors, Set<Address> addresses) {
		this.id = id;
		this.typeOfBusiness = typeOfBusiness;
		this.companyName = companyName;
		this.summary = summary;
		this.shortDescription = shortDescription;
		this.workingTime = workingTime;
		this.logo = logo;
		this.abbreviation = abbreviation;
		this.appUsers = appUsers;
		this.majors = majors;
		this.addresses = addresses;
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
	@JoinColumn(name = "type_of_business_id", nullable = false)
	public TypeOfBusiness getTypeOfBusiness() {
		return this.typeOfBusiness;
	}

	public void setTypeOfBusiness(TypeOfBusiness typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}

	@Column(name = "company_name", nullable = false, length = 150)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "summary", nullable = false, length = 200)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "short_description", nullable = false, length = 300)
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Column(name = "working_time", nullable = false, length = 100)
	public String getWorkingTime() {
		return this.workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	@Column(name = "logo", nullable = false, length = 100)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "abbreviation", length = 10)
	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<AppUser> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(Set<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "company_major", catalog = "jobcentral", joinColumns = {
			@JoinColumn(name = "company_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "major_id", nullable = false, updatable = false) })
	public Set<Major> getMajors() {
		return this.majors;
	}

	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
