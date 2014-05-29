/*
 * CHALLENGE DESCRIPTION:

Print out the prime numbers less than a given number N. For bonus points your solution should run in N*(log(N)) time or better. You may assume that N is always a positive integer.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file is one test case. Each test case will contain an integer n < 4,294,967,295. E.g.

10
20
100
OUTPUT SAMPLE:

For each line of input, print out the prime numbers less than N, in ascending order, comma delimited. (There should not be any spaces between the comma and numbers) E.g.

2,3,5,7
2,3,5,7,11,13,17,19
2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
*/
package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class primeNumbers {
	
    public static void main (String[] args) throws IOException {
    	
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    //int prime = 0;
    int flag =0;
    int j = 0;
    while ((line = in.readLine()) != null) {
    	//String[] lineArray = line.split(",");
    	if(line.equals(""))
    		continue;
    	
    	int x = Integer.parseInt(line);
    	   	for(int count=2;count<x;count++){
        		for(j=2;j<=count/2 ;j++){
        			if((count%j==0))
        			{
        				flag = 1;
        				break;
        			}
        		}
        		if(flag==0 && count!=2)
        			System.out.print(","+count);
        		else if(flag==0 && count==2)
        			System.out.print(count);
        		flag = 0;        			
        	}
        	System.out.println("");
    	}
    	
    in.close();
    }
  
}
