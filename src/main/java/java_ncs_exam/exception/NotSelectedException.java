package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class NotSelectedException extends RuntimeException{

	public NotSelectedException() {
		super("�ش� ��å�� �����ϼ���.");		
	}

	public NotSelectedException(String message) {
		super(message);		
	}

	public NotSelectedException(Throwable cause) {
		super("�ش� ��å�� �����ϼ���.",cause);	
	}
}
