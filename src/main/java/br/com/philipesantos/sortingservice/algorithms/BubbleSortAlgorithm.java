package br.com.philipesantos.sortingservice.algorithms;

import java.util.ArrayList;
import java.util.List;

import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.operations.SwapOperation;

public class BubbleSortAlgorithm implements SortAlgorithm {
	@Override
	public List<Operation> sort(Integer[] numbers) {
		List<Operation> operations = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					Operation swapOperation = new SwapOperation(j, j + 1);
					swapOperation.execute(numbers);
					operations.add(swapOperation);
				}
			}
		}
		return operations;
	}
}
