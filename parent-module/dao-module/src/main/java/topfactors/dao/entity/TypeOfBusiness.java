package topfactors.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type_of_business", catalog = "topfactors")
public class TypeOfBusiness implements java.io.Serializable {

	private static final long serialVersionUID = -2434441216105187205L;
	private Long id;
	private String typeOfBusinessName;
	private Set<Company> companies = new HashSet<Company>(0);

	public TypeOfBusiness() {
	}

	public TypeOfBusiness(String typeOfBusinessName, Set<Company> companies) {
		this.typeOfBusinessName = typeOfBusinessName;
		this.companies = companies;
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

	@Column(name = "type_of_business_name", length = 100)
	public String getTypeOfBusinessName() {
		return this.typeOfBusinessName;
	}

	public void setTypeOfBusinessName(String typeOfBusinessName) {
		this.typeOfBusinessName = typeOfBusinessName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeOfBusiness")
	public Set<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

}
