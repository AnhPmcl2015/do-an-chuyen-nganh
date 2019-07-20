package topfactors.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "assessor", catalog = "topfactors")
public class Assessor implements java.io.Serializable {
	private static final long serialVersionUID = 6930274815106933915L;
	private long id;
	private String fullname;
	private String email;
	private String company;
	private String currentPosition;
	private Set<Evalution> evalutions = new HashSet<Evalution>(0);

	public Assessor() {
	}

	public Assessor(long id, String fullname, String email, String company, String currentPosition) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.company = company;
		this.currentPosition = currentPosition;
	}

	public Assessor(long id, String fullname, String email, String company, String currentPosition,
			Set<Evalution> evalutions) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.company = company;
		this.currentPosition = currentPosition;
		this.evalutions = evalutions;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "fullname", nullable = false, length = 100)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "company", nullable = false, length = 100)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "current_position", nullable = false, length = 50)
	public String getCurrentPosition() {
		return this.currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assessor")
	public Set<Evalution> getEvalutions() {
		return this.evalutions;
	}

	public void setEvalutions(Set<Evalution> evalutions) {
		this.evalutions = evalutions;
	}

}
