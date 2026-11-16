package finalgame;

public class Character {
	private String name;
	private String role;
	private String dialogue;

	public Character(String name, String role, String dialogue) {
		
		
		if (name == null || name.isBlank()) {
		    throw new IllegalArgumentException("Character name cannot be empty");
		}

		if (role == null || role.isBlank()) {
		    throw new IllegalArgumentException("Character role cannot be empty");
		}

		if (dialogue == null || dialogue.isBlank()) {
		    throw new IllegalArgumentException("Character dialogue cannot be empty");
		}
		
		this.name=name;
		this.role=role;
		this.dialogue=dialogue;
		
	}
 public String getName() {
	 return name;
	 
 }
 public String getRole() {
	 return role;
	 
 }
 public String getDialogue() {
	 return dialogue;
 }
 
 public void speak() {
	 System.out.println(name+" :");
	 System.out.println(dialogue);
	 
	 
 }
 
}
