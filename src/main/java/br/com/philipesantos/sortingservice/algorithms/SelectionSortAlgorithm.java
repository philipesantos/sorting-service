package br.com.philipesantos.sortingservice.algorithms;

import br.com.philipesantos.sortingservice.operations.CompareOperation;
import br.com.philipesantos.sortingservice.operations.ExecutableOperation;
import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.operations.SwapOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SelectionSortAlgorithm implements SortAlgorithm {
	@Override
	public boolean isNamed(String algorithmName) {
		return "SELECTION_SORT".equalsIgnoreCase(algorithmName);
	}

	@Override
	public List<Operation> sort(Integer[] numbers) {
		List<Operation> operations = new ArrayList<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < numbers.length; j++) {
				operations.add(new CompareOperation(j, minIndex));
				if (numbers[j] < numbers[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				ExecutableOperation swapOperation = new SwapOperation(i, minIndex);
				swapOperation.execute(numbers);
				operations.add(swapOperation);
			}
		}
		return operations;
	}
}
