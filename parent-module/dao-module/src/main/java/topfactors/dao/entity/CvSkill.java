package topfactors.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cv_skill", catalog = "topfactors")
public class CvSkill implements java.io.Serializable {

	private static final long serialVersionUID = 2958482286487274471L;
	private long id;
	private Cv cv;
	private String cvSkillName;
	private long proficiency;

	public CvSkill() {
	}

	public CvSkill(long id, Cv cv, String cvSkillName, long proficiency) {
		this.id = id;
		this.cv = cv;
		this.cvSkillName = cvSkillName;
		this.proficiency = proficiency;
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

	@Column(name = "cv_skill_name", nullable = false, length = 50)
	public String getCvSkillName() {
		return this.cvSkillName;
	}

	public void setCvSkillName(String cvSkillName) {
		this.cvSkillName = cvSkillName;
	}

	@Column(name = "proficiency", nullable = false)
	public long getProficiency() {
		return this.proficiency;
	}

	public void setProficiency(long proficiency) {
		this.proficiency = proficiency;
	}

}
