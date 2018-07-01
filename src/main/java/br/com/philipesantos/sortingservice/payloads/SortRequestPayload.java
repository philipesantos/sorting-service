package br.com.philipesantos.sortingservice.payloads;

public class SortRequestPayload {

	private String algorithmName;
	private Integer[] numbers;
	
	public SortRequestPayload() {
		
	}
	
	public SortRequestPayload(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	
	public String getAlgorithmName() {
		return this.algorithmName;
	}
	
	public Integer[] getNumbers() {
		return numbers;
	}
}
