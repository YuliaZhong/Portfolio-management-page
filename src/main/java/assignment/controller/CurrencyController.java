package assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assignment.entity.Cryptocurrency;
import assignment.repository.CurrencyRepository;

@RestController
@RequestMapping (path="/api")
public class CurrencyController {
	
	 @Autowired
	private CurrencyRepository currencyRepository;
	 
	 @GetMapping(path="/currency")
	    public List<Cryptocurrency> getCryptocurrency() {
	        return currencyRepository.findAll();
	    }
	 
	
}
