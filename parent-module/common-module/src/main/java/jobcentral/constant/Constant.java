package jobcentral.constant;

public interface Constant {
	
	String SPACE = " ";
	String BREAK_LINE = "<br/>";
	String TOKEN_TYPE = "TopFactors";
	String DEFAULT_PAGE_NUMBER = "0";
	String DEFAULT_PAGE_SIZE = "30";
	
	int MAX_PAGE_SIZE = 50;
	
	String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{5,20})";
	String REGEX_EMAIL = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
	String REGEX_USERNAME = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{5,15})";
	
	String AUTO_ID_DATE_TIME = "ddMMyyyyhhmmss";
	
	String SMS_ACCOUNT_SID = "ACe0d2a05e16a6dbd14380f4cf4e29c504";
	String AUTH_TOKEN = "8f1c5fd1a0bd01c8a3897f7b19229ec4";
	String PHONE_NUMBER = "+12067853959";
}
