package com.structural.adapter;

import com.model.matrix.IMatrix;
import com.model.matrix.Matrix;

public class Test {
	
	
	public static void main(String[] args) {
		double[][] dataA = {{1,1},{1,1}};
		double[][] dataB = {{1,2},{1,2}};
		double[][] id = {{1,0},{0,1}};
		
		final IMatrix A = new Matrix(2, 2,dataA);		
		final IMatrix B = new NoneStdMatrixAdaptor(2, 2,dataB);
		
		A.times(new Matrix(2, 2,id)).display();
		B.times(new Matrix(2, 2,id)).display();
	}
}
