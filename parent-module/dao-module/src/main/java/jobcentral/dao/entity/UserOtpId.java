package jobcentral.dao.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserOtpId implements java.io.Serializable {

	private static final long serialVersionUID = 4856432984083135618L;
	private String userId;
	private String otp;

	public UserOtpId() {
	}

	public UserOtpId(String userId, String otp) {
		this.userId = userId;
		this.otp = otp;
	}

	@Column(name = "user_id", nullable = false, length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "otp", nullable = false, length = 8)
	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserOtpId))
			return false;
		UserOtpId castOther = (UserOtpId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& ((this.getOtp() == castOther.getOtp()) || (this.getOtp() != null && castOther.getOtp() != null
						&& this.getOtp().equals(castOther.getOtp())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + (getOtp() == null ? 0 : this.getOtp().hashCode());
		return result;
	}

}
