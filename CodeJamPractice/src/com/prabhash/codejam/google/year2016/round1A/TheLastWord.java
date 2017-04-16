package com.prabhash.codejam.google.year2016.round1A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem A. The Last Word
 * 
 * @author Prabhash Rathore
 *
 */
public class TheLastWord {
	
	/**
	 * Small data set
	 * 
	 * Time Complexity: Exponential
	 * 
	 * @param word
	 * @return String
	 */
	public static String findLastWord(String word) {
		List<String> list = new ArrayList<>();
		list.add(word.substring(0, 1));
		for(int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			
			List<String> newList = new ArrayList<>(); 
			for(String s : list) {
				String first = c + s;
				newList.add(first);
				
				String second = s + c;
				newList.add(second);
			}
			
			list = newList;
		}
		
		Collections.sort(list);
		return list.get(list.size() - 1);
	}
	
	/**
	 * For large data set
	 * 
	 * Time Complexity: Polynomial
	 * 
	 * @param word
	 * @return String
	 */
	public static String findLastWordForLargeDataSet(String word) {
		String result = word.substring(0, 1);
		for(int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			String first = c + result;
			String second = result + c;
			
			result = (first.compareTo(second) < 0) ? second : first; // find the local maximum
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
		String line = bufferedReader.readLine();
		int testCount = Integer.parseInt(line);
		for(int i = 1; i <= testCount; i++) {
			String word = bufferedReader.readLine();
//			System.out.println(word);
			
//			String lastWord = findLastWord(word);
			String lastWord = findLastWordForLargeDataSet(word);
			System.out.println("Case #" + i + ": " + lastWord);
		}
	}
}
