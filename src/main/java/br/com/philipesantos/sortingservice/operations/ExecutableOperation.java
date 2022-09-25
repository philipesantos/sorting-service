package br.com.philipesantos.sortingservice.operations;

public interface ExecutableOperation extends Operation {
	void execute(Integer[] numbers);
}
