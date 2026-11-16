package finalgame;

public class InvalidAccusationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int invalidSuspectNumber;
	public InvalidAccusationException(String message,int invalidSuspectNumber) {
		 super(message);
		 this.invalidSuspectNumber = invalidSuspectNumber;
	}
	public int getInvalidSuspectNumber() {
	    return invalidSuspectNumber;
	}

}
