package br.com.philipesantos.sortingservice.operations;

public interface Operation {
	public String getType();
	public void execute(Integer[] numbers);
}
