package jobcentral.dao.entity;

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
@Table(name = "user_category", catalog = "topfactors")
public class UserCategory implements java.io.Serializable {

	private static final long serialVersionUID = 3634943449237835683L;
	private Long id;
	private String userCategoryName;
	private Set<AppUser> appUsers = new HashSet<AppUser>(0);

	public UserCategory() {
	}

	public UserCategory(String userCategoryName) {
		this.userCategoryName = userCategoryName;
	}

	public UserCategory(String userCategoryName, Set<AppUser> appUsers) {
		this.userCategoryName = userCategoryName;
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

	@Column(name = "user_category_name", nullable = false, length = 50)
	public String getUserCategoryName() {
		return this.userCategoryName;
	}

	public void setUserCategoryName(String userCategoryName) {
		this.userCategoryName = userCategoryName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userCategory")
	public Set<AppUser> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(Set<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

}
