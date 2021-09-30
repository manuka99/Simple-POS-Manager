package com.spm.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.spm.inventory.model.ItemEntity;
import com.spm.inventory.service.ItemService;

@Controller
@RequestMapping("/panel/orders")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@GetMapping("/")
	public String getAllItems(Model model) {
		List<ItemEntity> list = service.getAllItems();
		model.addAttribute("items", list);
		return "list-item";
	}
	
	@RequestMapping(path = {"/edit"})
	public String editItemById1(Model model, @RequestParam(value = "id", required = false) Long id) throws Exception{
		if(id != null) {
			ItemEntity entity = service.getItemById(id);
			model.addAttribute("Item", entity);
		}
		
		else {
			model.addAttribute("Item", new ItemEntity());
		}
		return "redirect:/";
	} 

	@GetMapping("/delete")
	public String deleteItemById(Model model, @RequestParam("id") Long id) throws Exception{
		service.deleteItemById(id);
		return "redirect:/";
	}
	
	@RequestMapping(path= "/createItem", method = RequestMethod.POST)
	public String createOrUpdateItem(ItemEntity item) {
		service.createOrUpdateItem(item);
		return "redirect:/";
	}
	

	@GetMapping("/deleteAll")
	public String deleteAll(){
		service.deleteAll();
		return "redirect:/";
	}
	
	
	  @GetMapping("/list-item")
	    public String listitems()
	    {
	        return "redirect:/";
	    }
	
}
