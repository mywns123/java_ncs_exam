package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class EmptyTfException  extends RuntimeException {

	public EmptyTfException() {
		super("��� �Է��ϼ���.");		
	}

	public EmptyTfException(String message) {
		super(message);		
	}

	public EmptyTfException(Throwable cause) {
		super("��� �Է��ϼ���.",cause);	
	}
}
