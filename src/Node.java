import java.util.Comparator;

public class Node {
Character c;
int freq;
Node left =null;
Node right = null;
public Node(Character c, int freq) {
	this.c = c;
	this.freq = freq;
}
public Node(Character c, int freq, Node left, Node right)
{
    this.c = c;
    this.freq = freq;
    this.left = left;
    this.right = right;
}

}
