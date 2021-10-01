/*
 * IT19152288
 * Bandara M.H.M.N.D.T.
 */

package com.spm.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.inventory.model.ItemEntity;
import com.spm.inventory.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository repository;
	
	public List<ItemEntity> getAllItems(){
		List<ItemEntity> result = (List<ItemEntity>)repository.findAll();
		if(result.size() > 0) {
			return result;
		}
		else {
			return null;
		}
	}
	
	   public ItemEntity getItemById(Long id) {
	    	try {
	    		return repository.findById(id).get();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
			return new ItemEntity();
	    }
	     
	    public void createOrUpdateItem(ItemEntity entity) {
	    	try {
	    		repository.save(entity);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	     
	    public void deleteItemById(Long id) {
	    	try {
	    		repository.deleteById(id);
	    	}catch(Exception e) {
	    		e.printStackTrace();
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