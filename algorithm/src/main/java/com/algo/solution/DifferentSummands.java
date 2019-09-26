package com.algo.solution;
import java.util.*;

public class DifferentSummands {
	
	/**
	 * TODO
	 * @param n
	 * @return int[]
	 */
	
    public static int[] optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();

        int remaind = n;
        
        for (int i = 1; i <= n; i++) {        
        	if (i<remaind-i || i == remaind) {
        		summands.add(new Integer(i));
        		remaind-=i;        		
        	} 						
		}

        return summands.stream().mapToInt(i -> i.intValue()).toArray();
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

