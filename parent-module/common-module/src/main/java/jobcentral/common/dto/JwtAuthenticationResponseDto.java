package jobcentral.common.dto;

import jobcentral.constant.Constant;

public class JwtAuthenticationResponseDto {
	private String accessToken;
	private String tokenType = Constant.TOKEN_TYPE;

	public JwtAuthenticationResponseDto(String accessToken) {
		super();
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}
