package br.com.philipesantos.sortingservice.algorithms;

import br.com.philipesantos.sortingservice.operations.CompareOperation;
import br.com.philipesantos.sortingservice.operations.ExecutableOperation;
import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.operations.SwapOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InsertionSortAlgorithm implements SortAlgorithm {
	@Override
	public boolean isNamed(String algorithmName) {
		return "INSERTION_SORT".equalsIgnoreCase(algorithmName);
	}

	@Override
	public List<Operation> sort(Integer[] numbers) {
		List<Operation> operations = new ArrayList<>();
		for (int i = 1; i < numbers.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				operations.add(new CompareOperation(j, j + 1));
				if (numbers[j] > numbers[j + 1]) {
					ExecutableOperation swapOperation = new SwapOperation(j + 1, j);
					swapOperation.execute(numbers);
					operations.add(swapOperation);
				}
			}
		}
		return operations;
	}
}
