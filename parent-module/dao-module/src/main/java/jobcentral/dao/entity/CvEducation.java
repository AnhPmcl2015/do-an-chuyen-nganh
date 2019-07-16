package jobcentral.dao.entity;

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
@Table(name = "cv_education", catalog = "topfactors")
public class CvEducation implements java.io.Serializable {
	private static final long serialVersionUID = -4293569974538876234L;
	private long id;
	private Cv cv;
	private String cvEducationName;
	private Date studyFrom;
	private Date studyTo;
	private String shortDescription;

	public CvEducation() {
	}

	public CvEducation(long id, Cv cv, String cvEducationName) {
		this.id = id;
		this.cv = cv;
		this.cvEducationName = cvEducationName;
	}

	public CvEducation(long id, Cv cv, String cvEducationName, Date studyFrom, Date studyTo, String shortDescription) {
		this.id = id;
		this.cv = cv;
		this.cvEducationName = cvEducationName;
		this.studyFrom = studyFrom;
		this.studyTo = studyTo;
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

	@Column(name = "cv_education_name", nullable = false, length = 100)
	public String getCvEducationName() {
		return this.cvEducationName;
	}

	public void setCvEducationName(String cvEducationName) {
		this.cvEducationName = cvEducationName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "study_from", length = 10)
	public Date getStudyFrom() {
		return this.studyFrom;
	}

	public void setStudyFrom(Date studyFrom) {
		this.studyFrom = studyFrom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "study_to", length = 10)
	public Date getStudyTo() {
		return this.studyTo;
	}

	public void setStudyTo(Date studyTo) {
		this.studyTo = studyTo;
	}

	@Column(name = "short_description", length = 150)
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

}
