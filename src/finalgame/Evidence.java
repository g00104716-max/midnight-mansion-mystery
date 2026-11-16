package finalgame;
import java.util.Objects;

public class Evidence implements Examinable, Comparable<Evidence> {
	
			private String id;
			private String name;
			private String description;
			private int  relevance;
			private static int evidenceCreated = 0;

			
public Evidence(String id, String name,
		String description, int relevance) {
	
	if (id == null || id.isBlank()) {
	    throw new IllegalArgumentException("Evidence ID cannot be empty");
	 
	}


	
	if(name==null || name.isBlank())
	{
		throw new IllegalArgumentException("Evidence Name cannot be empty");
	}
	if(description==null || description.isBlank())
	{
		throw new IllegalArgumentException("Evidence Description cannot be empty");
	}
	
	if(relevance < 1 || relevance > 5) {
		throw new IllegalArgumentException("Relevance must be between 1 and 5");
	}
this.id=id;
this.name=name;
this.description=description;
this.relevance=relevance;
evidenceCreated++;
			



}	
public static int getEvidenceCreated() {
    return evidenceCreated;
}
public Evidence(String id, String name, String description) {
    this(id, name, description, 3);
}
public String getId() {
	return id;
}public String getName() {
	return name;
}
public String getDescription() {
	return description;
}
public int getRelevance() {
	return relevance;
}

@Override
public void examine() {
    System.out.println("Evidence: " + name);
    System.out.println("Description: " + description);
    System.out.println("Relevance: " + relevance);
}	

@Override
public int compareTo(Evidence other) {
    return this.id.compareTo(other.id);
}
@Override
public String toString() {
    return "Evidence ID: " + id
            + "\nName: " + name
            + "\nDescription: " + description
            + "\nRelevance: " + relevance;
}
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (!(obj instanceof Evidence)) {
        return false;
    }
    Evidence other = (Evidence) obj;
    return Objects.equals(this.id, other.id);
}
@Override
public int hashCode() {
    return Objects.hash(id);
}
	}


