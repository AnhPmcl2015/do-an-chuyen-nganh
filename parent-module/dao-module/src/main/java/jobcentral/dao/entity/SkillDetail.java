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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "skill_detail", catalog = "topfactors")
public class SkillDetail implements java.io.Serializable {
	private static final long serialVersionUID = 4937635718353607325L;
	private long id;
	private Skill skill;
	private String skillDetailName;
	private Set<EvalutionDetail> evalutionDetails = new HashSet<EvalutionDetail>(0);

	public SkillDetail() {
	}

	public SkillDetail(long id, Skill skill, String skillDetailName) {
		this.id = id;
		this.skill = skill;
		this.skillDetailName = skillDetailName;
	}

	public SkillDetail(long id, Skill skill, String skillDetailName, Set<EvalutionDetail> evalutionDetails) {
		this.id = id;
		this.skill = skill;
		this.skillDetailName = skillDetailName;
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
	@JoinColumn(name = "skill_id", nullable = false)
	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Column(name = "skill_detail_name", nullable = false, length = 100)
	public String getSkillDetailName() {
		return this.skillDetailName;
	}

	public void setSkillDetailName(String skillDetailName) {
		this.skillDetailName = skillDetailName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "evalution_skill", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "skill_detail_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "evalution_detail_id", nullable = false, updatable = false) })
	public Set<EvalutionDetail> getEvalutionDetails() {
		return this.evalutionDetails;
	}

	public void setEvalutionDetails(Set<EvalutionDetail> evalutionDetails) {
		this.evalutionDetails = evalutionDetails;
	}

}
