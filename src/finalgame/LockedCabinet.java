package finalgame;

public class LockedCabinet implements Examinable {

	public LockedCabinet() {
		
		}
	
	@Override
	public void examine() {
	    System.out.println("The cabinet is locked. There may be a clue inside.");
	}

}
