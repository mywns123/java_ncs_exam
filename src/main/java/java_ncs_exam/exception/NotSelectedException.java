package java_ncs_exam.exception;

@SuppressWarnings("serial")
public class NotSelectedException extends RuntimeException{

	public NotSelectedException() {
		super("���õ����ʾҽ��ϴ�.");		
	}

	public NotSelectedException(String message) {
		super(message);		
	}

	public NotSelectedException(Throwable cause) {
		super("���õ����ʾҽ��ϴ�.",cause);	
	}
}
