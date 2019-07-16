package jobcentral.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cv_template", catalog = "topfactors")
public class CvTemplate implements java.io.Serializable {

	private static final long serialVersionUID = -5747193947879226465L;
	private long id;
	private String template;
	private String css;
	private String thumpnail;
	private Integer descriptionLength;
	private Set<Cv> cvs = new HashSet<Cv>(0);

	public CvTemplate() {
	}

	public CvTemplate(long id, String template, String css) {
		this.id = id;
		this.template = template;
		this.css = css;
	}

	public CvTemplate(long id, String template, String css, String thumpnail, Integer descriptionLength, Set<Cv> cvs) {
		this.id = id;
		this.template = template;
		this.css = css;
		this.thumpnail = thumpnail;
		this.descriptionLength = descriptionLength;
		this.cvs = cvs;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "template", nullable = false, length = 65535)
	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Column(name = "css", nullable = false, length = 65535)
	public String getCss() {
		return this.css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	@Column(name = "thumpnail", length = 100)
	public String getThumpnail() {
		return this.thumpnail;
	}

	public void setThumpnail(String thumpnail) {
		this.thumpnail = thumpnail;
	}

	@Column(name = "description_length")
	public Integer getDescriptionLength() {
		return this.descriptionLength;
	}

	public void setDescriptionLength(Integer descriptionLength) {
		this.descriptionLength = descriptionLength;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cvTemplate")
	public Set<Cv> getCvs() {
		return this.cvs;
	}

	public void setCvs(Set<Cv> cvs) {
		this.cvs = cvs;
	}

}
