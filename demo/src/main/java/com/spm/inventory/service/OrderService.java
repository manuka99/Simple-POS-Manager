/*
 * IT19152288
 * Bandara M.H.M.N.D.T.
 */

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
	
		public List<OrderEntity> getAllOrders(){
			List<OrderEntity> result = (List<OrderEntity>)repository.findAll();
			if(result.size() > 0) {
				return result;
			}
			else {
				return null;
			}
		}
		
	
	    public void createOrUpdateOrder(OrderEntity entity) {
	    	try {
	    		repository.save(entity);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		System.out.println("Service error");
	    	}
	    }
	    

		
		    public void deleteAll() {
		    	try {
		    		repository.deleteAll();
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    }
		     
}


