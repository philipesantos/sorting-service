package br.com.philipesantos.sortingservice.algorithms;

import br.com.philipesantos.sortingservice.operations.CompareOperation;
import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.operations.SwapOperation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortAlgorithmTest {
	@Test
	public void doesItReturnTheNumbersInCorrectOrder() {
		Integer[] numbers = new Integer[] { 5, 2, 1, 4, 3 };
		Integer[] expectedNumbers = new Integer[] { 1, 2, 3, 4, 5 };
		SortAlgorithm sortingAlgorithm = new BubbleSortAlgorithm();
		sortingAlgorithm.sort(numbers);
		assertArrayEquals(expectedNumbers, numbers);
	}
	
	@Test
	public void doesItReturnTheCorrectOperations() {
		Integer[] unsortedNumbers = new Integer[] { 5, 2, 1, 4, 3 };
		SortAlgorithm sortingAlgorithm = new BubbleSortAlgorithm();
		/*
		 * 5, 2, 1, 4, 3 | Initial state
		 * 5, 2, 1, 4, 3 | COMPARE: (0, 1)
		 * 2, 5, 1, 4, 3 | SWAP: (0, 1)
		 * 2, 5, 1, 4, 3 | COMPARE: (1, 2)
		 * 2, 1, 5, 4, 3 | SWAP: (1, 2)
		 * 2, 1, 5, 4, 3 | COMPARE: (2, 3)
		 * 2, 1, 4, 5, 3 | SWAP: (2, 3)
		 * 2, 1, 4, 5, 3 | COMPARE: (3, 4)
		 * 2, 1, 4, 3, 5 | SWAP: (3, 4)
		 * 2, 1, 4, 3, 5 | COMPARE: (0, 1)
		 * 1, 2, 4, 3, 5 | SWAP: (0, 1)
		 * 1, 2, 4, 3, 5 | COMPARE: (1, 2)
		 * 1, 2, 4, 3, 5 | COMPARE: (2, 3)
		 * 1, 2, 3, 4, 5 | SWAP: (2, 3)
		 * 1, 2, 3, 4, 5 | COMPARE: (0, 1)
		 * 1, 2, 3, 4, 5 | COMPARE: (1, 2)
		 * 1, 2, 3, 4, 5 | COMPARE: (0, 1)
		 */
		List<Operation> expectedOperations = new ArrayList<>();
		expectedOperations.add(new CompareOperation(0, 1));
		expectedOperations.add(new SwapOperation(0, 1));
		expectedOperations.add(new CompareOperation(1, 2));
		expectedOperations.add(new SwapOperation(1, 2));
		expectedOperations.add(new CompareOperation(2, 3));
		expectedOperations.add(new SwapOperation(2, 3));
		expectedOperations.add(new CompareOperation(3, 4));
		expectedOperations.add(new SwapOperation(3, 4));
		expectedOperations.add(new CompareOperation(0, 1));
		expectedOperations.add(new SwapOperation(0, 1));
		expectedOperations.add(new CompareOperation(1, 2));
		expectedOperations.add(new CompareOperation(2, 3));
		expectedOperations.add(new SwapOperation(2, 3));
		expectedOperations.add(new CompareOperation(0, 1));
		expectedOperations.add(new CompareOperation(1, 2));
		expectedOperations.add(new CompareOperation(0, 1));
		List<Operation> operations = sortingAlgorithm.sort(unsortedNumbers);
		assertArrayEquals(expectedOperations.toArray(), operations.toArray());
	}
}
