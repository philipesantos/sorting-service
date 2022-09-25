package br.com.philipesantos.sortingservice.algorithms;

import br.com.philipesantos.sortingservice.operations.CompareOperation;
import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.operations.SwapOperation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortAlgorithmTest {
	@Test
	public void doesItReturnTheNumbersInCorrectOrder() {
		Integer[] numbers = new Integer[] { 5, 2, 1, 4, 3 };
		Integer[] expectedNumbers = new Integer[] { 1, 2, 3, 4, 5 };
		SortAlgorithm sortingAlgorithm = new SelectionSortAlgorithm();
		sortingAlgorithm.sort(numbers);
		assertArrayEquals(expectedNumbers, numbers);
	}
	
	@Test
	public void doesItReturnTheCorrectOperations() {
		Integer[] unsortedNumbers = new Integer[] { 5, 2, 1, 4, 3 };
		SortAlgorithm sortingAlgorithm = new SelectionSortAlgorithm();
		/*
		 * 5, 2, 1, 4, 3 | Initial state
		 * 5, 2, 1, 4, 3 | COMPARE: (1, 0)
		 * 5, 2, 1, 4, 3 | COMPARE: (2, 1)
		 * 5, 2, 1, 4, 3 | COMPARE: (3, 2)
		 * 5, 2, 1, 4, 3 | COMPARE: (4, 2)
		 * 1, 2, 5, 4, 3 | SWAP: (0, 2)
		 * 1, 2, 5, 4, 3 | COMPARE: (2, 1)
		 * 1, 2, 5, 4, 3 | COMPARE: (3, 1)
		 * 1, 2, 5, 4, 3 | COMPARE: (4, 1)
		 * 1, 2, 5, 4, 3 | COMPARE: (3, 2)
		 * 1, 2, 5, 4, 3 | COMPARE: (4, 3)
		 * 1, 2, 3, 4, 5 | SWAP: (4, 2)
		 * 1, 2, 3, 4, 5 | COMPARE: (3, 4)
		 */		
		List<Operation> expectedOperations = new ArrayList<>();
		expectedOperations.add(new CompareOperation(1, 0));
		expectedOperations.add(new CompareOperation(2, 1));
		expectedOperations.add(new CompareOperation(3, 2));
		expectedOperations.add(new CompareOperation(4, 2));
		expectedOperations.add(new SwapOperation(0, 2));
		expectedOperations.add(new CompareOperation(2, 1));
		expectedOperations.add(new CompareOperation(3, 1));
		expectedOperations.add(new CompareOperation(4, 1));
		expectedOperations.add(new CompareOperation(3, 2));
		expectedOperations.add(new CompareOperation(4, 3));
		expectedOperations.add(new SwapOperation(4, 2));
		expectedOperations.add(new CompareOperation(3, 4));
		List<Operation> operations = sortingAlgorithm.sort(unsortedNumbers);
		assertArrayEquals(expectedOperations.toArray(), operations.toArray());
	}
}
