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
import javax.persistence.Table;

@Entity
@Table(name = "evalution_detail", catalog = "topfactors")
public class EvalutionDetail implements java.io.Serializable {

	private static final long serialVersionUID = 477840323059309156L;
	private long id;
	private Evalution evalution;
	private float point8;
	private String evalution_1;
	private String skillName;
	private Set<SkillDetail> skillDetails = new HashSet<SkillDetail>(0);

	public EvalutionDetail() {
	}

	public EvalutionDetail(long id, Evalution evalution, float point8) {
		this.id = id;
		this.evalution = evalution;
		this.point8 = point8;
	}

	public EvalutionDetail(long id, Evalution evalution, float point8, String evalution_1, String skillName,
			Set<SkillDetail> skillDetails) {
		this.id = id;
		this.evalution = evalution;
		this.point8 = point8;
		this.evalution_1 = evalution_1;
		this.skillName = skillName;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "evalution_id", nullable = false)
	public Evalution getEvalution() {
		return this.evalution;
	}

	public void setEvalution(Evalution evalution) {
		this.evalution = evalution;
	}

	@Column(name = "point8", nullable = false, precision = 12, scale = 0)
	public float getPoint8() {
		return this.point8;
	}

	public void setPoint8(float point8) {
		this.point8 = point8;
	}

	@Column(name = "evalution", length = 100)
	public String getEvalution_1() {
		return this.evalution_1;
	}

	public void setEvalution_1(String evalution_1) {
		this.evalution_1 = evalution_1;
	}

	@Column(name = "skill_name", length = 50)
	public String getSkillName() {
		return this.skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "evalution_skill", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "evalution_detail_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "skill_detail_id", nullable = false, updatable = false) })
	public Set<SkillDetail> getSkillDetails() {
		return this.skillDetails;
	}

	public void setSkillDetails(Set<SkillDetail> skillDetails) {
		this.skillDetails = skillDetails;
	}

}