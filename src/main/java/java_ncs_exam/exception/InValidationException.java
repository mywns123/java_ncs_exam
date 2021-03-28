package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class InValidationException extends RuntimeException{

	public InValidationException() {
		super("형식이 맞지 않습니다.");		
	}

	public InValidationException(String message) {
		super(message);		
	}

	public InValidationException(Throwable cause) {
		super("형식이 맞지 않습니다.",cause);	
	}

}
