package io.github.amohtashami.service;

import io.github.amohtashami.model.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of ITraverseService which is traverse matrix by spiral pattern (right-down-left-up)
 *
 * @Author alieh on 9/19/22
 */

public class SpiralTraverse<T> implements ITraverseService<T> {
	/**
	 * spiral traverse on matrix can be seen as starting form first item at position(0,0)
	 * iterating going right, down, left, up, and after each step make the current row/column as visited, until no item remains
	 *
	 * @param matrix a not-null,not-empty 2D array in-which number of elements in all rows are the same
	 * @return a list consists of spiral traverse of matrix
	 */
	@Override
	public List<T> traverse(Matrix<T> matrix) {
		List<T> result = new ArrayList<>();
		int minRowToVisit = 0;
		int minColToVisit = 0;
		int maxRowToVisit = matrix.getRowDimension() - 1;
		int maxColToVisit = matrix.getColumnDimension() - 1;
		while (isThereUnvisitedItem(minRowToVisit, maxRowToVisit, minColToVisit, maxColToVisit)) {
			result.addAll(goRight(matrix.getElementsAtRow(minRowToVisit), minColToVisit, maxColToVisit));
			++minRowToVisit;
			result.addAll(goDown(matrix.getElementsAtColumn(maxColToVisit), minRowToVisit, maxRowToVisit));
			--maxColToVisit;
			if (minRowToVisit <= maxRowToVisit)
				result.addAll(goLeft(matrix.getElementsAtRow(maxRowToVisit), maxColToVisit, minColToVisit));
			maxRowToVisit--;
			if (minColToVisit <= maxColToVisit)
				result.addAll(goUp(matrix.getElementsAtColumn(minColToVisit), maxRowToVisit, minRowToVisit));
			minColToVisit++;
		}
		return result;

	}

	/**
	 * check if there is any unvisited element in matrix by comparing visited index of rows and columns
	 * if minRowToVisit> maxRowToVisit means we visit all rows and hence all elements
	 * if minColToVisit> maxColToVisit means we visit all column and hence all elements
	 *
	 * @param minRowToVisit the upmost row-index which is not visited yet, and we are going to visit
	 * @param maxRowToVisit the lowermost row-index which is not visited yet, and we are going to visit
	 * @param minColToVisit the leftmost column-index which is not visited yet, and we are going to visit
	 * @param maxColToVisit the rightmost column-index which is not visited yet, and we are going to visit
	 * @return true if there is any unvisited element in matrix, false otherwise
	 */
	private boolean isThereUnvisitedItem(int minRowToVisit, int maxRowToVisit, int minColToVisit, int maxColToVisit) {
		return minColToVisit <= maxColToVisit && minRowToVisit <= maxRowToVisit;
	}

	/**
	 * visit a row in matrix from left to right start from startColIdx to endColIdx (include both)
	 *
	 * @param currentRowItems list of items in a specific column
	 * @param startColIdx     starting index, included
	 * @param endColIdx       end index, included
	 * @return list of items in a specific row from startColIdx to endColIdx
	 */
	private List<T> goRight(List<T> currentRowItems, int startColIdx, int endColIdx) {
		List<T> result = new ArrayList<>();
		for (int col = startColIdx; col <= endColIdx; ++col)
			result.add(currentRowItems.get(col));
		return result;
	}

	/**
	 * visit a column in matrix from up to down start from startRowIdx to endRowIdx (include both)
	 *
	 * @param currentColumnItems list of items in a specific row
	 * @param startRowIdx        starting index, included
	 * @param endRowIdx          end index, included
	 * @return list of items in a specific column from startRowIdx to endRowIdx
	 */
	private List<T> goDown(List<T> currentColumnItems, int startRowIdx, int endRowIdx) {
		List<T> result = new ArrayList<>();
		for (int row = startRowIdx; row <= endRowIdx; ++row)
			result.add(currentColumnItems.get(row));
		return result;
	}

	/**
	 * visit a row in matrix from right to left start from startColIdx to endColIdx (include both)
	 *
	 * @param currentRowItems list of items in a specific row
	 * @param startColIdx     starting index, included
	 * @param endColIdx       end index, included
	 * @return list of items in a specific row from startColIdx to endColIdx
	 */
	private List<T> goLeft(List<T> currentRowItems, int startColIdx, int endColIdx) {
		List<T> result = new ArrayList<>();
		for (int col = startColIdx; col >= endColIdx; --col)
			result.add(currentRowItems.get(col));
		return result;
	}

	/**
	 * visit a column in matrix from down to up start from startRowIdx to endRowIdx (include both)
	 *
	 * @param currentColumnItems list of items in a specific column
	 * @param startRowIdx        starting index, included
	 * @param endRowIdx          end index, included
	 * @return list of items in a specific column from startRowIdx to endRowIdx
	 */
	private List<T> goUp(List<T> currentColumnItems, int startRowIdx, int endRowIdx) {
		List<T> result = new ArrayList<>();
		for (int row = startRowIdx; row >= endRowIdx; --row)
			result.add(currentColumnItems.get(row));
		return result;
	}

}
