package com.spm.order.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spm.order.model.Items;
import com.spm.order.repository.itemRepository;

public class itemService {

	@Autowired
	private itemRepository repository;
	
	public void addItem(Items item) {
		try {
    		repository.save(item);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
		

}
