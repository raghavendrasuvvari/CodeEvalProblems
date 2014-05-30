package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class stringReplace {
	
    public static void main (String[] args) throws IOException {
    	
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
   
    while ((line = in.readLine()) != null) {
    	if(line.equals(""))
    		continue;
    	int temp =0;
    	
    	//System.out.println("The input is "+line);
    	String[] lineArray1 = line.split(";");
    	String[] lineArray2 = lineArray1[1].split(",");
    	int length=lineArray2.length;  
    	
    	for(int i=0;i<length-1;i++)
    	{
    		
    		if(temp==0){
    			lineArray1[0]=lineArray1[0].replaceFirst(lineArray2[i],lineArray2[i+1]);
    			temp=1;
    		}
    		else 
    		{
    			lineArray1[0]=replaceLast(lineArray1[0],lineArray2[i],lineArray2[i+1]);
    			temp=0;
    		}
    		
    		i++;
    	}
    	
    	System.out.println(lineArray1[0]);
    }
    
    in.close();
    }

    private static String replaceLast(String string, String from, String to) {
    	int lastIndex = string.lastIndexOf(from);
        if (lastIndex < 0) return string;
        String tail = string.substring(lastIndex).replaceFirst(from, to);
        return string.substring(0, lastIndex) + tail;
   }
  
}
