package com.spm.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.order.model.ItemEntity;
import com.spm.order.repository.itemRepository;

@Service
public class itemService {

	@Autowired
	itemRepository repository;
	
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
	}