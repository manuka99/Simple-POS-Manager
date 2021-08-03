package com.spm.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

@Controller
@RequestMapping("/panel")
public class PanelController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
}
