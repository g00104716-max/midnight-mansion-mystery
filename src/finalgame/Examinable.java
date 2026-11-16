package finalgame;

public interface Examinable {
	
	void examine();
	default void showExaminationHint(){
        System.out.println("Hint: Examine "
      + "clues carefully to find out who stole the necklace.");

		
		
	}

}
