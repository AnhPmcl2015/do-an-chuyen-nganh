package jobcentral.common.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class UserLoginForm implements Serializable {

	@NotBlank
	private String usernameOrEmail;

	@NotBlank
	private String password;

	public UserLoginForm(@NotBlank String usernameOrEmail, @NotBlank String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
