/*
 * EMAIL VALIDATION
CHALLENGE DESCRIPTION:

You are given several strings that may/may not be valid emails. You should write a regular expression that determines if the email id is a valid email id or not. You may assume all characters are from the english language.

INPUT SAMPLE:

Your program should accept as its first argument a filename. This file will contain several text strings, one per line. Ignore all empty lines. E.g. 
foo@bar.com
this is not an email id
admin#codeeval.com
good123@bad.com
OUTPUT SAMPLE:

Print out 'true' (all lowercase) if the string is a valid email. Else print out 'false' (all lowercase). E.g.

true
false
false
true
*/
package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class validateEmail {
	
    public static void main (String[] args) throws IOException {
    	
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
   
    while ((line = in.readLine()) != null) {
    	if(line.equals(""))
    		continue;
    	java.util.regex.Pattern p = java.util.regex.Pattern.compile(".+@.+\\.[a-z]+");
        java.util.regex.Matcher m = p.matcher(line);
        if( m.matches())
        	System.out.println("true");
        else
        	System.out.println("false");
    	}
    	
    in.close();
    }
  
}
