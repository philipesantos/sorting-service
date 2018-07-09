package br.com.philipesantos.sortingservice.algorithms;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.philipesantos.sortingservice.operations.CompareOperation;
import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.operations.SwapOperation;

public class InsertionSortAlgorithmTest {
	@Test
	public void doesItReturnTheNumbersInCorrectOrder() {
		Integer[] numbers = new Integer[] { 5, 2, 1, 4, 3 };
		Integer[] expectedNumbers = new Integer[] { 1, 2, 3, 4, 5 };
		SortAlgorithm sortingAlgorithm = new InsertionSortAlgorithm();
		sortingAlgorithm.sort(numbers);
		assertArrayEquals(expectedNumbers, numbers);
	}
	
	@Test
	public void doesItReturnTheCorrectOperations() {
		Integer[] unsortedNumbers = new Integer[] { 5, 2, 1, 4, 3 };
		SortAlgorithm sortingAlgorithm = new InsertionSortAlgorithm();
		/*
		 * 5, 2, 1, 4, 3 | Initial state
		 * 5, 2, 1, 4, 3 | COMPARE: (1, 0)
		 * 2, 5, 1, 4, 3 | SWAP: (1, 0)
		 * 2, 5, 1, 4, 3 | COMPARE: (2, 1)
		 * 2, 1, 5, 4, 3 | SWAP: (2, 1)
		 * 2, 1, 5, 4, 3 | COMPARE: (1, 0)
		 * 1, 2, 5, 4, 3 | SWAP: (1, 0)
		 * 1, 2, 5, 4, 3 | COMPARE: (3, 2)
		 * 1, 2, 4, 5, 3 | SWAP: (3, 2)
		 * 1, 2, 4, 5, 3 | COMPARE: (2, 1)
		 * 1, 2, 4, 5, 3 | COMPARE: (1, 0)
		 * 1, 2, 4, 5, 3 | COMPARE: (4, 3)
		 * 1, 2, 4, 3, 5 | SWAP: (4, 3)
		 * 1, 2, 4, 3, 5 | COMPARE: (3, 2)
		 * 1, 2, 3, 4, 5 | SWAP: (3, 2)
		 * 1, 2, 3, 4, 5 | COMPARE: (2, 1)
		 * 1, 2, 3, 4, 5 | COMPARE: (1, 0)
		 */
		List<Operation> expectedOperations = new ArrayList<>();
		expectedOperations.add(new CompareOperation(1, 0));
		expectedOperations.add(new SwapOperation(1, 0));
		expectedOperations.add(new CompareOperation(2, 1));
		expectedOperations.add(new SwapOperation(2, 1));
		expectedOperations.add(new CompareOperation(1, 0));
		expectedOperations.add(new SwapOperation(1, 0));
		expectedOperations.add(new CompareOperation(3, 2));
		expectedOperations.add(new SwapOperation(3, 2));
		expectedOperations.add(new CompareOperation(2, 1));
		expectedOperations.add(new CompareOperation(1, 0));
		expectedOperations.add(new CompareOperation(4, 3));
		expectedOperations.add(new SwapOperation(4, 3));
		expectedOperations.add(new CompareOperation(3, 2));
		expectedOperations.add(new SwapOperation(3, 2));
		expectedOperations.add(new CompareOperation(2, 1));
		expectedOperations.add(new CompareOperation(1, 0));
		List<Operation> operations = sortingAlgorithm.sort(unsortedNumbers);
		assertArrayEquals(expectedOperations.toArray(), operations.toArray());
	}
}
