package com.spm.inventory.service;
/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */
import java.util.List;
import com.spm.inventory.model.Category;

public interface CategoryService {

	List<Category> getAllCategories();
	boolean saveCategory(Category category);
	Category getCategoryById(String id);
	boolean deleteCategoryById(String id);

}
