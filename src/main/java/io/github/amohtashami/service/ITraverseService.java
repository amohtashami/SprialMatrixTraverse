package io.github.amohtashami.service;

import io.github.amohtashami.model.Matrix;

import java.util.List;

/**
 * This Interface allows users to define different ways of traverse on a matrix
 * @Author alieh on 9/17/22
 */
public interface ITraverseService<T> {
	/**
	 * append all elements in a matrix to a list by a specific order
	 * @param matrix a not-null,not-empty 2D array in-which number of elements in all rows are the same
	 * @return a list of elements in matrix with a specific implemented order
	 */
	List<T> traverse(Matrix<T> matrix);
}
