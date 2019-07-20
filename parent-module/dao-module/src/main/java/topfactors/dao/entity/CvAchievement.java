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
@Table(name = "cv_achievement", catalog = "topfactors")
public class CvAchievement implements java.io.Serializable {
	private static final long serialVersionUID = 7112267561016924137L;
	private long id;
	private Cv cv;
	private String cvAchievementName;
	private Date inDate;

	public CvAchievement() {
	}

	public CvAchievement(long id, Cv cv, String cvAchievementName) {
		this.id = id;
		this.cv = cv;
		this.cvAchievementName = cvAchievementName;
	}

	public CvAchievement(long id, Cv cv, String cvAchievementName, Date inDate) {
		this.id = id;
		this.cv = cv;
		this.cvAchievementName = cvAchievementName;
		this.inDate = inDate;
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

	@Column(name = "cv_achievement_name", nullable = false, length = 100)
	public String getCvAchievementName() {
		return this.cvAchievementName;
	}

	public void setCvAchievementName(String cvAchievementName) {
		this.cvAchievementName = cvAchievementName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "in_date", length = 10)
	public Date getInDate() {
		return this.inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

}
