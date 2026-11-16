package finalgame;
import java.util.Comparator;

public class EvidenceRelevanceComparator implements Comparator<Evidence> {

	public EvidenceRelevanceComparator() {
		
	}
	@Override
	public int compare(Evidence e1, Evidence e2) {
	    return Integer.compare(e2.getRelevance(), e1.getRelevance());
	}

}
