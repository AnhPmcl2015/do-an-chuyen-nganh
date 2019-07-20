package topfactors.dao.entity;

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
@Table(name = "experience", catalog = "topfactors")
public class Experience implements java.io.Serializable {

	private static final long serialVersionUID = -7371595894735309101L;
	private Long id;
	private String experienceName;
	private String experienceUrl;
	private Set<RecruitmentPost> recruitmentPosts = new HashSet<RecruitmentPost>(0);

	public Experience() {
	}

	public Experience(String experienceName, String experienceUrl, Set<RecruitmentPost> recruitmentPosts) {
		this.experienceName = experienceName;
		this.experienceUrl = experienceUrl;
		this.recruitmentPosts = recruitmentPosts;
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

	@Column(name = "experience_name", length = 50)
	public String getExperienceName() {
		return this.experienceName;
	}

	public void setExperienceName(String experienceName) {
		this.experienceName = experienceName;
	}

	@Column(name = "experience_url", length = 50)
	public String getExperienceUrl() {
		return this.experienceUrl;
	}

	public void setExperienceUrl(String experienceUrl) {
		this.experienceUrl = experienceUrl;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recruitment_post_experience", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "experience_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) })
	public Set<RecruitmentPost> getRecruitmentPosts() {
		return this.recruitmentPosts;
	}

	public void setRecruitmentPosts(Set<RecruitmentPost> recruitmentPosts) {
		this.recruitmentPosts = recruitmentPosts;
	}

}
