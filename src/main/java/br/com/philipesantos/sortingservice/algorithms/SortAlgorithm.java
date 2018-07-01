package br.com.philipesantos.sortingservice.algorithms;

import java.util.List;

import br.com.philipesantos.sortingservice.operations.Operation;

public interface SortAlgorithm {
	public List<Operation> sort(Integer[] numbers);
}
