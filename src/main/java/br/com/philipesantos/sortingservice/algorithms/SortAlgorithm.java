package br.com.philipesantos.sortingservice.algorithms;

import br.com.philipesantos.sortingservice.operations.Operation;

import java.util.List;

public interface SortAlgorithm {
	public List<Operation> sort(Integer[] numbers);
}
