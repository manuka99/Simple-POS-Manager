package com.spm.inventory.service;

import java.util.List;
import com.spm.inventory.model.Product;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

public interface ProductService {

	List<Product> getAllProducts();

	boolean saveProduct(Product product);

	Product getProductById(String id);

	boolean deleteProductById(String id);
	
	List<Object> getProductsBasedOnMonths(int year);

	List<Object> getTotalAndValueStockForYear(int year);
	
	List<Object> getStockDifferenceBasedOnMonthsForYear(int year);
	
//	---------------
	
	List<Object> getInitialAndRemainingStockForYear(int year);
	
	List<Object> getStockDifferentPercentageBasedOnMonthsForYear(int year);
	
//	-----------
	
	List<Object> getStockForYear(int year);
	
	List<Object> getStockBasedOnMonthsForYear(int year);
}
