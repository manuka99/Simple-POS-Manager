package com.spm.inventory.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spm.inventory.model.Product;
import com.spm.inventory.repository.ProductRepository;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

@Service
public class ProductServiceImpl implements ProductService {

	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public boolean saveProduct(Product product) {
		try {
//			update
			if (product.getProductID() != null) {
				Product updatingProduct = productRepository.findById(product.getProductID()).get();
				if (updatingProduct.getProductID() == null)
					return false;
			}

//			create or save
			productRepository.save(product);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	@Override
	public Product getProductById(String id) {
		return productRepository.findById(id).get();
	}

	@Override
	public boolean deleteProductById(String id) {
		try {
			productRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	@Override
	public List<Object> getProductsBasedOnMonths(int year) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		Date start = cal.getTime();


		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 11); // 11 = december
		cal.set(Calendar.DAY_OF_MONTH, 31); // new years eve
		Date end = cal.getTime();

		return productRepository.getProductsBasedOnMonthsForYear(year);
	}

}
