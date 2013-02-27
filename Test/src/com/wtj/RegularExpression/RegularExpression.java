package com.wtj.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

    	String str = "10.10.10.98";
    	Pattern ptn = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    	Matcher mat = ptn.matcher(str);
    	System.out.print(mat.matches());
    	
    	String str1 = "     123uoiha hueapoih    fheauo    faehuoi   ";
    	String [] strarray = str1.split("\\s");
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0;i<strarray.length;i++)
    		sb.append(strarray[i]);
    	
    	System.out.print(ptn.toString());
	}
}
