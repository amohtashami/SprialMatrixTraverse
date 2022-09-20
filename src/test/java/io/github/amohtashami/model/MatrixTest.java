package io.github.amohtashami.model;

import io.github.amohtashami.exception.InvalidMatrixException;
import io.github.amohtashami.exception.WrongIndexException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author alieh on 9/19/22
 */
class MatrixTest {
	@Test
	void testConstructor_throwInvalidMatrixException_withUnbalancedInput() {
		InvalidMatrixException thrown = Assertions.assertThrows(InvalidMatrixException.class, () -> {
			new Matrix<>(new Integer[][]{
					{2, 4, 5},
					{3, 2}
			});
		});
		Assertions.assertEquals("number of elements in all rows must be equal", thrown.getMessage());
	}

	@Test
	void constructor_throwInvalidMatrixException_withEmptyInput() {
		InvalidMatrixException thrown = Assertions.assertThrows(InvalidMatrixException.class, () -> {
			new Matrix<>(new Integer[][]{});
		});
		Assertions.assertEquals("matrix should have at least on element", thrown.getMessage());

	}

	@Test
	void constructor_throwInvalidMatrixException_withNullInput() {
		InvalidMatrixException thrown = Assertions.assertThrows(InvalidMatrixException.class, () -> {
			new Matrix<>(null);
		});
		Assertions.assertEquals("matrix should have at least on element", thrown.getMessage());

	}

	@Test
	void getElementsAtColumn_throwWrongIndexException_withInvalidColumnIndex() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		WrongIndexException thrown = Assertions.assertThrows(WrongIndexException.class, () -> {
			matrix.getElementsAtColumn(7);
		});
		Assertions.assertEquals("column index should be positive and less than number of columns", thrown.getMessage());


	}

	@Test
	void getElementsAtColumn_throwWrongIndexException_withNegativeColumnIndex() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		WrongIndexException thrown = Assertions.assertThrows(WrongIndexException.class, () -> {
			matrix.getElementsAtColumn(-2);
		});
		Assertions.assertEquals("column index should be positive and less than number of columns", thrown.getMessage());
	}

	@Test
	void getElementsAtColumn_checkAssertion_withValidColumnIndex() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		Assertions.assertEquals(Arrays.asList(4, 2), matrix.getElementsAtColumn(1));
	}

	@Test
	void getElementsAtRow_throwWrongIndexException_withNegativeRowIndex() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		WrongIndexException thrown = Assertions.assertThrows(WrongIndexException.class, () -> {
			matrix.getElementsAtRow(-7);
		});
		Assertions.assertEquals("row index should be positive and less than number of rows", thrown.getMessage());
	}

	@Test
	void getElementsAtRow_throwWrongIndexException_withInvalidRowIndex() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		WrongIndexException thrown = Assertions.assertThrows(WrongIndexException.class, () -> {
			matrix.getElementsAtRow(7);
		});
		Assertions.assertEquals("row index should be positive and less than number of rows", thrown.getMessage());
	}

	@Test
	void getElementsAtRow_checkAssertion_withValidRowIndex() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		Assertions.assertEquals(Arrays.asList(3, 2, 7), matrix.getElementsAtRow(1));
	}

	@Test
	void getItem_checkAssertion_withValidInputs() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		Assertions.assertEquals(Integer.valueOf(3), matrix.getItem(1, 0));
	}

	@Test
	void getItem_throwWrongIndexException_withInvalidRowIndex() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		WrongIndexException thrown = Assertions.assertThrows(WrongIndexException.class, () -> {
			matrix.getItem(10, 0);
		});
		Assertions.assertEquals("invalid input for column index or row index", thrown.getMessage());

	}

	@Test
	void getItem_throwWrongIndexException_withInvalidColumnIndex() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		WrongIndexException thrown = Assertions.assertThrows(WrongIndexException.class, () -> {
			matrix.getItem(1, -5);
		});
		Assertions.assertEquals("invalid input for column index or row index", thrown.getMessage());
	}

	@Test
	void getColumnDimension_checkAssertion_withValidInput() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		Assertions.assertEquals(3, matrix.getColumnDimension());
	}

	@Test
	void getRowDimension_checkAssertion_withValidInput() {
		Matrix<Integer> matrix = new Matrix<>(new Integer[][]{
				{2, 4, 5},
				{3, 2, 7}
		});
		Assertions.assertEquals(2, matrix.getRowDimension());
	}

}