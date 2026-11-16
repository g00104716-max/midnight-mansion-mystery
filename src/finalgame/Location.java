package finalgame;

import java.util.List;
import java.util.ArrayList;

public class Location {
	private String name;
	private String description;
	private List<Evidence> evidence;

	
	public Location(String name, String description) {
		if (name == null || name.isBlank()) {
		    throw new IllegalArgumentException("Location name cannot be empty");
		}

		if (description == null || description.isBlank()) {
		    throw new IllegalArgumentException("Location description cannot be empty");
		}

		this.name = name;
		this.description = description;
		this.evidence = new ArrayList<>();
		
	}
		public void addEvidence(Evidence item) {
			if (item == null) {
		        throw new IllegalArgumentException("Cannot add null evidence");
		    }

		    evidence.add(item);
		
		}
		
		public void showEvidence() {
			
			if (evidence.isEmpty()) {
			    System.out.println("No evidence found in this room.");
			    return;
			}
			
			for(Evidence item: evidence) {
				System.out.println(item.getName());
			}
			
			
		}
	

@Override
public String toString() {
    return "Location: " + name
         + "\nDescription: " + description;
}

		
	
}


