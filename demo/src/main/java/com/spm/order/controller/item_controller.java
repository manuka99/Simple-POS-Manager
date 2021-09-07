package com.spm.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spm.order.model.Items;
import com.spm.order.service.itemService;

@Controller
@RequestMapping("/purchaseOrder")
public class item_Controller {
	
	@Autowired
	private itemService itemService;
	
	@RequestMapping(path= "/createItem", method = RequestMethod.POST)
	public String addItem(@ModelAttribute Items item) {
		itemService.addItem(item);
		return "redirect:/";
	}
	

	@GetMapping("/purchaseOrder")
	public String purchaseOrder() {
		return "add-order";
	}
	

}
