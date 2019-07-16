package jobcentral.constant;

public interface ErrorMessage {
	String USERNAME_NOT_FOUND = "Không tìm thấy người dùng với username: %s";
	String USER_ID_NOT_FOUND = "User id không tồn tại: %s";
	String USER_EMAIL_NOT_FOUND = "Không tìm thấy người dùng với email: %s";
	String USER_PHONE_NUMBER_NOT_FOUND = "Không tìm thấy người dùng với số điện thoại: %s";
	String PAGE_NUMBER_LESS_THAN_0 = "Số thự tự trang không thể dưới 0";
	String PAGE_SIZE_GREATER_THAN = "Số lượng bài viết không thể vượt quá %d";
	String PHONE_NUMBER_IS_EXISTED = "Số điện thoại đã được sử dụng: %s";
	String USERNAME_IS_EXISTED = "Tên đăng nhập đã được sử dụng: %s";
	String USERNAME_NOT_AVAILABLE = "Tên đăng nhập không hợp lệ: %s";
	String PASSWORD_NOT_AVAILABLE = "Mật khẩu không hợp lệ";
	String PHONE_NUMBER_AVAILABLE = "Số điện thoại không hợp lệ";
	String ROLE_NOT_SET = "Không có role trong dữ liệu: %s";
	String USER_CATEGORY_NOT_SET = "Không có user category trong dữ liệu: %s";
}
