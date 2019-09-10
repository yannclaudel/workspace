package com.model.matrix;

public class Matrix implements IMatrix {
	private final int m; // number of rows
	private final int n; // number of columns
	private final double[][] data; // M-by-N array

	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		data = new double[m][n];
	}

	public Matrix(int m, int n, double[][] data) {
		super();
		this.m = m;
		this.n = n;
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.model.matrix.IMatrix#times(com.model.matrix.Matrix)
	 */
	@Override
	public IMatrix times(Matrix B) {
		Matrix A = this;
		if (A.n != B.m)
			throw new RuntimeException("Illegal matrix dimensions.");
		Matrix C = new Matrix(A.m, B.n);
		for (int i = 0; i < C.m; i++)
			for (int j = 0; j < C.n; j++)
				for (int k = 0; k < A.n; k++) {
					C.data[i][j] += A.data[i][k] * B.data[k][j];
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

	@Override
	public void display() {
		System.out.println("---------------------------");
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

}
