/** Copyright Aug 4, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.common.form;

public class SignUpAccessCodeForm {
	private String username;
	private String accessCode;

	public SignUpAccessCodeForm(String username, String accessCode) {
		super();
		this.username = username;
		this.accessCode = accessCode;
	}

	public SignUpAccessCodeForm() {
		super();
	}

	public String getUsername() {
		return this.username;
	}

	public String getAccessCode() {
		return this.accessCode;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	
}
