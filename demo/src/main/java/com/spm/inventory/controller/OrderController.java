package com.spm.inventory.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spm.inventory.model.OrderEntity;
import com.spm.inventory.service.OrderService;


@Controller
public class OrderController {
	

	@Autowired
	OrderService oservice;
	
	@RequestMapping(path= "/createOrder", method = RequestMethod.POST)
	public String createOrUpdateOrder(OrderEntity order) {
		oservice.createOrUpdateOrder(order);
		return "redirect:/";
	}
	


}
