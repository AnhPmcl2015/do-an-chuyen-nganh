package jobcentral.dao.entity;

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
@Table(name = "app_role", catalog = "topfactors")
public class AppRole implements java.io.Serializable {
	private static final long serialVersionUID = 6059001006527233827L;
	private Long id;
	private String roleName;
	private Set<AppUser> appUsers = new HashSet<AppUser>(0);

	public AppRole() {
	}

	public AppRole(String roleName) {
		this.roleName = roleName;
	}

	public AppRole(String roleName, Set<AppUser> appUsers) {
		this.roleName = roleName;
		this.appUsers = appUsers;
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

	@Column(name = "role_name", nullable = false, length = 50)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set<AppUser> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(Set<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

}
