package br.com.philipesantos.sortingservice.algorithms;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidSortAlgorithmException extends RuntimeException {
	public InvalidSortAlgorithmException(String algorithmName) {
		super("Invalid algorithm: '" + algorithmName + "'");
	}
}
