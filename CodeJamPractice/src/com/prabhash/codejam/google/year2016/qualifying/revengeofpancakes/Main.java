package com.prabhash.codejam.google.year2016.qualifying.revengeofpancakes;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));

		String line = br.readLine();
		int testCount = Integer.parseInt(line);

		for (int testCase = 1; testCase <= testCount; testCase++) {
			
			String input = br.readLine();
			int minManeuver = findMinManeuver(input.toCharArray(), input.length() - 1);
			
			System.out.println("Case #" + testCase + ": " + minManeuver);
		}
	}
	
	public static int findMinManeuver(final char[] pancakes, int pos) {
		
		if(pancakes == null) {
			throw new NullPointerException();
		}
		
		int i = -1, j = -1;
		int flipCount = 0;
		
		while(pos >= 0 && pancakes[pos] == '+') {
			pos--;
		}
		
		int originalPos = pos;
		
		if(pos < 0) {
			return flipCount;
		}
		
		while(pos >= 0) {
			
			originalPos = pos;
			int sideChange = 0;
			
			i = pos;
			while(pos >= 0 && pancakes[pos] == '-') {
				pos--;
			}
			
			if(pos >= 0) {
				sideChange++;
			}
			
			j = pos;
			while(pos >= 0 && pancakes[pos] == '+') {
				pos--;
			}
			
			if(pos >= 0) {
				sideChange++;
			}
			
			if(sideChange >= 2) {
				flipPanCakes(pancakes, i);
				flipCount++;
				
				while(pancakes[i] == '+') {
					i--;
				}
				
				pos = i;
				continue;
			} else if(sideChange == 1) {
				flipPanCakes(pancakes, j);
				flipCount++;
				pos = i;
				continue;
			} else if(sideChange == 0) {
				if(pancakes[0] == '+') {
					return flipCount;
				} else {
					flipPanCakes(pancakes, originalPos);
					flipCount++;
					return flipCount;
				}
				
			}
		}
		
		return flipCount;
	}
	
	private static void flipPanCakes(final char[] ch, int i) {
		
		int start = 0;
		int end = i;
		
		while(start < ch.length && end >= 0 && end >= start) {
			
			char temp = ch[start];
			
			char invertedEndChar = invertSinglePanCake(ch[end]);
			ch[start] = invertedEndChar;
			
			char invertedStartChar = invertSinglePanCake(temp);
			ch[end] = invertedStartChar;
				
			end--;
			start++;
		}
	}
	
	private static char invertSinglePanCake(char c) {
		
		if(c == '+') {
			return '-';
		} else {
			return '+';
		}
	}
}
