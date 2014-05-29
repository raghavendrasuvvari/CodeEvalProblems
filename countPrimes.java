/*
 * COUNTING PRIMES
CHALLENGE DESCRIPTION:

Given two integers N and M, count the number of prime numbers between N and M (both inclusive)

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file contains two comma separated positive integers. E.g.

2,10
20,30
OUTPUT SAMPLE:

Print out the number of primes between N and M (both inclusive)

4
2
*/
package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class countPrimes {
	
    public static void main (String[] args) throws IOException {
    	
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    int prime = 0;
    int flag =0;
    while ((line = in.readLine()) != null) {
    	String[] lineArray = line.split(",");
    	int x = Integer.parseInt(lineArray[0]);
    	int y = Integer.parseInt(lineArray[1]);
        if (lineArray.length > 0) {
        	for(int count=x;count<=y;count++){
        		for(int j=2;j<=count/2;j++){
        			if((count%j==0))
        			{
        				flag = 1;
        				break;
        			}
        		}
        		if(flag==0)
        			prime++;
        		flag = 0;        			
        	}
        	System.out.println(prime);
        	prime = 0;
        	}      	
        	
        }
    in.close();
    }
  
}
