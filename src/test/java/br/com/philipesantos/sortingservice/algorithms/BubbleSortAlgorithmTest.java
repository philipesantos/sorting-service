package br.com.philipesantos.sortingservice.algorithms;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.operations.SwapOperation;

public class BubbleSortAlgorithmTest {
	@Test
	public void doesItReturnTheNumbersInCorrectOrder() {
		Integer[] numbers = new Integer[] { 7, 3, 5, 1, 4, 2, 6, 8 };
		Integer[] expectedNumbers = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		SortAlgorithm sortingAlgorithm = new BubbleSortAlgorithm();
		sortingAlgorithm.sort(numbers);
		assertArrayEquals(expectedNumbers, numbers);
	}
	
	@Test
	public void doesItReturnTheCorrectOperations() {
		Integer[] unsortedNumbers = new Integer[] { 7, 3, 5, 1, 4, 2, 6, 8 };
		SortAlgorithm sortingAlgorithm = new BubbleSortAlgorithm();
		/*
		 * 7, 3, 5, 1, 4, 2, 6, 8 | Initial state
		 * 3, 7, 5, 1, 4, 2, 6, 8 | 0 <=> 1
		 * 3, 5, 7, 1, 4, 2, 6, 8 | 1 <=> 2
		 * 3, 5, 1, 7, 4, 2, 6, 8 | 2 <=> 3
		 * 3, 5, 1, 4, 7, 2, 6, 8 | 3 <=> 4
		 * 3, 5, 1, 4, 2, 7, 6, 8 | 4 <=> 5
		 * 3, 5, 1, 4, 2, 6, 7, 8 | 5 <=> 6
		 * 3, 1, 5, 4, 2, 6, 7, 8 | 1 <=> 2
		 * 3, 1, 4, 5, 2, 6, 7, 8 | 2 <=> 3
		 * 3, 1, 4, 2, 5, 6, 7, 8 | 3 <=> 4
		 * 1, 3, 4, 2, 5, 6, 7, 8 | 0 <=> 1
		 * 1, 3, 2, 4, 5, 6, 7, 8 | 2 <=> 3
		 * 1, 2, 3, 4, 5, 6, 7, 8 | 1 <=> 2
		 */
		List<Operation> expectedOperations = new ArrayList<>();
		expectedOperations.add(new SwapOperation(0, 1));
		expectedOperations.add(new SwapOperation(1, 2));
		expectedOperations.add(new SwapOperation(2, 3));
		expectedOperations.add(new SwapOperation(3, 4));
		expectedOperations.add(new SwapOperation(4, 5));
		expectedOperations.add(new SwapOperation(5, 6));
		expectedOperations.add(new SwapOperation(1, 2));
		expectedOperations.add(new SwapOperation(2, 3));
		expectedOperations.add(new SwapOperation(3, 4));
		expectedOperations.add(new SwapOperation(0, 1));
		expectedOperations.add(new SwapOperation(2, 3));
		expectedOperations.add(new SwapOperation(1, 2));
		List<Operation> operations = sortingAlgorithm.sort(unsortedNumbers);
		assertArrayEquals(expectedOperations.toArray(), operations.toArray());
	}
}
