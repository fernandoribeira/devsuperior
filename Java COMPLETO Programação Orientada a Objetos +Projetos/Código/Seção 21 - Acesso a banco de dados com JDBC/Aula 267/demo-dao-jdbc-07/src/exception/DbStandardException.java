package exception;

public class DbStandardException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbStandardException(String message) {
		super(message);
	}
	
}
