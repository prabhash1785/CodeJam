package com.prabhash.codejam.google.year2017.qualifying;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *  Problem A. Oversized Pancake Flipper
 * 
 * @author Prabhash Rathore
 *
 */
public class OversizedPancakeFlipper {
	
	public static int findMinFlipCount(String s, int k) {
		int count = 0;
		int firstNegIndex = -1;
		char[] pancakes = s.toCharArray();
		for(int i = 0; i < pancakes.length; i++) {
			if(pancakes[i] == '-') {
				firstNegIndex = i;
				break;
			}
		}
		
		if(firstNegIndex < 0) {
			return count;
		}
		
		for(int j = firstNegIndex; j < pancakes.length; j++) {
			if(pancakes[j] == '+') {
				continue;
			}
			
			if(j > pancakes.length - k) {
				return -1; // still unflipped pan cakes left but not enough of them left to flip
			} else {
				int a = 0;
				firstNegIndex = -1; // optimization to make sure we find the furthese non-flipped pancake next time in for loop
				while(a < k) {
					if(pancakes[j + a] == '+') {
						pancakes[j + a] = '-';
						if(firstNegIndex == -1) {
							firstNegIndex = j + a;
						}
					} else {
						pancakes[j + a] = '+';
					}
					++a;
				}
				++count;
				if(firstNegIndex != -1) {
					j = firstNegIndex - 1;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line = br.readLine();
		int testCount = Integer.parseInt(line);
//		System.out.println("Test case count: " + testCount);

		for (int i = 1; i <= testCount; i++) {
			String text = br.readLine();
//			System.out.println("Line " + i + ": " + text);
			
			String[] tokens = text.split(" ");
//			System.out.println("Pancake = " + tokens[0]);
//			System.out.println("Flipper length = " + tokens[1]);
			
			int count = findMinFlipCount(tokens[0], Integer.parseInt(tokens[1]));
			if(count == -1) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + i + ": " + count);
			}
		}
		
		br.close();
	}
}
