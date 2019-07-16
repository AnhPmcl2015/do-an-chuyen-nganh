package jobcentral.dao.entity;
// Generated Jul 10, 2019 11:32:10 PM by Hibernate Tools 4.3.1.Final

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
@Table(name = "nation", catalog = "topfactors")
public class Nation implements java.io.Serializable {
	private static final long serialVersionUID = 2029772254428408844L;
	private Long id;
	private String nationName;
	private Set<Address> addresses = new HashSet<Address>(0);

	public Nation() {
	}

	public Nation(String nationName, Set<Address> addresses) {
		this.nationName = nationName;
		this.addresses = addresses;
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

	@Column(name = "nation_name", length = 50)
	public String getNationName() {
		return this.nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nation")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
