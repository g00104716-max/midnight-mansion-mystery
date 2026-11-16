package finalgame;

public class Informant extends InvestigatableCharacter  {

	public Informant(String name, String role, String dialogue) {
		super(name,role,dialogue);
		
	}
	@Override
	public void interview() {
		System.out.println("Caretaker: I noticed Mr. Collins walking "
				+ "toward the display room shortly before the blackout.");
	}
	
	@Override
	public void reactToEvidence() {
		System.out.println("Caretaker: That security log is strange. Mr. Collins was the "
				+ "last person recorded entering the display room!");
		
		
		
	}
}
