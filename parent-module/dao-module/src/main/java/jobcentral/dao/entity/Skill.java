package jobcentral.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill", catalog = "topfactors")
public class Skill implements java.io.Serializable {

	private static final long serialVersionUID = 2237897451660006354L;
	private long id;
	private String skillName;
	private Set<RecruitmentPost> recruitmentPosts = new HashSet<RecruitmentPost>(0);
	private Set<SkillDetail> skillDetails = new HashSet<SkillDetail>(0);

	public Skill() {
	}

	public Skill(long id, String skillName) {
		this.id = id;
		this.skillName = skillName;
	}

	public Skill(long id, String skillName, Set<RecruitmentPost> recruitmentPosts, Set<SkillDetail> skillDetails) {
		this.id = id;
		this.skillName = skillName;
		this.recruitmentPosts = recruitmentPosts;
		this.skillDetails = skillDetails;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "skill_name", nullable = false, length = 100)
	public String getSkillName() {
		return this.skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recruitment_post_skill", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "skill_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) })
	public Set<RecruitmentPost> getRecruitmentPosts() {
		return this.recruitmentPosts;
	}

	public void setRecruitmentPosts(Set<RecruitmentPost> recruitmentPosts) {
		this.recruitmentPosts = recruitmentPosts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "skill")
	public Set<SkillDetail> getSkillDetails() {
		return this.skillDetails;
	}

	public void setSkillDetails(Set<SkillDetail> skillDetails) {
		this.skillDetails = skillDetails;
	}

}
