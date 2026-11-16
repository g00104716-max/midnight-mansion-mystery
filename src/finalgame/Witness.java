package finalgame;

public class Witness extends InvestigatableCharacter { 

	public Witness(String name, String role, String dialogue) {
		super(name,role,dialogue);
		
		
	}
	@Override
	public void interview() {

		System.out.println("Clara Hayes: I heard footsteps near the"
				+ " display room just before the lights went out!");
	}
	@Override
	public void reactToEvidence() {
		System.out.println("Clara Hayes: I saw someone wearing a dark jacket near the"
				+ " hallway. That fabric looks familiar!");

	}
	
}
