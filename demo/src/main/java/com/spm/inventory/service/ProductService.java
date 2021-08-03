package com.spm.inventory.service;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */
import java.util.List;
import com.spm.inventory.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	boolean saveProduct(Product product);

	Product getProductById(String id);

	boolean deleteProductById(String id);

}
