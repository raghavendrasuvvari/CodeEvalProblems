/*
 * REMOVE CHARACTERS
CHALLENGE DESCRIPTION:

Write a program to remove specific characters from a string.

INPUT SAMPLE:

The first argument will be a path to a filename containing an input string followed by a comma and then the characters that need to be scrubbed. E.g.

how are you, abc
hello world, def
OUTPUT SAMPLE:

Print to stdout, the scrubbed strings, one per line. Trim out any leading/trailing whitespaces if they occur. E.g.

how re you
hllo worl
*/
package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class removeCharacters {
	
    public static void main (String[] args) throws IOException {
    	
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
    	String[] lineArray = line.split(",");
        if (lineArray.length > 0) {
        		
        		char[] charArray1 = lineArray[0].toCharArray(); 
        		char[] charArray2 = lineArray[1].toCharArray();
        		for(int i =0;i<charArray1.length;i++)
        		{
        			for(int j=1;j<charArray2.length;j++)
        			{
        				if(charArray1[i]==charArray2[j])
        					charArray1[i]='.';
        			}
        		}
        		String str = String.valueOf(charArray1);
        		String str1 = str.replace(".", "");
        		System.out.println(str1);
        	}      	
        	
        }
    in.close();
    }
  
}
