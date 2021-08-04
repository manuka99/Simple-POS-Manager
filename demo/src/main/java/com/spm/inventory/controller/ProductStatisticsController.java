package com.spm.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spm.inventory.service.ProductService;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

@Controller
@RequestMapping("/panel/product-statistics")
public class ProductStatisticsController {
	
	@Autowired
	ProductService productService;

	@GetMapping
	public String index() {
		return "product/statistics";
	}
	
	@ResponseBody
	@GetMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object productStockStatistics() {
		return productService.getProductsBasedOnMonths(2021);
	}
	
	
	public String getNumberOfProductsBasedOnMonths() {
		return "";
	}

}
