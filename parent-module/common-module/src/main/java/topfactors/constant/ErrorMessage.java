package topfactors.constant;

public interface ErrorMessage {
	
	// Lỗi không tìm thấy dữ liệu
	String USERNAME_NOT_FOUND = "Không tìm thấy người dùng với username: %s";
	String USER_ID_NOT_FOUND = "User id không tồn tại: %s";
	String USER_EMAIL_NOT_FOUND = "Không tìm thấy người dùng với email: %s";
	String USER_PHONE_NUMBER_NOT_FOUND = "Không tìm thấy người dùng với số điện thoại: %s";
	String USERNAME_PHONENUMBER_EMAIL_NOT_FOUND = "Không có dữ liệu của username, số điện thoại và email: %s";
	String USER_NOT_FOUND = "Không tìm thấy dữ liệu người dùng";
	String OTP_NOT_FOUND = "Không tìm thấy mã OTP tương ứng";
	
	// Lỗi dữ liệu đã tồn tại
	String PHONE_NUMBER_IS_EXISTED = "Số điện thoại đã được sử dụng: %s";
	String USERNAME_IS_EXISTED = "Tên đăng nhập đã được sử dụng: %s";
	String EMAIL_IS_EXISTED = "Địa chỉ email đã được sử dụng: %s";

	// Lỗi dữ liệu không hợp lệ
	String USERNAME_NOT_AVAILABLE = "Tên đăng nhập không hợp lệ: %s";
	String PASSWORD_NOT_AVAILABLE = "Mật khẩu không hợp lệ";
	String PHONE_NUMBER_AVAILABLE = "Số điện thoại không hợp lệ";
	
	// Lỗi hệ thống
	String ROLE_NOT_SET = "Không có role trong dữ liệu: %s";
	String USER_CATEGORY_NOT_SET = "Không có user category trong dữ liệu: %s";
	String NATION_NOT_SET = "Không có quốc gia trong dữ liệu: %s";

	// Lỗi định dạng dữ liệu
	String INCORRECT_EMAIL_FORMAT = "Email không đúng định dạng: %s";
	
	// Các lỗi khác
	String PAGE_NUMBER_LESS_THAN_0 = "Số thự tự trang không thể dưới 0";
	String PAGE_SIZE_GREATER_THAN = "Số lượng bài viết không thể vượt quá %d";
	String REGISTER_UNSUCCESSFULLY = "Đăng ký không thành công";
}
