package finalgame;

public class Suspect extends InvestigatableCharacter  {

	public Suspect(String name, String role, String dialogue) {
		super(name,role,dialogue);
		
	}

	@Override
	public void interview() {
		System.out.println("Adrian Blackwood: I was in the study when the "
				+ "necklace disappeared!");
	}
	@Override
	public void reactToEvidence() {
		System.out.println("That torn fabric isn't mine! I have"
				+ " nothing to do with the missing necklace!");
		
	}
	
}
