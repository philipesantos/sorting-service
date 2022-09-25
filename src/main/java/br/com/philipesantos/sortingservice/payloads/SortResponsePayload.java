package br.com.philipesantos.sortingservice.payloads;

import br.com.philipesantos.sortingservice.operations.Operation;

import java.util.List;

public class SortResponsePayload {
	
	private Integer[] numbers;
	private Integer[] sortedNumbers;
	private List<Operation> operations;
	
	public SortResponsePayload(Integer[] numbers, Integer[] sortedNumbers, List<Operation> operations) {
		this.numbers = numbers;
		this.sortedNumbers = sortedNumbers;
		this.operations = operations;
	}

	public Integer[] getNumbers() {
		return this.numbers;
	}
	
	public Integer[] getSortedNumbers() {
		return this.sortedNumbers;
	}
	
	public List<Operation> getOperations() {
		return this.operations;
	}
}
