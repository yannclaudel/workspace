package com.structural.adapter;

import com.model.matrix.IMatrix;
import com.model.matrix.Matrix;
import com.model.matrix.NoneStdMatrix;

public class NoneStdMatrixAdaptor extends NoneStdMatrix implements IMatrix {

	public NoneStdMatrixAdaptor(int m, int n) {
		super(m, n);
	}

	public NoneStdMatrixAdaptor(int m, int n, double[][] data) {
		super(m, n, data);
	}

	@Override
	public IMatrix times(Matrix B) {
		NoneStdMatrix C = this.times(B.getData());
		return new Matrix(C.getM(), C.getN(), C.getData());
	}

	@Override
	public void display() {
		System.out.println("---------------------------");
		for (int i = 0; i < this.getM(); i++) {
			for (int j = 0; j < this.getN(); j++) {
				System.out.print(this.getData()[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

}
