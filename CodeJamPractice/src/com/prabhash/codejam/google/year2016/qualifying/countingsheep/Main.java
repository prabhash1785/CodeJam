package com.prabhash.codejam.google.year2016.qualifying.countingsheep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(args[0]));

		String line = br.readLine();
		int testCount = Integer.parseInt(line);

		for (int i = 1; i <= testCount; i++) {

			String text = br.readLine();
			int input = Integer.parseInt(text);
			int finalSleepNumber = -1;

			final Map<Integer, Boolean> map = new HashMap<>();
			for(int x = 0; x <= 9; x++) {
				map.put(x, false);
			}
			
			int k = 1;
			boolean isInsomnia = false;
			
			while(true) {
				
				int nextNumber = k * input;
				
				if(k > 1 && nextNumber == input) {
					System.out.println("Case #" + i + ": INSOMNIA");
					isInsomnia = true;
					break;
				}
				
				parseInput(nextNumber, map);
				
				if(checkMapHasAllDigits(map)) {
					finalSleepNumber = nextNumber;
					break;
				}
				
				k++;
			}
			
			if(!isInsomnia) {
				System.out.println("Case #" + i + ": " + finalSleepNumber);
			}
		}	
	}
	
	private static void parseInput(int number, final Map<Integer, Boolean> map) {
		
		if(number == 0) {
			map.put(number, true);
			return;
		}
		
		while(number > 0) {
			
			int digit = number % 10;
			map.put(digit, true);
			number = number / 10;
		}
	}
	
	private static boolean checkMapHasAllDigits(final Map<Integer, Boolean> map) {
		
		for(int i = 0; i <= 9; i++) {
			
			if(!map.get(i)) {
				return false;
			}
		}
		
		return true;
	}
}
