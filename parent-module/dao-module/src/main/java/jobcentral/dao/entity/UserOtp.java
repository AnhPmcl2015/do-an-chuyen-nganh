package jobcentral.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jobcentral.common.base.UserDateAudit;

@Entity
@Table(name = "user_otp", catalog = "topfactors")
public class UserOtp extends UserDateAudit {
	private static final long serialVersionUID = -7410529356678885035L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	private AppUser appUser;

	@Column(name = "otp", nullable = false, length = 6)
	private String otp;

	@Column(name = "is_enable", nullable = false)
	private Boolean isEnable = true;

	public UserOtp(AppUser appUser, String otp, Boolean isEnable) {
		super();
		this.appUser = appUser;
		this.otp = otp;
		this.isEnable = isEnable;
	}

	public UserOtp() {
		super();
	}

	public Long getId() {
		return id;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public String getOtp() {
		return otp;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

}
