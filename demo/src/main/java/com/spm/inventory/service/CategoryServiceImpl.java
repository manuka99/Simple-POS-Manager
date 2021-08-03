package com.spm.inventory.service;
/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spm.inventory.model.Category;
import com.spm.inventory.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public boolean saveCategory(Category category) {
		try {
//			update
			if(category.getCategoryID() != null){
				Category updatingCategory = categoryRepository.findById(category.getCategoryID()).get();
				if(updatingCategory.getCategoryID() == null)
					return false;
			}
			
//			create or save
			categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}


	@Override
	public Category getCategoryById(String id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public boolean deleteCategoryById(String id) {
		try {
			categoryRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

}
