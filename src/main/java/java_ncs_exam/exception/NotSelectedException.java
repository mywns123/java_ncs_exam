package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class NotSelectedException extends RuntimeException{

	public NotSelectedException() {
		super("선택되지않았습니다.");		
	}

	public NotSelectedException(String message) {
		super(message);		
	}

	public NotSelectedException(Throwable cause) {
		super("선택되지않았습니다.",cause);	
	}
}
