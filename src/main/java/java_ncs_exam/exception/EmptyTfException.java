package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class EmptyTfException  extends RuntimeException {

	public EmptyTfException() {
		super("모두 입력하세요.");		
	}

	public EmptyTfException(String message) {
		super(message);		
	}

	public EmptyTfException(Throwable cause) {
		super("모두 입력하세요.",cause);	
	}
}
