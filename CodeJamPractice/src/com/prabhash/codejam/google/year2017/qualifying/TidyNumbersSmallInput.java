package com.prabhash.codejam.google.year2017.qualifying;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Last Tidy Number
 * 
 * @author Prabhash Rathore
 *
 */
public class TidyNumbersSmallInput {
	
	public static int findLastTidyNumber(int n) {
		if(n < 10) {
			return n;
		}
				
		while(n >= 1) {
			if(isTidy(n)) {
				return n;
			}
			--n;
		}
		
		return n;
	}
	
	private static boolean isTidy(int n) {
		if(n < 10) {
			return true;
		}
		
		int lastDigit = n % 10;
		n = n / 10;
		while(n > 0) {
			int rem = n % 10;
			if(rem > lastDigit) {
				return false;
			}
			
			lastDigit = rem;
			n = n / 10;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line = br.readLine();
		int testCount = Integer.parseInt(line);
//		System.out.println("Test case count: " + testCount);

		for (int i = 1; i <= testCount; i++) {
			String text = br.readLine();
			int num = Integer.parseInt(text);
//			System.out.println("Number " + i + ": " + num);
			
			int lastTidyNumber = findLastTidyNumber(num);
			System.out.println("Case #" + i + ": " + lastTidyNumber);
		}
		
		br.close();
		
//		int n = 999;
//		System.out.println("IsTidy " + n + " = " + isTidy(n));
	}
}
