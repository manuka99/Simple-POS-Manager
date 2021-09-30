package com.spm.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spm.order.model.ItemEntity;
import com.spm.order.service.ItemService;

@Controller
@RequestMapping("/panel/orders")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/createitem")
	public String addItem(ItemEntity item) {
		itemService.createOrUpdateItem(item);
		return "redirect:/";
	}
	

	@GetMapping("/purchase")
	public String purchaseOrder() {
		System.out.println("purchaseorder");
		return "order/add-order";
	}
	

}
