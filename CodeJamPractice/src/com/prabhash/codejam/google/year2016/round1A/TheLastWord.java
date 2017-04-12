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
	
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
		String line = bufferedReader.readLine();
		int testCount = Integer.parseInt(line);
		for(int i = 1; i <= testCount; i++) {
			String word = bufferedReader.readLine();
//			System.out.println(word);
			
			String lastWord = findLastWord(word);
			System.out.println("Case #" + i + ": " + lastWord);
		}
	}
}
