/*MTH TO LAST ELEMENT
CHALLENGE DESCRIPTION:

Write a program to determine the Mth to last element of a list. 
INPUT SAMPLE:

The first argument will be a path to a filename containing a series of space delimited characters followed by an integer representing a index into the list (1 based), one per line. E.g. 
a b c d 4
e f g h 2
OUTPUT SAMPLE:

Print to stdout, the Mth element from the end of the list, one per line. If the index is larger than the list size, ignore that input. E.g.

a
g
*/
package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class nthElement {
	
    public static void main (String[] args) throws IOException {
    	
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    String afterLine;
    int num =0;
    while ((line = in.readLine()) != null) {
    	if(line.equals(""))
    		continue;
    	
    	afterLine = line.trim().replaceAll(" +", " ");
    	String[] lineArray = afterLine.split(" ");
    	    		
    	num = Integer.parseInt(lineArray[lineArray.length-1]);
    	if(lineArray.length-num-1>=0)
    		System.out.println(lineArray[lineArray.length-num-1]);
    	}
    	
    in.close();
    }
  
}
