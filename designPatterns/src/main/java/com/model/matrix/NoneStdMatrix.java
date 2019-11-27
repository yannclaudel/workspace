package com.model.matrix;

public class NoneStdMatrix {
	private final int m; // number of rows
	private final int n; // number of columns
	private final double[][] data; // M-by-N array

	public NoneStdMatrix(int m, int n) {
		this.m = m;
		this.n = n;
		data = new double[m][n];
	}

	public NoneStdMatrix(int m, int n, double[][] data) {
		this.m = m;
		this.n = n;
		this.data = data;
	}

	public NoneStdMatrix times(double[][] B) {
		NoneStdMatrix A = this;
		if (A.n != B.length) {
			throw new RuntimeException("Illegal matrix dimensions.");
		}
		NoneStdMatrix C = new NoneStdMatrix(A.m, B.length);
		for (int i = 0; i < C.m; i++) {
			for (int j = 0; j < C.n; j++) {
				for (int k = 0; k < A.n; k++) {
					C.data[i][j] += A.data[i][k] * B[k][j];
				}
			}
		}
		return C;
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public double[][] getData() {
		return data;
	}

}
