package com.prabhash.codejam.google.year2017.round1B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Cruise Control
 * 
 * @author Prabhash Rathore
 *
 */
public class CruiseControl {
	
	public static double findMaxSpeed(int distance, List<Integer> dList, List<Integer> sList) {
		double maxSpeed = 0.0;
		
		double maxTime = 0.0;
		for(int i = 0; i < dList.size(); i++) {
			int dis = distance - dList.get(i);
			double t = (double) dis / sList.get(i);
			
			if(t > maxTime) {
				maxTime = t;
			}
		}
		
		maxSpeed = distance / maxTime;
//		System.out.println("Max Speed: " + maxSpeed);
		
		return maxSpeed;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
		String line = bufferedReader.readLine();
		int testCount = Integer.parseInt(line);
//		System.out.println("Test case count: " + testCount);
		for (int i = 1; i <= testCount; i++) {
			String line1 = bufferedReader.readLine();
//			System.out.println("Line 1: " + line1);
			String[] tokens = line1.split(" ");
			int distance = Integer.parseInt(tokens[0]);
			int horseCount = Integer.parseInt(tokens[1]);
//			System.out.println("Distance: " + distance + ", horsecount: " + horseCount);
			
			List<Integer> iniPosList = new ArrayList<>();
			List<Integer> speedList = new ArrayList<>();
			for(int j = 0; j < horseCount; j++) {
				String l = bufferedReader.readLine();
//				System.out.println("Line " + j + ":" + l);
				String[] t = l.split(" ");
//				System.out.println(j + ": IniPos: " + t[0] + " :: Speed: " + t[1]);
				iniPosList.add(Integer.parseInt(t[0]));
				speedList.add(Integer.parseInt(t[1]));
			}
			
			double maxSpeed = findMaxSpeed(distance, iniPosList, speedList);
			System.out.println("Case #" + i + ": " + maxSpeed);
		}
	}
}
