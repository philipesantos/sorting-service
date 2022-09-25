package br.com.philipesantos.sortingservice.algorithms;

import org.springframework.stereotype.Component;

@Component
public class SortAlgorithmFactory {
	public SortAlgorithm create(String algorithmName) {
		return switch (algorithmName.toUpperCase()) {
			case "BUBBLE_SORT" -> new BubbleSortAlgorithm();
			case "INSERTION_SORT" -> new InsertionSortAlgorithm();
			case "SELECTION_SORT" -> new SelectionSortAlgorithm();
			default -> throw new InvalidSortAlgorithmException(algorithmName);
		};
	}
}
