package com.prabhash.codejam.google.year2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * You receive a credit C at a local store and would like to buy two items. You first walk through the store and create a list L of 
 * all available items. From this list you would like to buy two items that add up to the entire value of the credit. The solution you 
 * provide will consist of the two integers indicating the positions of the items in your list (smaller number first).
 * 
 * Note: Same item cannot be bought twice as there is only one item of each kind in the store.
 * 
 * Inputs:
 * A-small-practice.in
 * A-large-practice.in
 * 
 * @author prrathore
 *
 */

public class StoreCredit {
	
	/**
	 * Brute Force Algorithm to find the position of exact two items in the given list to be bought whose sum is equal to
	 * the given credit.
	 * 
	 * Time Complexity: O(n ^ 2)
	 * Space Complexity: O(1)
	 * 
	 * @param credit
	 * @param numberOfItems
	 * @param itemPrice
	 */
	public static void buyTwoItems(int testCase, int credit, int numberOfItems, final int[] itemPrice) {
		
		int firstItemPos = -1;
		int secondItemPos = -1;
		
		for(int i = 0; i < numberOfItems - 1; i++) {
			firstItemPos = i;
			
			for(int j = i + 1; j < numberOfItems; j++) {
				
				if(itemPrice[firstItemPos] + itemPrice[j] == credit) {
					secondItemPos = j;
					break;
				}
				
			}
			
			if(secondItemPos > 0) {
				break;
			}
		}
		
		System.out.println("Case #" + testCase + ": " + (firstItemPos + 1) + " " + (secondItemPos + 1));
		
	}
	
	/**
	 * Method 2 to improve time complexity of this program.
	 * 
	 * For each test case:
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void buyTwoItemsUsingMap(int testCase, int credit, int numberOfItems, final int[] itemPrice) {
		
		//store all item price in a Hash Map to improve the comparison operation time
		Map<Integer, Integer> priceMap = new HashMap<Integer, Integer>();
		
		int firstItemPos = -1;
		int secondItemPos = -1;
		
		for(int i = 0; i < numberOfItems; i++) {
			priceMap.put(itemPrice[i], i);
		}
		
		for(int i = 0; i < numberOfItems; i++) {
			
			int remainingCredit = credit - itemPrice[i];
			
			if(priceMap.containsKey(remainingCredit)) {
				
				//since same item can't be bought twice so for such scenario skip the current iteration
				if(i == priceMap.get(remainingCredit)) {
					continue;
				}
				
				firstItemPos = i;
				secondItemPos = priceMap.get(credit - itemPrice[i]);
				break;
			}
		}
		
		System.out.println("Case #" + testCase + ": " + (firstItemPos + 1) + " " + (secondItemPos + 1));
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		
		try {
			
	        String line = br.readLine();
	        
	        int numberOfTestCases = Integer.parseInt(line);

	        for(int testCase = 1; testCase <= numberOfTestCases; testCase++) {
	        	
	        	int credit = Integer.parseInt(br.readLine());
	        	int numberOfItems = Integer.parseInt(br.readLine());
	        	
	        	String itemListing = br.readLine();
	        	String[] itemList = itemListing.split(" ");
	        	
	        	int[] itemPrices = new int[numberOfItems];
	        	
	        	for(int i = 0; i < itemList.length; i++) {
	        		itemPrices[i] = Integer.parseInt(itemList[i]);
	        	}
	        	
	        	//call the method which finds the position of two items to be bought
	        	//buyTwoItems(testCase, credit, numberOfItems, itemPrices); //Time Complexity: O(n ^ 2)
	        	buyTwoItemsUsingMap(testCase, credit, numberOfItems, itemPrices); //Time Complexity: O(n)
	        	
	        }
	        
	    } finally {
	        br.close();
	    }
		
	}

}
