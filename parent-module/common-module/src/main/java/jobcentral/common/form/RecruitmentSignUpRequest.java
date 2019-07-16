package jobcentral.common.form;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RecruitmentSignUpRequest implements Serializable{
	
	private static final long serialVersionUID = 8211136418871864965L;


	@Email
	@NotBlank
	private String email;
	
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String companyName;
	
	@NotBlank
	private String companyAddress;

	public RecruitmentSignUpRequest(@Email @NotBlank String email, @NotBlank String username, @NotBlank String password,
			@NotBlank String companyName, @NotBlank String companyAddress) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}

	public RecruitmentSignUpRequest() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	
	
}
