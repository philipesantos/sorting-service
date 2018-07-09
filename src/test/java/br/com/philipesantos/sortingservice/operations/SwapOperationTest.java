package br.com.philipesantos.sortingservice.operations;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SwapOperationTest {
	@Test
	public void doesItSuccessfullySwapAdjacentNumbersInTheBeginning() {
		Integer[] numbers = new Integer[] { 3, 1, 5, 7 };
		Integer[] expectedNumbers = new Integer[] { 1, 3, 5, 7 };
		ExecutableOperation swapOperation = new SwapOperation(0, 1);
		swapOperation.execute(numbers);
		assertArrayEquals(expectedNumbers, numbers);
	}
	
	@Test
	public void doesItSuccessfullySwapAdjacentNumbersInTheMiddle() {
		Integer[] numbers = new Integer[] { 1, 5, 3, 7 };
		Integer[] expectedNumbers = new Integer[] { 1, 3, 5, 7 };
		ExecutableOperation swapOperation = new SwapOperation( 1, 2);
		swapOperation.execute(numbers);
		assertArrayEquals(expectedNumbers, numbers);
	}
	
	@Test
	public void doesItSuccessfullySwapAdjacentNumbersInTheEnding() {
		Integer[] numbers = new Integer[] { 1, 3, 7, 5 };
		Integer[] expectedNumbers = new Integer[] { 1, 3, 5, 7 };
		ExecutableOperation swapOperation = new SwapOperation(2, 3);
		swapOperation.execute(numbers);
		assertArrayEquals(expectedNumbers, numbers);
	}
	
	@Test
	public void doesItSuccessfullySwapFirstAndLastNumber() {
		Integer[] numbers = new Integer[] { 7, 3, 5, 1 };
		Integer[] expectedNumbers = new Integer[] { 1, 3, 5, 7 };
		ExecutableOperation swapOperation = new SwapOperation(0, 3);
		swapOperation.execute(numbers);
		assertArrayEquals(expectedNumbers, numbers);
	}
}
