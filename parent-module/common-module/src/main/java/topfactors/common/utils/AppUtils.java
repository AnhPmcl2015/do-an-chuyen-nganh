package topfactors.common.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import topfactors.common.exception.BadRequestException;
import topfactors.common.form.CandidateSignUpRequest;
import topfactors.constant.Constant;
import topfactors.constant.ErrorMessage;

@Component
public class AppUtils {

	private static final Logger logger = LoggerFactory.getLogger(AppUtils.class);

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * Kiểm tra số thứ tự của Page và size của mỗi Page
	 * 
	 * @param page
	 * @param size
	 */
	public void validatePageNumberAndSize(int page, int size) {
		if (page < 0) {
			throw new BadRequestException(ErrorMessage.PAGE_NUMBER_LESS_THAN_0);
		}

		if (size > Constant.MAX_PAGE_SIZE) {
			throw new BadRequestException(String.format(ErrorMessage.PAGE_SIZE_GREATER_THAN, Constant.MAX_PAGE_SIZE));
		}
	}

	/**
	 * Validate tính hợp lệ của các trường trong form mà thư viện validate không hỗ
	 * trợ
	 * 
	 * @param form
	 */
	public String validateCandidateSignUpRequest(CandidateSignUpRequest form) {
		String result = "";

		if (!Pattern.matches(Constant.REGEX_USERNAME, form.getUsername())) {
			result += String.format(ErrorMessage.USERNAME_NOT_AVAILABLE, form.getUsername()) + Constant.BREAK_LINE;
		}

		if (!Pattern.matches(Constant.REGEX_PASSWORD, form.getPassword())) {
			result += ErrorMessage.PASSWORD_NOT_AVAILABLE;
		}

		return result;
	}

	/**
	 * Tạo ra mã tự động sử dụng hex
	 * 
	 * @return
	 */
	public String generateIdUsingHex() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(1000) + 500 + 1; // Từ 500 -> 1500
		String hex = Integer.toHexString(randomNumber) + Integer.toHexString(randomNumber - 100)
				+ Integer.toHexString(randomNumber) + 100;

		LocalDateTime now = LocalDateTime.now();
		String nowString = now.format(DateTimeFormatter.ofPattern(Constant.AUTO_ID_DATE_TIME));

		return hex + nowString;
	}

	/**
	 * Tạo mã OTP tự động
	 * 
	 * @return
	 */
	public String generateOTPAndAccessCode() {
		Random rand = new Random();
		return rand.nextInt(900000) + 100000 + "";
	}

	/**
	 * Gửi mail chỉ bao gồm text
	 * @param to
	 */
	public void sendTextMail(String to, String subject, String content) {
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(content);
		
		this.javaMailSender.send(msg);
	}
	
	/**
	 * Gửi mail có bao gồm html template
	 * @param to
	 * @throws MessagingException 
	 */
	public void sendMailWithHtmlTemplate(String to) throws MessagingException {
		MimeMessage msg = this.javaMailSender.createMimeMessage();
		
		boolean multiPart = true;
		
		MimeMessageHelper helper = new MimeMessageHelper(msg, multiPart, "utf-8");
		
		 String htmlMsg = "<h3>Im testing send a HTML email</h3>"
	                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
		 
		 msg.setContent(htmlMsg, "text/html");
		 helper.setTo(to);
		 helper.setSubject("Test send HTML email");
		 
		 this.javaMailSender.send(msg);
		 
	}
	
	/**
	 * Upload file lên server (có thể là hình ảnh, file pdf)
	 * @param request
	 * @param file
	 */
//	public void uploadFile(HttpServletRequest request, MultipartFile[] files) {
//		String uploadRootPath = request.getServletContext().getRealPath("upload");
//		logger.info("uploadRootPath = " + uploadRootPath);
//		
//		File uploadRootDir = new File(uploadRootPath);
//		
//		if(!uploadRootDir.exists()) {
//			uploadRootDir.mkdirs();
//		}
//
//		for(MultipartFile file : files) {
//			// Tên file gốc tại client
//			String name = file.getOriginalFilename();
//			
//			if(name != null && name.length() > 0) {
//				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
//				
//				BufferedOutputStream stream;
//				try {
//					stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//					stream.write(file.getBytes());
//					stream.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				
//			}
//		}
//	}
	
	
	/**
	 * Dùng để lấy ký tự sau dấu @ trong gmail
	 * @param email
	 * @return
	 */
	public String getSymbolAfterAtInEmail(String email) {
		
		Pattern pattern = Pattern.compile(Constant.REGEX_AFTER_AT_SYMBOL_IN_MAIL);
		Matcher m = pattern.matcher(email);
		
		if(m.find()) {
			logger.info(m.group(1));
			return m.group(1).substring(1);
		}
		
		return "";
	}
	
	/**
	 * Thời gian để tự động thực hiện tác vụ đưa lên blockchain
	 * 		0h mỗi ngày
	 */
	@Scheduled(cron = "0 0 0 * * ?")
	public void setScheduleForConvertingIntoBlockChain() {
	}
	
	/**
	 * Dùng để crawl dữ liệu công việc từ các trang có công việc là IT
	 * @param url
	 */
	public void crawlJobs(HashSet<String> links, String url) {
		
		if(!links.contains(url)) {
			try {
				links.add(url);
				System.out.println(url);
				Document document  = Jsoup.connect(url).get();
				Elements elements = document.select("div.job_content");
				
				for (Element e: elements) {
					ArrayList<String> temporary = new ArrayList<>();
					temporary.add(e.outerHtml());
					System.out.println(e.outerHtml());
				}
				
			}catch(IOException e) {
				logger.error("Crawler - ERROR for " + url + ": " + e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		HashSet<String> links = new HashSet<String>();
		new AppUtils().crawlJobs(links, "https://itviec.com/it-jobs/ho-chi-minh-hcm");
	}
}
