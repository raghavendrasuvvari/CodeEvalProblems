/*
 * CHALLENGE DESCRIPTION:

Write a program implementing a stack inteface for integers.The interface should have 'push' and 'pop' functions. You will be asked to 'push' a series of integers and then 'pop' and print out every alternate integer.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename containing a series of space delimited integers, one per line. E.g.

1 2 3 4
10 -2 3 4
OUTPUT SAMPLE:

Print to stdout, every alternate integer(space delimited), one per line. E.g.

4 2
4 -2
*/
package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class stackImplementation {
	
    public static void main (String[] args) throws IOException {
    	
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    String afterLine;
    
    while ((line = in.readLine()) != null) {
    	if(line.equals(""))
    		continue;
    	
    	afterLine = line.trim().replaceAll(" +", " ");
    	String[] lineArray = afterLine.split(" ");
    	int length=lineArray.length;    		
    	
    	for(int i=length-1;i>=0;i--)
    	{
    		if(i>=0){
    			if(i==length-1)
    				System.out.print(lineArray[i]);
    			else
    				System.out.print(' '+lineArray[i]);
    			i--;
    		}
    	}
    	System.out.println();
    	}
    	
    in.close();
    }
  
}
