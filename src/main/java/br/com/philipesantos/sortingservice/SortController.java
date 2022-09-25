package br.com.philipesantos.sortingservice;

import br.com.philipesantos.sortingservice.payloads.SortRequestPayload;
import br.com.philipesantos.sortingservice.payloads.SortResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sort")
public class SortController {
	
	private SortService sortBusiness;

	@Autowired
	public SortController(SortService sortBusiness) {
		this.sortBusiness = sortBusiness;
	}
	
    @PostMapping
    public SortResponsePayload sort(@RequestBody SortRequestPayload sortPayload) {
		return sortBusiness.sort(sortPayload);
    }
}