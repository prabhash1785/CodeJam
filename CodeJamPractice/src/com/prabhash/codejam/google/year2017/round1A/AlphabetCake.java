package com.prabhash.codejam.google.year2017.round1A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlphabetCake {
	
	/**
	 * Greedy Approach to fill Grid Cake in rectangular shapes
	 * 
	 * @param grid
	 * @param list
	 * @param emptyCells
	 */
	public static void distributeCake(char[][] grid, List<Node> list, int emptyCells) {
		if(list.size() == 0 || emptyCells == 0) {
			return;
		}
		
		Iterator<Node> iter = list.iterator();
		while(iter.hasNext()) {
			Node node = iter.next();
			
			int row = node.row;
			int col = node.col;
			char c = grid[row][col];
			int start = col;
			int end = col;
			
			// go right
			for(int i = col + 1; i < grid[0].length; i++) {
				if(grid[row][i] == '?') {
					grid[row][i] = c;
					--emptyCells;
					end = i;
					
					if(emptyCells == 0) {
						return;
					}
				} else {
					break;
				}
			}
			
			// go left
			for(int i = col - 1; i >= 0; i--) {
				if(grid[row][i] == '?') {
					grid[row][i] = c;
					--emptyCells;
					start = i;
					
					if(emptyCells == 0) {
						return;
					}
				} else {
					break;
				}
			}
			
			if(emptyCells < (end - start)) {
				continue;
			}
			
			// check if top rows have same cells empty to form a rectangle
			for(int i = row - 1; i >= 0; i--) {
				boolean valid = true;
				for(int j = start; j <= end; j++) {
					if(grid[i][j] != '?') {
						valid = false;
						break;
					}
				}
				
				if(valid) {
					for(int j = start; j <= end; j++) {
						grid[i][j] = c;
						--emptyCells;
						if(emptyCells == 0) {
							return;
						}
					}
				} else {
					break;
				}
			}
			
			// check if bottom rows have same cells empty to form a rectangle
			for(int i = row + 1; i < grid.length; i++) {
				boolean valid = true;
				for(int j = start; j <= end; j++) {
					if(grid[i][j] != '?') {
						valid = false;
						break;
					}
				}
				
				if(valid) {
					for(int j = start; j <= end; j++) {
						grid[i][j] = c;
						--emptyCells;
						if(emptyCells == 0) {
							return;
						}
					}
				} else {
					break;
				}
			}
		}
	}

	public static void printGrid(char[][] grid) {
//		System.out.println("Here is grid:");
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public static class Node {
		private char val;
		private int row;
		private int col;
		
		public Node() {
			this(-1, -1);
		}
		
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
		String line = bufferedReader.readLine();
		int testCount = Integer.parseInt(line);
//		System.out.println("Test case count: " + testCount);
		for (int i = 1; i <= testCount; i++) {
			String word = bufferedReader.readLine();
//			System.out.println("row-col: " + word);
			String[] tokens = word.split(" ");
			int row = Integer.parseInt(tokens[0]);
			int col = Integer.parseInt(tokens[1]);
//			System.out.println("Row: " + row + " :: col: " + col);
			
			char[][] grid = new char[row][col];
			int emptyCells = 0;
			List<Node> list = new ArrayList<>();
			for(int x = 0; x < row; x++) {
				String rowLine = bufferedReader.readLine();
				for(int y = 0; y < rowLine.length(); y++) {
					if(rowLine.charAt(y) == '?') {
						emptyCells += 1;
					} else {
						list.add(new Node(x, y));
					}
					grid[x][y] = rowLine.charAt(y);
				}
			}
			
//			System.out.println("Original Grid:");
//			printGrid(grid);
			
			distributeCake(grid, list, emptyCells);
			
//			System.out.println("Final Grid:");
			System.out.println("Case #" + i + ":");
			printGrid(grid);
		}

	}

}
