package topfactors.common.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class UserLoginForm implements Serializable {

	private static final long serialVersionUID = -3455640124461461930L;

	@NotBlank
	private String usernameOrPhoneNumber;

	@NotBlank
	private String password;

	public UserLoginForm(@NotBlank String usernameOrPhoneNumber, @NotBlank String password) {
		super();
		this.usernameOrPhoneNumber = usernameOrPhoneNumber;
		this.password = password;
	}

	public UserLoginForm() {
		super();
	}

	public String getUsernameOrPhoneNumber() {
		return usernameOrPhoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setUsernameOrPhoneNumber(String usernameOrPhoneNumber) {
		this.usernameOrPhoneNumber = usernameOrPhoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
