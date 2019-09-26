package com.algo.exercice;
import java.util.*;

public class DifferentSummands {
	
	/**
	 * TODO
	 * @param n
	 * @return int[]
	 */
	
    public static int[] optimalSummands(int n) {
        return new int[1];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] summands = optimalSummands(n);
        for (int i : summands) {
        	System.out.print(i + " ");
		}
        scanner.close();
    }
}

