# Huffman Algorithm Implementation in Java

This program implements the Huffman algorithm, a compression technique that assigns shorter codes to frequently occurring characters in a message and longer codes to less frequent characters. The Huffman algorithm uses a binary tree to represent the codes, where each leaf node corresponds to a character and each internal node corresponds to the sum of the frequencies of its child nodes.

The program takes as input a text file, a text written by the user or random text and outputs the text as binary + the tree using the Huffman codes. It uses the following steps:

Count the frequency of each character in the input file and store it in a frequency table.
Build a Huffman tree from the frequency table by repeatedly combining the two least frequent nodes until there is only one root node.
Traverse the Huffman tree to assign a binary code to each character, with left branches representing 0 and right branches representing 1.
Print the Huffman codes, the encoded message and the tree in the kernal.


To run the program, simply implenment node and comparable files then implement and compile the HuffMan_Main.java file 
