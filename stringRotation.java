/*
 * CHALLENGE DESCRIPTION:

You are given two strings. Determine if the second string is a rotation of the first string.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains two comma separated strings. E.g.

Hello,lloHe
Basefont,tBasefon
OUTPUT SAMPLE:

Print out True/False if the second string is a rotation of the first. E.g.

True
True
*/
package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class stringRotation {
	
    public static void main (String[] args) throws IOException {
    	
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
    	String[] lineArray = line.split(",");
        if (lineArray.length > 0) {
        		if ((lineArray[0]+lineArray[0]).contains(lineArray[1]))
        			System.out.println("True");  
        		else
        			System.out.println("False"); 
        	}      	
        	
        }
    in.close();
    }
  
}
