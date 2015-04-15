package com.prabhash.codejam.google.year2008.round1A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * 
 * You are given two vectors v1=(x1,x2,...,xn) and v2=(y1,y2,...,yn). The scalar product of these vectors is a single number, 
 * calculated as x1y1+x2y2+...+xnyn.
 * 
 * Suppose you are allowed to permute the coordinates of each vector as you wish. Choose two permutations such that the scalar product 
 * of your two new vectors is the smallest possible, and output that minimum scalar product.
 * 
 * Input
 * The first line of the input file contains integer number T - the number of test cases. For each test case, the first line contains 
 * integer number n. The next two lines contain n integers each, giving the coordinates of v1 and v2 respectively.
 * 
 * @author prrathore
 *
 */
public class MinimumScalarProduct {

	/**
	 * The minimum scalar product can be calculated by sorting one verctor coeffients in ascending order and other vectors coefficients in
	 * descending order. Multiply these two vectors coefficients to get the lowest scalar product.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		
		try {
			
			String testCaseCount = br.readLine();
			
			for(int i = 1; i <= Integer.parseInt(testCaseCount); i++) {
				
				int numberOfElements = Integer.parseInt(br.readLine());
				
				String vector1 = br.readLine();
				String vector2 = br.readLine();
				
				String[] array1 = vector1.split(" ");
				String[] array2 = vector2.split(" ");
				
				int[] vectorArray1 = new int[numberOfElements];
				int[] vectorArray2 = new int[numberOfElements];
				
				for(int j = 0; j < numberOfElements; j++) {
					vectorArray1[j] = Integer.parseInt(array1[j]);
					vectorArray2[j] = Integer.parseInt(array2[j]);	
				}
				
				Arrays.sort(vectorArray1);
				Arrays.sort(vectorArray2);
				
				int scalarProduct = 0;
				
				for(int k = 0; k < numberOfElements; k++) {
					scalarProduct += (vectorArray1[k] * vectorArray2[numberOfElements - 1 - k]);
				}
				
				//Print the output
				System.out.println("Case #" + i + ": " + scalarProduct);
				
			}
			
		} finally {
			br.close();
		}

	}

}
