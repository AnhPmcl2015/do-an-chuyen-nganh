package jobcentral.common.utils;

import jobcentral.common.exception.BadRequestException;
import jobcentral.constant.Constant;

public class AppUtils {
	public static void validatePageNumberAndSize(int page, int size) {
		if(page < 0) {
			throw new BadRequestException("Page number cannot be less than zero");
		}
		
		if(size > Constant.MAX_PAGE_SIZE) {
			throw new BadRequestException("Page size must not greater than " + Constant.MAX_PAGE_SIZE);
		}
	}
}
