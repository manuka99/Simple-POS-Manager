package com.spm.inventory.controller;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spm.inventory.service.ProductService;
import com.google.gson.Gson;

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
	@GetMapping(value = "/stocks-a", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getStockDifferenceBasedOnMonthsForYear(HttpServletRequest request, HttpServletResponse response) {
		// stock difference for each month
		int yearNow = Year.now().getValue();
		try {
			if (request.getParameter("year").equals("") == false)
				yearNow = Integer.parseInt(request.getParameter("year"));

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		List<Object> totalAndValue = productService.getTotalAndValueStockForYear(yearNow);
		List<Object> stockDifference = productService.getStockDifferenceBasedOnMonthsForYear(yearNow);
		
		String json1 = new Gson().toJson(totalAndValue);
		String json2 = new Gson().toJson(stockDifference);
		
		String bothJson = "[" + json1 + "," + json2 + " ]";
		// array of 2 elements

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		return bothJson;
	}
	
	@ResponseBody
	@GetMapping(value = "/stocks-b", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getStockDifferentPercentageBasedOnMonthsForYear(HttpServletRequest request, HttpServletResponse response) {
		// stock difference for each month
		int yearNow = Year.now().getValue();
		try {
			if (request.getParameter("year").equals("") == false)
				yearNow = Integer.parseInt(request.getParameter("year"));

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		List<Object> initialAndRemaining = productService.getInitialAndRemainingStockForYear(yearNow);
		List<Object> stockDifferencePercentage = productService.getStockDifferentPercentageBasedOnMonthsForYear(yearNow);
		
		String json1 = new Gson().toJson(initialAndRemaining);
		String json2 = new Gson().toJson(stockDifferencePercentage);
		
		String bothJson = "[" + json1 + "," + json2 + " ]";
		// array of 2 elements

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		return bothJson;
	}
	
	@ResponseBody
	@GetMapping(value = "/stocks-c", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getStockBasedOnMonthsForYear(HttpServletRequest request, HttpServletResponse response) {
		// stock difference for each month
		int yearNow = Year.now().getValue();
		try {
			if (request.getParameter("year").equals("") == false)
				yearNow = Integer.parseInt(request.getParameter("year"));

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		List<Object> totalValuesCountAndRemainingStocks = productService.getStockForYear(yearNow);
		List<Object> Stock = productService.getStockBasedOnMonthsForYear(yearNow);
		
		String json1 = new Gson().toJson(totalValuesCountAndRemainingStocks);
		String json2 = new Gson().toJson(Stock);
		
		String bothJson = "[" + json1 + "," + json2 + " ]";
		// array of 2 elements

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		return bothJson;
	}

}
