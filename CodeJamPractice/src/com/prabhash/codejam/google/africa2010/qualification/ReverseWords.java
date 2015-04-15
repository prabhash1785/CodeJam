package com.prabhash.codejam.google.africa2010.qualification;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Problem
 * Given a list of space separated words, reverse the order of the words. Each line of text contains L letters and W words. 
 * A line will only consist of letters and space characters. There will be exactly one space character between each pair of consecutive 
 * words.
 * 
 * Input
 * The first line of input gives the number of cases, N.
 * N test cases follow. For each test case there will a line of letters and space characters indicating a list of space separated words. Spaces will not appear at the start or end of a line.
 * 
 * Inputs:
 * B-small-practice.in
 * B-large-practice.in
 * 
 * @author prrathore
 *
 */
public class ReverseWords {
	
	/**
	 * Read the String from loaded input file and then split the string with a space delimiter and store them in an array. 
	 * To reverse the string, simply traverse the array from opposite side and append them to a StringBuffer.
	 * 
	 * For each test case:
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		
		String line = br.readLine();
		int testCount = Integer.parseInt(line);
		
		StringBuffer sb;
		
		for(int i = 1; i <= testCount; i++) {
			
			sb = new StringBuffer(); //create a new object every look to prevent stale data from other test cases
			
			String text = br.readLine();
			String[] listOfWords = text.split(" ");
			
			for(int j = (listOfWords.length - 1); j >= 0; j--) {
				sb.append(listOfWords[j]);
				
				//add a space only when index is not equal to zero so that there is no space after the last word
				if(j != 0) {
					sb.append(" ");
				}
				
			}
			
			System.out.println("Case #" + i + ": " + sb.toString());
			
		}
		
		try {
			
		} finally {
			br.close();
		}

	}

}
