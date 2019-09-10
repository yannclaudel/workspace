package com.model.math;

public interface IMatrix {

	// create and return the transpose of the invoking matrix
	IMatrix transpose();

	// return C = A + B
	IMatrix plus(Matrix B);

	// return C = A - B
	IMatrix minus(Matrix B);

	// does A = B exactly?
	boolean eq(Matrix B);

	// return C = A * B
	IMatrix times(Matrix B);

	// return x = A^-1 b, assuming A is square and has full rank
	IMatrix solve(Matrix rhs);

}