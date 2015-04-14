package com.prabhash.codejam.google.year2015;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * The Latin alphabet contains 26 characters and telephones only have ten digits on the keypad. We would like to make it easier 
 * to write a message to your friend using a sequence of keypresses to indicate the desired characters. The letters are mapped onto 
 * the digits as shown below. To insert the character B for instance, the program would press 22. In order to insert two characters 
 * in sequence from the same key, the user must pause before pressing the key a second time. The space character ' ' should be printed 
 * to indicate a pause. For example, 2 2 indicates AA whereas 22 indicates B.
 * 
 * Limits
 * 1 ≤ N ≤ 100.
 * 
 * Small dataset
 * 1 ≤ length of message in characters ≤ 15.
 * 
 * Large dataset
 * 1 ≤ length of message in characters ≤ 1000.
 * 
 * Input Files:
 * Small Dataset: C-small-practice.in
 * Large Dataset: C-large-practice.in
 * 
 * @author prrathore
 *
 */
public class T9Spelling {
	
	private class CharKeyMap {
		
		private int key;
		private String t9KeySequence;
		
		public CharKeyMap(int key, String t9KeySequence) {
			this.key = key;
			this.t9KeySequence = t9KeySequence;
		}
		
	}
	
	/**
	 * This method will be called for each test case in the input text file. This method compares each character from text array to a map
	 * and adds the key sequence to a StringBuffer. Finally this StringBuffer is prited as an output.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * where n is the numbers of characters in a String
	 * 
	 * @param testCase
	 * @param charList
	 * @param keyMap
	 */
	public static void printT9Spelling(int testCase, final char[] charList, final Map<Character, CharKeyMap> keyMap) {
		
		StringBuffer sb = new StringBuffer(); //output object which will store the t9 key sequence for a string
		
		for(int i = 0; i < charList.length; i++) {
			
			if(i == 0) {
				sb.append(keyMap.get(charList[i]).t9KeySequence);
			} else {
				
				if(keyMap.get(charList[i-1]).key == keyMap.get(charList[i]).key) {
					sb.append(' ').append(keyMap.get(charList[i]).t9KeySequence);
				} else {
					sb.append(keyMap.get(charList[i]).t9KeySequence);
				}
				
			}
			
		}
		
		//final output for each test case
		System.out.println("Case #" + testCase + ": " + sb.toString());
		
	}
	
	/**
	 * Pre-processing method which will create a Map Data Structure to store character relation with the key sequence. This will be run
	 * one time during the startup as a pre-processing task to prevent run time bottlenecks.
	 * 
	 * @return
	 */
	public static final Map<Character, CharKeyMap> preProcessT9Keys() {
		
		final T9Spelling t9Spelling = new T9Spelling();
		
		Map<Character, CharKeyMap> keyMap = new HashMap<Character, CharKeyMap>();
		
		keyMap.put('a', t9Spelling.new CharKeyMap(2, "2"));
		keyMap.put('b', t9Spelling.new CharKeyMap(2, "22"));
		keyMap.put('c', t9Spelling.new CharKeyMap(2, "222"));
		keyMap.put('d', t9Spelling.new CharKeyMap(3, "3"));
		keyMap.put('e', t9Spelling.new CharKeyMap(3, "33"));
		keyMap.put('f', t9Spelling.new CharKeyMap(3, "333"));
		keyMap.put('g', t9Spelling.new CharKeyMap(4, "4"));
		keyMap.put('h', t9Spelling.new CharKeyMap(4, "44"));
		keyMap.put('i', t9Spelling.new CharKeyMap(4, "444"));
		keyMap.put('j', t9Spelling.new CharKeyMap(5, "5"));
		keyMap.put('k', t9Spelling.new CharKeyMap(5, "55"));
		keyMap.put('l', t9Spelling.new CharKeyMap(5, "555"));
		keyMap.put('m', t9Spelling.new CharKeyMap(6, "6"));
		keyMap.put('n', t9Spelling.new CharKeyMap(6, "66"));
		keyMap.put('o', t9Spelling.new CharKeyMap(6, "666"));
		keyMap.put('p', t9Spelling.new CharKeyMap(7, "7"));
		keyMap.put('q', t9Spelling.new CharKeyMap(7, "77"));
		keyMap.put('r', t9Spelling.new CharKeyMap(7, "777"));
		keyMap.put('s', t9Spelling.new CharKeyMap(7, "7777"));
		keyMap.put('t', t9Spelling.new CharKeyMap(8, "8"));
		keyMap.put('u', t9Spelling.new CharKeyMap(8, "88"));
		keyMap.put('v', t9Spelling.new CharKeyMap(8, "888"));
		keyMap.put('w', t9Spelling.new CharKeyMap(9, "9"));
		keyMap.put('x', t9Spelling.new CharKeyMap(9, "99"));
		keyMap.put('y', t9Spelling.new CharKeyMap(9, "999"));
		keyMap.put('z', t9Spelling.new CharKeyMap(9, "9999"));
		keyMap.put(' ', t9Spelling.new CharKeyMap(0, "0"));
			
		return keyMap;
		
	}
	
	/**
	 * Main method which loads the input text file as a command line arguement and parses it line by line to print the key sequence for 
	 * each String input.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		//Get the Pre-processed map of characters and their key sequence
		Map<Character, CharKeyMap> keyMap = preProcessT9Keys();
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
			
		try {
			
	        String line = br.readLine();
	        int numberOfTestCases = Integer.parseInt(line);

	        for(int testCase = 1; testCase <= numberOfTestCases; testCase++) {
	        	
	        	String input = br.readLine();
	        	
	        	printT9Spelling(testCase, input.toCharArray(), keyMap);
	        	
	        }
	        
	    } finally {
	    	br.close();
	    }
		
	}

}
