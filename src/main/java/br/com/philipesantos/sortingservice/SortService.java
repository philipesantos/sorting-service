package br.com.philipesantos.sortingservice;

import br.com.philipesantos.sortingservice.algorithms.SortAlgorithm;
import br.com.philipesantos.sortingservice.algorithms.SortAlgorithmFactory;
import br.com.philipesantos.sortingservice.operations.Operation;
import br.com.philipesantos.sortingservice.payloads.SortRequestPayload;
import br.com.philipesantos.sortingservice.payloads.SortResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {

	private SortAlgorithmFactory sortAlgorithmFactory;

	@Autowired
	public SortService(SortAlgorithmFactory sortAlgorithmFactory) {
		this.sortAlgorithmFactory = sortAlgorithmFactory;
	}
	
	public SortResponsePayload sort(SortRequestPayload sortPayload) {
		Integer[] numbers = sortPayload.getNumbers().clone();
		SortAlgorithm sortAlgorithm = this.sortAlgorithmFactory.create(sortPayload.getAlgorithmName());
		List<Operation> operations = sortAlgorithm.sort(numbers);
    	return new SortResponsePayload(sortPayload.getNumbers(), numbers, operations);
	}
}
