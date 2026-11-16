package finalgame;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
public class Investigation implements Reportable {
	private List<Evidence> collectedEvidence;
	private Set<String> visitedLocations;
	private boolean solved;
	private Case currentCase;
	private Map<String, Boolean> interviewedCharacters;
	private InvestigationStrategy strategy;
	public void addEvidence(Evidence evidence, EvidenceDiscoveryCallback callback) throws InvalidEvidenceException {
		
		if (evidence == null) {
		    throw new InvalidEvidenceException("Cannot collect null evidence.");
		}
		try {
		    if (evidence.getId().isBlank()) {
		        throw new IllegalArgumentException("Evidence ID is blank");
		    }
		} catch (IllegalArgumentException e) {
			throw new InvalidEvidenceException(
				    "Invalid evidence information",
				    evidence.getId(),
				    e
				);
		}
	    
	    if (!collectedEvidence.contains(evidence)) {
	        collectedEvidence.add(evidence);

	        if (callback != null) {
	            callback.onEvidenceDiscovered(evidence);
	        }
	    }
	}
	public void sortEvidenceById() {
	    Collections.sort(collectedEvidence);
	}
	public void sortEvidenceByRelevance() {
	    Collections.sort(collectedEvidence, new EvidenceRelevanceComparator());
	}
	public void showCollectedEvidence() {
	    if (collectedEvidence.isEmpty()) {
	        System.out.println("You haven't collected any evidence yet.");
	    } 
	    else {
	        for (Evidence evidence : collectedEvidence) {
	            evidence.examine();
	            evidence.showExaminationHint();
	        }
	    }
	    }
	
	public Investigation(Case currentCase) {
		if (currentCase == null) {
		    throw new IllegalArgumentException("Current case cannot be null");
		}
		
		this.currentCase=currentCase;
		this.collectedEvidence = new ArrayList<>();
		this.visitedLocations = new HashSet<>();
		this.solved=false;
		this.interviewedCharacters = new HashMap<>();
	}
	public void setStrategy(InvestigationStrategy strategy) {
		if (strategy == null) {
		    throw new IllegalArgumentException("Investigation strategy cannot be null");
		}
	    this.strategy = strategy;
	}

	public void performInvestigation() {
	    if (strategy != null) {
	        strategy.investigate();
	    }
	}
	
	public void recordInterview(String characterName) {
		if (characterName == null || characterName.isBlank()) {
	        throw new IllegalArgumentException("Character name cannot be empty");
	    }
	    interviewedCharacters.put(characterName, true);
	}
	public int getInterviewCount() {
	    return interviewedCharacters.size();
	}
	public int getEvidenceCount() {
	    return collectedEvidence.size();
	}
	
	public void addVisitedLocation(String location) {
		if (location == null || location.isBlank()) {
	        throw new IllegalArgumentException("Location name cannot be empty");
	    }
		visitedLocations.add(location);
		
		
	}
	public int getVisitedLocationCount() {
		return visitedLocations.size();
	}
	
	public void setSolved() {
		solved=true;
	}
	public boolean isSolved() {
	    return solved;
	}
	public void saveReport() {
		try (FileWriter writer = new FileWriter("investigation_report.txt")) {

			writer.write("INVESTIGATION REPORT\n");
	        writer.write("===== MIDNIGHT MANSION MYSTERY =====\n");
	        writer.write(currentCase.getReportDetails() + "\n");
	        writer.write(getReportDetails() + "\n");
	        System.out.println("Investigation report saved successfully!");
		} catch (IOException e) {

			System.out.println("Error saving report: " + e.getMessage());

		}

	}
	@Override
	public String getReportDetails() {
	    return "Evidence collected: " + getEvidenceCount()
	         + "\nLocations visited: " + getVisitedLocationCount()
	         + "\nInvestigation Status: " + (solved ? "Solved" : "Ongoing");
	}
	@Override
	public String toString() {
	    return "Investigation Progress"
	            + "\nEvidence collected: " + getEvidenceCount()
	            + "\nLocations visited: " + getVisitedLocationCount()
	            + "\nCharacters interviewed: " + getInterviewCount()
	            + "\nStatus: " + (solved ? "Solved" : "Ongoing");
	}
}
