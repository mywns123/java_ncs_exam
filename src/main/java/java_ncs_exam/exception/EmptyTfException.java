package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class EmptyTfException  extends RuntimeException {

	public EmptyTfException() {
		super("���� ����");		
	}

	public EmptyTfException(String message) {
		super(message);		
	}

	public EmptyTfException(Throwable cause) {
		super("���� ����",cause);	
	}
}
