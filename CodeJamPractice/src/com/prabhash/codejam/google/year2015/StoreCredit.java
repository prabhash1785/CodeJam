package com.prabhash.codejam.google.year2015;

/**
 * Problem:
 * You receive a credit C at a local store and would like to buy two items. You first walk through the store and create a list L of 
 * all available items. From this list you would like to buy two items that add up to the entire value of the credit. The solution you 
 * provide will consist of the two integers indicating the positions of the items in your list (smaller number first).
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
	public static void buyTwoItems(int credit, int numberOfItems, final int[] itemPrice) {
		
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
		
		System.out.println("First item position: " + (firstItemPos + 1));
		System.out.println("Seocnd item position: " + (secondItemPos + 1));
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
//		int credit = 100;
//		int numberOfItems = 3;
//		int[] itemList = {5, 75, 25};
		
//		int credit = 200;
//		int numberOfItems = 7;
//		int[] itemList = {150, 24, 79, 50, 88, 345, 3};
		
		int credit = 8;
		int numberOfItems = 8;
		int[] itemList = {2, 1, 9, 4, 4, 56, 90, 3};
		
		buyTwoItems(credit, numberOfItems, itemList);
		
	}

}
