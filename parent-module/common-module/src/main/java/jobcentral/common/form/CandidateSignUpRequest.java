package jobcentral.common.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CandidateSignUpRequest {

	@NotBlank
	@Size(min = 5, max = 15)
	private String username;

	@NotBlank
	private String fullName;

	@NotBlank
	@Size(min = 5, max = 20)
	private String password;

	@NotBlank
	private String phoneNumber;

	public CandidateSignUpRequest(@NotBlank @Size(min = 5, max = 15) String username, @NotBlank String fullName,
			@NotBlank @Size(min = 5, max = 20) String password, @NotBlank String phoneNumber) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public CandidateSignUpRequest() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
