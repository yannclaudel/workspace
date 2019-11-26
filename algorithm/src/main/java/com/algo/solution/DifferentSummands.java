package com.algo.solution;
import java.util.ArrayList;
import java.util.List;

public class DifferentSummands{
	
	/**
	 * TODO
	 * @param n
	 * @return int[]
	 */
	
    public static int[] optimalSummands(final int n) {
        final List<Integer> summands = new ArrayList<>();

        int remaind = n;
        
        for (int i = 1; i <= n; i++) {        
        	if (i<remaind-i || i == remaind) {
        		summands.add(new Integer(i));
        		remaind-=i;        		
        	} 						
		}

        return summands.stream().mapToInt(i -> i.intValue()).toArray();
    }
    
}

