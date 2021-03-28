package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class EmptyTfException  extends RuntimeException {

	public EmptyTfException() {
		super("공란 존재");		
	}

	public EmptyTfException(String message) {
		super(message);		
	}

	public EmptyTfException(Throwable cause) {
		super("공란 존재",cause);	
	}
}
