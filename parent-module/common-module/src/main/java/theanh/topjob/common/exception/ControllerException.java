package theanh.topjob.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_GATEWAY)
public class ControllerException extends Exception{

	private static final long serialVersionUID = -9006288170392744485L;
	
	public ControllerException(String message) {
		super(message);
	}
}
