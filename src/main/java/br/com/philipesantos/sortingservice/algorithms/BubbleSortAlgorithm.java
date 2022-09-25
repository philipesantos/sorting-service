package br.com.philipesantos.sortingservice.algorithms;

import br.com.philipesantos.sortingservice.operations.CompareOperation;
import br.com.philipesantos.sortingservice.operations.ExecutableOperation;
import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.operations.SwapOperation;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortAlgorithm implements SortAlgorithm {
	@Override
	public List<Operation> sort(Integer[] numbers) {
		List<Operation> operations = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				operations.add(new CompareOperation(j, j + 1));
				if (numbers[j] > numbers[j + 1]) {
					ExecutableOperation swapOperation = new SwapOperation(j, j + 1);
					swapOperation.execute(numbers);
					operations.add(swapOperation);
				}
			}
		}
		return operations;
	}
}
