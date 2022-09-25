package br.com.philipesantos.sortingservice.algorithms;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortAlgorithmFactory {

	private final List<SortAlgorithm> sortAlgorithms;

	public SortAlgorithmFactory(List<SortAlgorithm> sortAlgorithms) {
		this.sortAlgorithms = sortAlgorithms;
	}

	public SortAlgorithm create(String algorithmName) {
		for (SortAlgorithm sortAlgorithm : this.sortAlgorithms) {
			if (sortAlgorithm.isNamed(algorithmName)) {
				return sortAlgorithm;
			}
		}
		throw new InvalidSortAlgorithmException(algorithmName);
	}
}
