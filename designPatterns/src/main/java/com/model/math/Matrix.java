package com.model.math;

public class Matrix implements IMatrix {
    private final int m;             // number of rows
    private final int n;             // number of columns
    private final double[][] data;   // M-by-N array

    // create M-by-N matrix of 0's
    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        data = new double[m][n];
    }

    // create matrix based on 2d array
    public Matrix(double[][] data) {
        m = data.length;
        n = data[0].length;
        this.data = new double[m][n];
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				this.data[i][j] = data[i][j];
			}
		}
    }

    // copy constructor
    private Matrix(Matrix A) { this(A.data); }

    // create and return a random M-by-N matrix with values between 0 and 1
    public static IMatrix random(int m, int n) {
        Matrix A = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A.data[i][j] = Math.random();
			}
		}
        return A;
    }

    // create and return the N-by-N identity matrix
    public static IMatrix identity(int n) {
        Matrix I = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
			I.data[i][i] = 1;
		}
        return I;
    }

    // swap rows i and j
    private void swap(int i, int j) {
        double[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // create and return the transpose of the invoking matrix
    /* (non-Javadoc)
	 * @see com.model.math.IMatrix#transpose()
	 */
    @Override
	public IMatrix transpose() {
        Matrix A = new Matrix(n, m);
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A.data[j][i] = this.data[i][j];
			}
		}
        return A;
    }

    // return C = A + B
    /* (non-Javadoc)
	 * @see com.model.math.IMatrix#plus(com.model.math.Matrix)
	 */
    @Override
	public IMatrix plus(Matrix B) {
        Matrix A = this;
        if (B.m != A.m || B.n != A.n) {
			throw new RuntimeException("Illegal matrix dimensions.");
		}
        Matrix C = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				C.data[i][j] = A.data[i][j] + B.data[i][j];
			}
		}
        return C;
    }


    // return C = A - B
    /* (non-Javadoc)
	 * @see com.model.math.IMatrix#minus(com.model.math.Matrix)
	 */
    @Override
	public IMatrix minus(Matrix B) {
        Matrix A = this;
        if (B.m != A.m || B.n != A.n) {
			throw new RuntimeException("Illegal matrix dimensions.");
		}
        Matrix C = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				C.data[i][j] = A.data[i][j] - B.data[i][j];
			}
		}
        return C;
    }

    // does A = B exactly?
    /* (non-Javadoc)
	 * @see com.model.math.IMatrix#eq(com.model.math.Matrix)
	 */
    @Override
	public boolean eq(Matrix B) {
    	
        Matrix A = this;
        if (B.m != A.m || B.n != A.n) {
			throw new RuntimeException("Illegal matrix dimensions.");
		}
        boolean rtn = true;
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (A.data[i][j] != B.data[i][j]) {
					rtn = false;
					break;
				}
				if(!rtn) {
					break;
				}
			}
		}
        return rtn;
    }

    // return C = A * B
    /* (non-Javadoc)
	 * @see com.model.math.IMatrix#times(com.model.math.Matrix)
	 */
    @Override
	public IMatrix times(Matrix B) {
        Matrix A = this;
        if (A.n != B.m) {
			throw new RuntimeException("Illegal matrix dimensions.");
		}
        Matrix C = new Matrix(A.m, B.n);
        for (int i = 0; i < C.m; i++) {
			for (int j = 0; j < C.n; j++) {
				for (int k = 0; k < A.n; k++) {
					C.data[i][j] += A.data[i][k] * B.data[k][j];
				}
			}
		}
        return C;
    }


    // return x = A^-1 b, assuming A is square and has full rank
    /* (non-Javadoc)
	 * @see com.model.math.IMatrix#solve(com.model.math.Matrix)
	 */
    @Override
	public IMatrix solve(Matrix rhs) {
        if (m != n || rhs.m != n || rhs.n != 1) {
			throw new RuntimeException("Illegal matrix dimensions.");
		}

        // create copies of the data
        Matrix A = new Matrix(this);
        Matrix b = new Matrix(rhs);

        // Gaussian elimination with partial pivoting
        for (int i = 0; i < n; i++) {

            // find pivot row and swap
            int max = i;
            for (int j = i + 1; j < n; j++) {
				if (Math.abs(A.data[j][i]) > Math.abs(A.data[max][i])) {
					max = j;
				}
			}
            A.swap(i, max);
            b.swap(i, max);

            // singular
            if (A.data[i][i] == 0.0) {
				throw new RuntimeException("Matrix is singular.");
			}

            // pivot within b
            for (int j = i + 1; j < n; j++) {
				b.data[j][0] -= b.data[i][0] * A.data[j][i] / A.data[i][i];
			}

            // pivot within A
            for (int j = i + 1; j < n; j++) {
                double m = A.data[j][i] / A.data[i][i];
                for (int k = i+1; k < n; k++) {
                    A.data[j][k] -= A.data[i][k] * m;
                }
                A.data[j][i] = 0.0;
            }
        }

        // back substitution
        Matrix x = new Matrix(n, 1);
        for (int j = n - 1; j >= 0; j--) {
            double t = 0.0;
            for (int k = j + 1; k < n; k++) {
				t += A.data[j][k] * x.data[k][0];
			}
            x.data[j][0] = (b.data[j][0] - t) / A.data[j][j];
        }
        return x;
   
    }

}