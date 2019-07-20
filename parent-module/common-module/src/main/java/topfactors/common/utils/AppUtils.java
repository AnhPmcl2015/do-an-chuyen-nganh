package topfactors.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import topfactors.common.exception.BadRequestException;
import topfactors.common.form.CandidateSignUpRequest;
import topfactors.constant.Constant;
import topfactors.constant.ErrorMessage;

@Component
public class AppUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(AppUtils.class);
	
	public void validatePageNumberAndSize(int page, int size) {
		if(page < 0) {
			throw new BadRequestException(ErrorMessage.PAGE_NUMBER_LESS_THAN_0);
		}
		
		if(size > Constant.MAX_PAGE_SIZE) {
			throw new BadRequestException(String.format(ErrorMessage.PAGE_SIZE_GREATER_THAN, Constant.MAX_PAGE_SIZE));
		}
	}
	
	/**
	 * Validate tính hợp lệ của các trường trong form mà thư viện validate không hỗ trợ
	 * @param form
	 */
	public String validateCandidateSignUpRequest(CandidateSignUpRequest form) {
		String result = "";
		
		if(!Pattern.matches(Constant.REGEX_USERNAME, form.getUsername())) {
			result += String.format(ErrorMessage.USERNAME_NOT_AVAILABLE , form.getUsername()) + Constant.BREAK_LINE;
		}
		
		if(!Pattern.matches(Constant.REGEX_PASSWORD, form.getPassword())) {
			result += ErrorMessage.PASSWORD_NOT_AVAILABLE;
		}
		
		return result;
	}
	
	
	/**
	 * Tạo ra mã tự động sử dụng hex
	 * @return
	 */
	public String generateIdUsingHex() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(1000) + 500 + 1; // Từ 500 -> 1500
		String hex = Integer.toHexString(randomNumber) + Integer.toHexString(randomNumber - 100) + Integer.toHexString(randomNumber) + 100;
		
		LocalDateTime now = LocalDateTime.now();
		String nowString = now.format(DateTimeFormatter.ofPattern(Constant.AUTO_ID_DATE_TIME));
		
		return hex + nowString;
	}
	
	/**
	 * Tạo mã OTP tự động
	 * @return
	 */
	public String generateOTPAndAccessCode() {
		Random rand = new Random();
		return rand.nextInt(900000) + 100000 + "";
	}
	
	/**
	 * Gửi sms
	 * @param phoneNumber
	 */
	public void sendSMS(String phoneNumber , String OTP) {
		Twilio.init(Constant.SMS_ACCOUNT_SID, Constant.AUTH_TOKEN);
		
		Message message = Message
				.creator(new PhoneNumber("+84783550324"), new PhoneNumber(Constant.PHONE_NUMBER), "Mã OTP: " + OTP).create();
		
		logger.info(message.getSid());
	}
}
