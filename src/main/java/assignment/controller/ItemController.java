package assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import assignment.ResourceNotFoundException;
import assignment.entity.PortfolioItem;
import assignment.repository.CurrencyRepository;
import assignment.repository.ItemRepository;
@RequestMapping (path="/api")
@RestController
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	 @GetMapping(path="/items")
	    public List<PortfolioItem> getPortfolioItem() {
	        return itemRepository.findAll();
	    }
	 
	   @PostMapping(path="/item")
   public PortfolioItem addNewItem(@Valid @RequestBody PortfolioItem item){
    
       return itemRepository.save(item);
       
       
      
   }
	   @DeleteMapping(path="/item/{itemId}")
       public ResponseEntity <?> deleteItem(@PathVariable Long itemId){
    	   return itemRepository.findById(itemId).map(item ->{
    		   itemRepository.delete(item);
    		   return ResponseEntity.ok().build();
    	   }).orElseThrow(() -> new ResourceNotFoundException("ItemId "+ itemId +" not found"));
       }



	   
	   


}
