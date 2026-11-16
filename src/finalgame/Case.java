package finalgame;

public class Case implements Reportable {
		private String caseId;
		private String title;
		private String description;
		

	public Case(String caseId,String title,String description) {
		 if (caseId == null || caseId.isBlank()) {
		        throw new IllegalArgumentException("Case ID cannot be empty");
		    }

		    if (title == null || title.isBlank()) {
		        throw new IllegalArgumentException("Case title cannot be empty");
		    }

		    if (description == null || description.isBlank()) {
		        throw new IllegalArgumentException("Case description cannot be empty");
		    }

		    this.caseId = caseId;
		    this.title = title;
		    this.description = description;
		
		
	}
	public void showCaseInfo() {
		System.out.println("Case ID: " + caseId);
		System.out.println("Title: " + title);
		System.out.println("Description: " + description);
		
	}
	@Override
	public String getReportDetails() {
	    return "Case ID: " + caseId
	         + "\nTitle: " + title
	         + "\nDescription: " + description;
	}
	@Override
	public String toString() {
	    return "Case ID: " + caseId
	            + "\nTitle: " + title
	            + "\nDescription: " + description;
	}
	
}
