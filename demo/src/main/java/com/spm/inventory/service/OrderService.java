package com.spm.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.inventory.model.OrderEntity;
import com.spm.inventory.repository.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	    public void createOrUpdateOrder(OrderEntity entity) {
	    	try {
	    		repository.save(entity);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		System.out.println("Service error");
	    	}
	    }
	    
	    
}

