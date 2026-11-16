package finalgame;

public class InvalidEvidenceException extends Exception {

	private static final long serialVersionUID = 1L;
	//serialization warning for exception classes.
	private String evidenceId;
	public InvalidEvidenceException(String message) {
		   super(message);
	 
	}
	public InvalidEvidenceException(String message, String evidenceId, Throwable cause) {
        super(message, cause);
        this.evidenceId = evidenceId;
    }
	public String getEvidenceId() {
	    return evidenceId;
	}

}
