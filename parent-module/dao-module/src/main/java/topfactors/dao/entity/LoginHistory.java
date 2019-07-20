package topfactors.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login_history", catalog = "topfactors")
public class LoginHistory implements java.io.Serializable {

	private static final long serialVersionUID = 3508129358374181378L;
	private Long id;
	private AppUser appUser;
	private String accessToken;
	private Boolean isRemembered;

	public LoginHistory() {
	}

	public LoginHistory(AppUser appUser, String accessToken) {
		this.appUser = appUser;
		this.accessToken = accessToken;
	}

	public LoginHistory(AppUser appUser, String accessToken, Boolean isRemembered) {
		this.appUser = appUser;
		this.accessToken = accessToken;
		this.isRemembered = isRemembered;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@Column(name = "accessToken", nullable = false)
	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Column(name = "is_remembered")
	public Boolean getIsRemembered() {
		return this.isRemembered;
	}

	public void setIsRemembered(Boolean isRemembered) {
		this.isRemembered = isRemembered;
	}

}
