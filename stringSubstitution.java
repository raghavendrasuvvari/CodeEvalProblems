/*
 * STRING SUBSTITUTION
CHALLENGE DESCRIPTION:

Credits: This challenge was contributed by Sam McCoy 

Given a string S, and a list of strings of positive length, F1,R1,F2,R2,...,FN,RN, proceed to find in order the occurrences (left-to-right) of Fi in S and replace them with Ri. All strings are over alphabet { 0, 1 }. Searching should consider only contiguous pieces of S that have not been subject to replacements on prior iterations. An iteration of the algorithm should not write over any previous replacement by the algorithm.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file is one test case. Each test case will contain a string, then a semicolon and then a list of comma separated strings. E.g.

10011011001;0110,1001,1001,0,10,11
OUTPUT SAMPLE:

For each line of input, print out the string after substitutions have been made.eg.

11100110
For the curious, here are the transitions for the above example: 10011011001 => 10100111001 [replacing 0110 with 1001] => 10100110 [replacing 1001 with 0] => 11100110 [replacing 10 with 11]. So the answer is 11100110
*/
package codeEval;

import java.io.*;


public class stringSubstitution {

    private static String[] F;
	private static String[] R;
	
	public static void main(String[] args) throws IOException {
		try{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
		while((line = in.readLine()) != null){
			
			String[] parts = line.split(";");
			String input = parts[0];
			String[] subStr = parts[1].split(",");
			int length = subStr.length;
			int k = 0;
			String[] Fn = new String[length/2];
			String[] Rn = new String[length/2];
			for(int i = 0; i < subStr.length; i = i+2) {
				Fn[k] = subStr[i];
				Rn[k] = subStr[i+1];
				k++;
			}
			F = Fn;
			R = Rn;

			String finalString = subStrings(input);
			System.out.println(finalString);

		}
		in.close();
		}
		catch(IOException e)
		{
			System.out.println("Invalid input file");
		}
	}

	/*part of logic borrowed from stackoverflow*/
	private static String subStrings(String s) {
		String finalString = "";
		int strLen = s.length();
		
		String[] strArray = new String[strLen];
		for (int i = 0; i < strLen; i++){
			strArray[i] = "" + s.charAt(i);
		}

		int sizeFN = F.length;
	
		for (int i = 0; i < sizeFN; i++){
			int FLen = F[i].length();
			String[] FArray = new String[FLen];
			for (int j = 0; j < FLen; j++){
				FArray[j] = "" + F[i].charAt(j);
			}


			int j = 0, k =0, mid=0;
			
			while (j < FLen && k < strLen){ 
				if(FArray[j].equals(strArray[k])){
					if(j == 0){
						mid = k;
					}
					j++;
					k++;
				} else {
					if(j == 0){
						mid = k;
					}
					j = 0;
					k = mid + 1;
				}

				if(j == FLen){
					strArray[mid] = "R" + R[i];
					for(k = 1; k < FLen; k++){
						strArray[k + mid] = "R";
					}
					j = 0;
					k = mid + FLen;
				}
			}
		}
		for(int i = 0; i < strLen; i++){
			strArray[i] = strArray[i].replace("R", "");
			finalString = finalString + strArray[i];
		}
		return finalString;
	}
	
}