package finalgame;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Game {

	public Game() {
		
	}

	public static void main(String[] args) {
		System.out.println("===============================");
		System.out.println("    MIDNIGHT MANSION MYSTERY  ");
		System.out.println("===============================");
		
		Evidence ev1= new Evidence("E01","Torn Fabric","Found in the mansion hallway",3);
		Location hallway = new Location("Hallway", "A long hallway connecting the mansion rooms");
		hallway.addEvidence(ev1);
		Location diningRoom = new Location("Dining Room", "A large room where the guests had dinner");
		Case mystery = new Case(
			    "C001",
			    "Midnight Mansion Mystery",
			    "A valuable diamond necklace disappeared during a blackout at Blackwood Mansion."
			);
		Investigation investigation = new Investigation(mystery);
		Character eleanor = new Character(
			    "Eleanor Blackwood",
			    "Mansion Owner",
			    "My diamond necklace disappeared during the blackout!"
			);
		
		Suspect adrian = new Suspect(
			    "Adrian Blackwood",
			    "Suspect",
			    "I am Adrian Blackwood, Eleanor's nephew. I had nothing to do with the missing necklace."
			);
		Witness clara = new Witness(
			    "Clara Hayes",
			    "Witness",
			    "My name is Clara Hayes. I was at the mansion during the blackout, and I noticed something unusual."
			);
		Informant caretaker = new Informant(
			    "Caretaker",
			    "Informant",
			    "I have worked at Blackwood Mansion for many years. I know things about this house that others don't."
			);
		List<InvestigatableCharacter> characters = new ArrayList<>();

		characters.add(adrian);
		characters.add(clara);
		characters.add(caretaker);
		
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			
		showMenu();
		choice = input.nextInt();
		switch (choice) {
		case 1:
		    System.out.println("===== CASE INFORMATION =====");

		    CaseFileReader reader = new CaseFileReader();
		    reader.readCaseFile("src/finalgame/case_info.txt");

		    break;
		      
	        

	    case 2:
	    	investigation.setStrategy(new EvidenceSearchStrategy());
	    	investigation.performInvestigation();
	    	System.out.println("Choose a location:");
	        System.out.println("1. Hallway");
	        System.out.println("2. Dining Room");
	        System.out.println("3. Study");
	        System.out.println("4. Display Room");
	        

	        int roomChoice = input.nextInt();

	        if (roomChoice == 1) {
	            System.out.println("You entered the Hallway.");
	            System.out.println("A long hallway connecting the mansion rooms.");
	            investigation.addVisitedLocation("Hallway");
	            try {
	            	investigation.addEvidence(ev1, evidence -> {
	            	    System.out.println("Evidence discovered: " + evidence.getName());
	            	});
	            } catch (InvalidEvidenceException e) {
	                System.out.println("Error collecting evidence: " + e.getMessage());
	            }
	        }
	        else if (roomChoice == 2) {
	            System.out.println("You entered the Dining Room.");
	            System.out.println("A large room where the guests had dinner.");
	            investigation.addVisitedLocation("Dining Room");
	        }
	        
	        else if (roomChoice == 3) {
	            System.out.println("You entered the Study.");
	            System.out.println("A private room containing documents and books.");
	            investigation.addVisitedLocation("Study");
	            LockedCabinet cabinet = new LockedCabinet();
	            cabinet.examine();
	            cabinet.showExaminationHint();
	        }
	        else if (roomChoice == 4) {
	            System.out.println("You entered the Display Room.");
	            System.out.println("The diamond necklace disappeared from this room.");
	            investigation.addVisitedLocation("Display Room");
	        }
	        else {
	            System.out.println("Invalid location.");
	        }
	        
	        break;

	    case 3:
	    	investigation.setStrategy(new InterviewStrategy());
	        investigation.performInvestigation();

	        System.out.println("Choose a character to interview:");

	        int number = 1;

	        for (InvestigatableCharacter character : characters) {
	            System.out.println(number + ". " + character.getName());
	            number++;
	        }

	        System.out.println("4. Interview All Characters");
	        System.out.println("Enter your choice:");

	        int characterChoice = input.nextInt();

	        if (characterChoice >= 1 && characterChoice <= characters.size()) {

	            InvestigatableCharacter selected =
	                    characters.get(characterChoice - 1);

	            selected.interview();
	            investigation.recordInterview(selected.getName());

	        } else if (characterChoice == 4) {

	            for (InvestigatableCharacter character : characters) {
	                character.interview();
	                investigation.recordInterview(character.getName());
	            }

	        } else {
	            System.out.println("Invalid character.");
	        }

	        
	        break;

	    case 4:
	    	System.out.println("Sort evidence by:");
	        System.out.println("1. Evidence ID");
	        System.out.println("2. Relevance");

	        int sortChoice = input.nextInt();

	        if (sortChoice == 1) {
	            investigation.sortEvidenceById();
	        } else if (sortChoice == 2) {
	            investigation.sortEvidenceByRelevance();
	        } else {
	            System.out.println("Invalid sorting choice.");
	            break;
	        }

	        investigation.showCollectedEvidence();
	        break;

	    case 5:
	    	System.out.println("===== INVESTIGATION PROGRESS =====");
	    	System.out.println("Case: Midnight Mansion Mystery");
	    	System.out.println("Evidence collected: " + investigation.getEvidenceCount());
	    	System.out.println("Locations visited: " + investigation.getVisitedLocationCount());
	    	System.out.println("Characters interviewed: " + investigation.getInterviewCount());
	    	System.out.println("Evidence objects created: " + Evidence.getEvidenceCreated());
	    	if (investigation.isSolved()) {
	    		System.out.println("Investigation Status: Solved");
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Investigation Status: Ongoing");
	    		
	    	}
	    	
	        break;

	    case 6:
	    	System.out.println("===== ACCUSE A SUSPECT =====");
	    	System.out.println("Who do you think stole the diamond necklace ?");
	    	
	    
	    	System.out.println("1.	Adiran Blackwood");
	    	System.out.println("2. Mr.Collins");
	    	
	    	System.out.println("Enter your choice:");
	    	int choice_accuse;
			choice_accuse = input.nextInt();
	    	
	    	if (choice_accuse == 1)
	    	{
	    		System.out.println("Incorrect accusation. Continue investigating.");
	    	}

	    	else if (choice_accuse == 2)
	    	{
	    		investigation.setSolved();
	    		System.out.println("Correct accusation. Mystery solved!");
	    		
	    	}
	    	
	    	else {
	    	    try {
	    	    	throw new InvalidAccusationException("Invalid suspect number", choice_accuse);
	    
	    	    } catch (InvalidAccusationException e) {
	    	    	System.out.println(e.getMessage() + ": " + e.getInvalidSuspectNumber());
	    	    }
	    	}
	    	
	        break;

	    case 7:
	        investigation.saveReport();
	        break;
	        
	    case 8:
	        System.out.println("Thank you for playing Midnight Mansion Mystery!");
	        break;

	    default:
	        System.out.println("Invalid choice. Please enter a number from 1 to 8.");
	        break;

		}
		}while(choice!=8);
	}
	
	public static void showMenu() {
		System.out.println("1. View Case Information");
		System.out.println("2. Visit a Location");
		System.out.println("3. Interview a Character");
		System.out.println("4. Examine Collected Evidence");
		System.out.println("5. Review Investigation Progress");
		System.out.println("6. Accuse a Suspect");
		System.out.println("7. Save Investigation Report");
		System.out.println("8. Exit Game");
		System.out.println("Enter your choice:");
		

	}
	

	


}
