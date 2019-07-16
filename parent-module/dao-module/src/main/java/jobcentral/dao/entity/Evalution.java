package jobcentral.dao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jobcentral.common.base.UserDateAudit;

@Entity
@Table(name = "evalution", catalog = "topfactors")
public class Evalution extends UserDateAudit {

	private static final long serialVersionUID = 5214719905174437862L;
	private long id;
	private AppUser appUser;
	private Assessor assessor;
	private String major;
	private String communication;
	private Date workingFrom;
	private Date workingTo;
	private String abilityOfDevelopment;
	private String otherEvalutions;
	private String accessCode;
	private float totalPoint8;
	private Date activeTime;
	private Set<EvalutionDetail> evalutionDetails = new HashSet<EvalutionDetail>(0);

	public Evalution() {
	}

	public Evalution(long id, AppUser appUser, String major, String communication, Date workingFrom, Date workingTo,
			String abilityOfDevelopment, float totalPoint8) {
		this.id = id;
		this.appUser = appUser;
		this.major = major;
		this.communication = communication;
		this.workingFrom = workingFrom;
		this.workingTo = workingTo;
		this.abilityOfDevelopment = abilityOfDevelopment;
		this.totalPoint8 = totalPoint8;
	}

	public Evalution(long id, AppUser appUser, Assessor assessor, String major, String communication, Date workingFrom,
			Date workingTo, String abilityOfDevelopment, String otherEvalutions, String accessCode, float totalPoint8,
			Date activeTime, Set<EvalutionDetail> evalutionDetails) {
		this.id = id;
		this.appUser = appUser;
		this.assessor = assessor;
		this.major = major;
		this.communication = communication;
		this.workingFrom = workingFrom;
		this.workingTo = workingTo;
		this.abilityOfDevelopment = abilityOfDevelopment;
		this.otherEvalutions = otherEvalutions;
		this.accessCode = accessCode;
		this.totalPoint8 = totalPoint8;
		this.activeTime = activeTime;
		this.evalutionDetails = evalutionDetails;
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
	@JoinColumn(name = "user_id", nullable = false)
	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assessor_id")
	public Assessor getAssessor() {
		return this.assessor;
	}

	public void setAssessor(Assessor assessor) {
		this.assessor = assessor;
	}

	@Column(name = "major", nullable = false, length = 300)
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "communication", nullable = false, length = 300)
	public String getCommunication() {
		return this.communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "working_from", nullable = false, length = 10)
	public Date getWorkingFrom() {
		return this.workingFrom;
	}

	public void setWorkingFrom(Date workingFrom) {
		this.workingFrom = workingFrom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "working_to", nullable = false, length = 10)
	public Date getWorkingTo() {
		return this.workingTo;
	}

	public void setWorkingTo(Date workingTo) {
		this.workingTo = workingTo;
	}

	@Column(name = "ability_of_development", nullable = false, length = 300)
	public String getAbilityOfDevelopment() {
		return this.abilityOfDevelopment;
	}

	public void setAbilityOfDevelopment(String abilityOfDevelopment) {
		this.abilityOfDevelopment = abilityOfDevelopment;
	}

	@Column(name = "other_evalutions", length = 300)
	public String getOtherEvalutions() {
		return this.otherEvalutions;
	}

	public void setOtherEvalutions(String otherEvalutions) {
		this.otherEvalutions = otherEvalutions;
	}

	@Column(name = "access_code", length = 100)
	public String getAccessCode() {
		return this.accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	@Column(name = "total_point8", nullable = false, precision = 12, scale = 0)
	public float getTotalPoint8() {
		return this.totalPoint8;
	}

	public void setTotalPoint8(float totalPoint8) {
		this.totalPoint8 = totalPoint8;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "active_time", length = 19)
	public Date getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "evalution")
	public Set<EvalutionDetail> getEvalutionDetails() {
		return this.evalutionDetails;
	}

	public void setEvalutionDetails(Set<EvalutionDetail> evalutionDetails) {
		this.evalutionDetails = evalutionDetails;
	}

}
