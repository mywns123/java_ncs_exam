package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class InValidationException extends RuntimeException{

	public InValidationException() {
		super("������ ���� �ʽ��ϴ�.");		
	}

	public InValidationException(String message) {
		super(message);		
	}

	public InValidationException(Throwable cause) {
		super("������ ���� �ʽ��ϴ�.",cause);	
	}

}
