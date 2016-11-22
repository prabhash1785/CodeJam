package com.prabhash.codejam.google.year2016.qualifying.coinjam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargeCoinJamProb {
	
	private static Map<BigInteger, Boolean> isPrimeCache = new HashMap<>();
	private static Map<String, Set<BigInteger>> divisorCache = new HashMap<>();

	public static void main(String[] args) throws Exception {

		long startTime = System.nanoTime();
		System.out.println("Start time: " + startTime);
		BufferedReader br = new BufferedReader(new FileReader(args[0]));

		String line = br.readLine();
		int testCount = Integer.parseInt(line);

		for (int testCase = 1; testCase <= testCount; testCase++) {
			
			String input = br.readLine();
			
			
			
			String[] tokenizedInput = input.split(" ");
			int n = Integer.parseInt(tokenizedInput[0]);
			int j = Integer.parseInt(tokenizedInput[1]);
			
			List<String> powerSet = findAllBinarySubSets(n, j * 2);
			Map<String, Set<BigInteger>> coinWithDivisors = findValidCoinJam(powerSet, j);
			
			printOutput(testCase, coinWithDivisors);
			long endTime = System.nanoTime();
			System.out.println("End time: " + endTime);
			double billion = Math.pow(10, 9);
			System.out.println("billion = " + billion);
			System.out.println("Total time taken: " + ((endTime - startTime) / billion));
		}		
	}

	private static Map<String, Set<BigInteger>> findValidCoinJam(List<String> list, int j) {
		
		Map<String, Set<BigInteger>> map = new HashMap<String, Set<BigInteger>>();
		int count = 0;
		
		for(String s : list) {
			
			if(isValidCoinJam(s)) {
				Set<BigInteger> divisors = null;
				
				if(divisorCache.containsKey(s)) {
					divisors = divisorCache.get(s);
				} else {
					divisors = getPossibleDivisors(s, 9);
				}
				
				if(divisors != null) {
					map.put(s, divisors);
					count += 1;
				}
			}
			
			if(count == j) {
				break;
			}
		}
		
		return map;
	}
	
	private static boolean isValidCoinJam(String s) {
		
		for(int  i = 2; i <= 10; i++) {
			
			BigInteger baseNum = new BigInteger(s, i);

			if(isPrimeCache.containsKey(baseNum)) {
				if(isPrimeCache.get(baseNum)) {
					return false;
				} else {
					continue;
				}
			} else if(isPrime(baseNum)) {
				return false;
			}			
		}
		
		return true;
	}
	
	private static Set<BigInteger> getPossibleDivisors(String s, int maxDivisorCount) {
		
		int count = 1;
		Set<BigInteger> divisors = new LinkedHashSet<>();
		
		while(count <= maxDivisorCount) {
			
			int base = count + 1;
			boolean divisorFoundForIthBase = false;
			BigInteger baseNum = new BigInteger(s, base);
			BigInteger sqrtOfBaseNum = sqrt(baseNum);
			
			BigInteger TWO = BigInteger.valueOf(2);
			BigInteger ONE = BigInteger.ONE;
			BigInteger ZERO = BigInteger.ZERO;
			BigInteger j = TWO;
			
			while(j.compareTo(sqrtOfBaseNum) <= 0) {
				
				if(baseNum.mod(j).compareTo(ZERO) == 0) {
					
					if(!divisors.contains(j)) {
						System.out.println("baseNum = " + baseNum + " in base = " + base + " :: divisor = " + j);
						divisors.add(j);
						count++;
						divisorFoundForIthBase = true;
						break;
					}
				}
				
				j = j.add(ONE);
			}
			
			if(!divisorFoundForIthBase) {
				divisorCache.put(s, null);
				return null;
			}
		}
				
		if(count < maxDivisorCount) {
			divisorCache.put(s, null);
			return null;
		}
		return divisors;
	}
	
	public static BigInteger sqrt(BigInteger x) {
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}
	
	private static boolean isPrime(BigInteger n) {
		
		Boolean prime = n.isProbablePrime(1);
		isPrimeCache.put(n, prime);
		
		return prime;
	}
	
	private static List<String> findAllBinarySubSets(int n, int limit) {
		
		List<String> list = new ArrayList<>();
		n = n - 2; // since first and last bit are always 1
		int powerSetSize = (int) Math.pow(2, n);
		int count = 1;
		
		
		for(int i = 0; i < powerSetSize && count <= limit; i++, count++) {
			
			StringBuilder binary = new StringBuilder(Integer.toBinaryString(i));
			while(binary.length() < n) {
				binary = new StringBuilder("0").append(binary);
			}
			binary = new StringBuilder("1").append(binary).append("1");
			list.add(binary.toString());
		}
		return list;
	}
	
	private static void printOutput(int testCase, Map<String, Set<BigInteger>> divisorMap) {
		
		System.out.println("Case #" + testCase + ":");
		Set<String> keySet = divisorMap.keySet();
		
		for(String key : keySet) {
			
			System.out.print(key + " ");
			Set<BigInteger> divisors = divisorMap.get(key);
			for(BigInteger i : divisors) {
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
	}
}
