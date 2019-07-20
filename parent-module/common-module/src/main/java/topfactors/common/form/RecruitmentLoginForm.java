package topfactors.common.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class RecruitmentLoginForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1122901497778376392L;

	@NotBlank
	private String usernameOrEmail;

	@NotBlank
	private String password;

	public RecruitmentLoginForm(@NotBlank String usernameOrEmail, @NotBlank String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}

	public RecruitmentLoginForm() {
		super();
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
