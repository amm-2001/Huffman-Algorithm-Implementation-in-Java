import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.*;
import java.io.*;
public class Huffman{
public static void encode(Node root , String s , Map<Character,String>huffCode) {// in this method we will generate the huffman code for every character in the text
	if(root==null) return;
	if(is_Leaf(root)) {
		huffCode.put(root.c, s);// here we assign each character with its huffman code and store them in huffcode map
	}
	//in these two lines we will call the method encode recursively so we a reach the leaf node 
	//and also to put the 0's and 1's in their places 
	encode(root.left,s+"0",huffCode);
	encode(root.right,s+"1",huffCode);
}

public static boolean is_Leaf(Node root) {// this method will check if the Node we are in is a leaf
	
	return root.left==null&&root.right==null;
}
public static int decode(Node root,int index,StringBuilder b) { // this method will decode the huffman code and restore again to a text
	if(root==null) return index;// Check if the node has a value or not
	if(is_Leaf(root)) {// check if the node is a leaf node
		System.out.print(root.c);
           return index;
	}
	 index++;
	  // the root variable will store the node depending on the character in the string builder if its 0 he will take the left node 
	 // if its 1 it will take the right node
	 root = (b.charAt(index)=='0')? root.left : root.right;
	 index = decode(root,index,b);
	 return index;
}
   

public static void huffmanTree(String text) { // in this method we will will build the huffman tree using the text that is given by 
	//the user or generated randomly
	if(text==null||text.length()==0) return ; // check if the given text file is not empty
	
	Map<Character,Integer>freq = new HashMap<>();
	for(char c:text.toCharArray()) { // in this loop we will take every character in the string and assign the it to its frequency
		freq.put(c,freq.getOrDefault(c,0)+1);// this line will calculate the frequency of the character c and store it in the map
	}
	// a priority queue which will give us the smallest character according to his frequency
	Comparable Comparator = new Comparable();
	PriorityQueue<Node> queue = new PriorityQueue<>(Comparator);
	for(var entry: freq.entrySet()) {
		queue.add(new Node(entry.getKey(),entry.getValue()));
	}
	while(queue.size()!=1) {
		Node left = queue.poll(); // we take the smallest character according to his frequency and store him in the left node                  
		Node right = queue.poll();// we take the second smallest character according to his frequency and store him in the right node 
		
		int sum = left.freq + right.freq;// here we add the frequency of left and right node and then add them again to the queue
		queue.add(new Node(null,sum,left,right));
	}
	Node root = queue.peek();// here the root variable will be given the last remaining element in the queue 
	//and it will the root of the tree
	int i =0;
	
	Map<Character,String> huffCode = new HashMap<>();
	encode(root,"",huffCode);
	System.out.println("Huffman codes of the text: "+huffCode);// here we will print each a character and the code that is assigned to it
	System.out.println("Original Text: "+ text);
	
	StringBuilder b = new StringBuilder();
	for(char c : text.toCharArray()) {
		b.append(huffCode.get(c));
	}
	
	System.out.println("The encoded text is: "+ b); // here the code of the full text will be printed
	printTree(root);// this method will print the tree
	
	System.out.print("Decoded text: ");// this will be print the text after decoding the code that was made for the text
	
	if(is_Leaf(root)) {
		while(root.freq!=0) {
			System.out.print(root.c);
		}
	}
	else {
		int index =-1;
		while(index<b.length()-1) {
			index = decode(root,index,b);
		}
	}
	
	
}



private static void printTree(Node root){// this method will print a simple visualization of the tree
    Queue<Node> level = new LinkedList<>();// in this queue we will store the current level
    Queue<Node> newLevel = new LinkedList<>();// this queue will store the next level
    level.add(root);
    System.out.println("...........................................");
    while(!level.isEmpty()){
        Iterator<Node> itr = level.iterator();// we save every level in the iterator from the queue 
        while(itr.hasNext()){
            Node node = itr.next();// while the iterator has an level inside it we assign the level to node and remove it from the iterator
            if(node.left != null){// here we see if the node has a right or left child or both
                newLevel.add(node.left); 
            }                           // if the node has a left or right child we assign the child to new level queue
            if(node.right != null){
                newLevel.add(node.right);
            }
  
 if(node.c==null) {//in this if condition we see if the node has a character or not if it has it will print the character if not then its a parent and will print its frequency
            	
            	System.out.print("  " + node.freq + "  ");
            	
            }
            else {
            	
            	System.out.print("  " + node.c + "  ");  
            }

        }
        System.out.println(); 
        level = newLevel; // make the new level the current level
        newLevel = new LinkedList<Node>();// make the new level store more the one element per node

    }
    System.out.println("...........................................");
    }


public static void main(String[] args) throws FileNotFoundException {
	/*Random RanText = new Random();
	Random randomN = new Random();
	int length = randomN.nextInt(657);
	String Characters ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	String randomS="";
	Random rand = new Random();
	char[] ranText = new char[length];
	for(int i=0;i<length;i++) {
		ranText[i] = Characters.charAt(rand.nextInt(Characters.length()));
	}
	for(int i =0; i<ranText.length;i++) {
		randomS+= ranText[i];
	}
	String text = randomS;*/
	
	/*File file = new File ("/Users/rhmnm/Desktop/Test.txt");
	Scanner scan = new Scanner(file); 
	String text = "" ;
	while(scan.hasNextLine()) {
		text = text.concat(scan.nextLine()+"");
	}*/
   String text = "dAOFMboJLkhkAfkFBlj";
	huffmanTree(text);
}




}
