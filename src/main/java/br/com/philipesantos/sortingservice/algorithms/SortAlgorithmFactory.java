package br.com.philipesantos.sortingservice.algorithms;

import org.springframework.stereotype.Component;

@Component
public class SortAlgorithmFactory {
	public SortAlgorithm create(String algorithmName) {
		switch (algorithmName.toUpperCase()) {
			case "BUBBLE_SORT": return new BubbleSortAlgorithm();
			case "INSERTION_SORT": return new InsertionSortAlgorithm();
			case "SELECTION_SORT": return new SelectionSortAlgorithm();
			default: throw new InvalidSortAlgorithmException(algorithmName);
		}
	}
}
