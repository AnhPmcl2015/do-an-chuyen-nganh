package topfactors.dao.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "cv_work_experience", catalog = "topfactors")
public class CvWorkExperience implements java.io.Serializable {
	private static final long serialVersionUID = 5811320166262261133L;
	private long id;
	private Cv cv;
	private String companyName;
	private String lastPosition;
	private Date workingFrom;
	private Date workingTo;
	private String shortDescription;

	public CvWorkExperience() {
	}

	public CvWorkExperience(long id, Cv cv, String companyName, String lastPosition, Date workingFrom) {
		this.id = id;
		this.cv = cv;
		this.companyName = companyName;
		this.lastPosition = lastPosition;
		this.workingFrom = workingFrom;
	}

	public CvWorkExperience(long id, Cv cv, String companyName, String lastPosition, Date workingFrom, Date workingTo,
			String shortDescription) {
		this.id = id;
		this.cv = cv;
		this.companyName = companyName;
		this.lastPosition = lastPosition;
		this.workingFrom = workingFrom;
		this.workingTo = workingTo;
		this.shortDescription = shortDescription;
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
	@JoinColumn(name = "cv_id", nullable = false)
	public Cv getCv() {
		return this.cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	@Column(name = "company_name", nullable = false, length = 100)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "last_position", nullable = false, length = 50)
	public String getLastPosition() {
		return this.lastPosition;
	}

	public void setLastPosition(String lastPosition) {
		this.lastPosition = lastPosition;
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
	@Column(name = "working_to", length = 10)
	public Date getWorkingTo() {
		return this.workingTo;
	}

	public void setWorkingTo(Date workingTo) {
		this.workingTo = workingTo;
	}

	@Column(name = "short_description", length = 150)
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

}
