package finalgame;


public abstract class InvestigatableCharacter extends Character {

	public InvestigatableCharacter(String name, String role, String dialogue) {
		super(name,role,dialogue);
		

		
	
	}
	public abstract void interview();
	public abstract void reactToEvidence();

}
