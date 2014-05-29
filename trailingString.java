/*
 * CHALLENGE DESCRIPTION:

You are given two strings 'A' and 'B'. Print out a 1 if string 'B' occurs at the end of string 'A'. Else a zero.

INPUT SAMPLE:

The first argument will be the path to the input filename containing two strings, comma delimited, one per line. Ignore all empty lines in the input file. E.g.

Hello World,World
Hello CodeEval,CodeEval
San Francisco,San Jose
OUTPUT SAMPLE:

Print out 1 if the second string occurs at the end of the first string. Else zero. Do NOT print out empty lines between your output. E.g.

1
1
0*/
package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class trailingString {
	
    public static void main (String[] args) throws IOException {
    
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
    	String[] lineArray = line.split(",");
        if (lineArray.length > 0) {
            if(lineArray[0].toLowerCase().contains(lineArray[1].toLowerCase()))
        		System.out.println("1");
        	else
        		System.out.println("0");
        	
        	
        }
    }
  }
}
