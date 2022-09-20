package io.github.amohtashami.model;

import io.github.amohtashami.exception.InvalidMatrixException;
import io.github.amohtashami.exception.WrongIndexException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * A not-null,not-empty two-dimensional array with equal number of elements in all rows
 * @param <T> is a generic type and determined by user
 * @Author alieh on 9/19/22
 */
public class Matrix<T> {
	private T[][] items;

	public Matrix(T[][] items) {
		validate(items);
		this.items = items;
	}

	/**
	 * validate the input 2D array to be a matrix,(not-null,not-empty and all rows must have equal number of elements
	 * @param items a 2D array of generic type
	 * throws InvalidMatrixException on invalid index input
	 */
	private void validate(T[][] items) {
		if (items == null || items.length == 0)
			throw new InvalidMatrixException("matrix should have at least on element");
		int sizeOfFirstCol = items[0].length;
		for (int i = 1; i < items.length; ++i)
			if (items[i].length != sizeOfFirstCol)
				throw new InvalidMatrixException("number of elements in all rows must be equal");
	}

	/**
	 * get item at specific position based on inputs
	 * @param rowIdx index of row
	 * @param columnIdx index of column
	 * @return items[rowIdx][columnIdx]
	 * throws WrongIndexException on invalid index input
	 */
	public T getItem(int rowIdx, int columnIdx) {
		if (rowIdx >= 0 && rowIdx < getRowDimension() && columnIdx >= 0 && columnIdx < getColumnDimension())
			return items[rowIdx][columnIdx];
		throw new WrongIndexException("invalid input for column index or row index");
	}

	/**
	 * let clients recognize number of rows of matrix
	 * @return number of rows of matrix
	 */
	public int getRowDimension() {
		return items.length;
	}

	/**
	 * let clients recognize number of columns of matrix
	 * @return number of columns of matrix
	 */
	public int getColumnDimension() {
		return items[0].length;
	}

	/**
	 * get a specific row of matrix
	 * @param rowIdx index of row to get elements
	 * @return a list of all elements in a row
	 * throws WrongIndexException on invalid index input
	 */
	public List<T> getElementsAtRow(int rowIdx) {
		if (rowIdx >= 0 && rowIdx < getRowDimension())
			return Arrays.asList(items[rowIdx]);
		throw new WrongIndexException("row index should be positive and less than number of rows");
	}

	/**
	 * get a specific columns of matrix
	 * @param columnIdx index of row to get elements
	 * @return a list of all elements in a column
	 * throws WrongIndexException on invalid index input
	 */
	public List<T> getElementsAtColumn(int columnIdx) {
		if (columnIdx >= 0 && columnIdx < getColumnDimension())
			return IntStream.range(0, items.length).mapToObj(e -> items[e][columnIdx]).collect(Collectors.toList());
		throw new WrongIndexException("column index should be positive and less than number of columns");
	}
}
