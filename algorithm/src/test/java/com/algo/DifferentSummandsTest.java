package com.algo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.DifferentSummands;

public class DifferentSummandsTest {

	
	@ParameterizedTest
	@MethodSource("solution")
	public void testWithMultiArgMethodSource(int n,int nbr) {
		int[] sol = DifferentSummands.optimalSummands(n);
		 for (int i : sol) {
	        	System.out.print(i + " ");
			}
		 System.out.println("");
		assertTrue(checkSol(sol,n,nbr));
	}
	
	private boolean checkSol(int sol[],int n,int nbr) {
		if (sol==null || sol.length==0) {
			return false;
		}
		if (sol.length!=nbr) {
			return false;
		}
		boolean rtn = true;
		Arrays.sort(sol);
		int sum = sol[0];
		for (int i = 1; i < sol.length; i++) {
			sum+=sol[i];
			if(sol[i]==sol[i-1]) {
				rtn = false;break; 
			} 
		}
		if (sum!=n) {
			rtn = false;
		}
		return rtn;
	}

	@SuppressWarnings("boxing")
	public static Stream<Arguments> solution() {
	    return Stream.of(
	        Arguments.of(10,4),
	        Arguments.of(11,4),
	        Arguments.of(45,9),
	        Arguments.of(52,9),
	        Arguments.of(2,1)
	    );
	}
	
}
