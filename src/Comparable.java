import java.util.Comparator;

public class Comparable implements Comparator<Node> {
	@Override
	public int compare(Node s1, Node s2) { // the method will make the priority queue give the priority to the character with lowest frequency
		return s1.freq-s2.freq;
		}
}
