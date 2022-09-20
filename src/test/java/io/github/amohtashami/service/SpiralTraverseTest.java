package io.github.amohtashami.service;

import io.github.amohtashami.enums.EnumServiceName;
import io.github.amohtashami.model.Matrix;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author alieh on 9/19/22
 */

class SpiralTraverseTest {
	ITraverseService<Integer> traverseService = ServiceFactory.getTraverseService(EnumServiceName.SPIRAL);

	@ParameterizedTest
	@MethodSource("provideDifferentMatrixForTraverse")
	void traverse_ShouldReturnSpiralTraverse(Matrix<Integer> matrix, List<Integer> expected) {
		assertEquals(expected, traverseService.traverse(matrix));
	}

	private static Stream<Arguments> provideDifferentMatrixForTraverse() {
		return Stream.of(
				Arguments.of(new Matrix<>(new Integer[][]{{10}}), Arrays.asList(10)),//one item
				Arguments.of(new Matrix<>(new Integer[][]{//column matrix
						{1},
						{6},
						{9}
				}), Arrays.asList(1, 6, 9)),
				Arguments.of(new Matrix<>(new Integer[][]{//row matrix
						{1, 4, 7}
				}), Arrays.asList(1, 4, 7)),
				Arguments.of(new Matrix<>(new Integer[][]{//rectangular matrix (roes=columns)
						{2, 4, 5},
						{1, 8, 9},
						{6, 10, 11}
				}), Arrays.asList(2, 4, 5, 9, 11, 10, 6, 1, 8)),
				Arguments.of(new Matrix<>(new Integer[][]{//rows>columns
						{2, 4, 5},
						{3, 12, 7},
						{1, 8, 9},
						{6, 10, 11}
				}), Arrays.asList(2, 4, 5, 7, 9, 11, 10, 6, 1, 3, 12, 8)),
				Arguments.of(new Matrix<>(new Integer[][]{//rows<columns
						{2, 4, 5, 10},
						{3, 2, 7, 12},
						{1, 8, 9, 11}
				}), Arrays.asList(2, 4, 5, 10, 12, 11, 9, 8, 1, 3, 2, 7))
		);
	}

}