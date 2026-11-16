package finalgame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CaseFileReader {

	public void readCaseFile(String fileName) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        int lineCount = 0;
	        String[] expectedFields = {
	        	    "Case ID", "Title", "Description", "Location", "Status"
	        	};

	        while ((line = reader.readLine()) != null) {
	        	if (line.isBlank() || !line.contains(":")) {
	        	    System.out.println("Invalid case file format.");
	        	    return;
	        	}
	        	String[] parts = line.split(":", 2);

	        	if (lineCount >= expectedFields.length
	        	        || !parts[0].trim().equals(expectedFields[lineCount])
	        	        || parts[1].trim().isEmpty()) {
	        	    System.out.println("Invalid case file information.");
	        	    return;
	        	}

	        	lineCount++;
	        	System.out.println(line);
	            
	        }
	        if (lineCount != expectedFields.length) {
	            System.out.println("Invalid case file: Expected 5 fields, found " + lineCount);
	        }

	    } catch (IOException e) {
	        System.out.println("Error reading case file: " + e.getMessage());
	    }
	}
}
