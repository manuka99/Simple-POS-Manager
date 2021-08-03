package com.spm.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spm.inventory.model.Category;
import com.spm.inventory.model.ResponseData;
import com.spm.inventory.service.CategoryService;


/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

@Controller
@RequestMapping("/panel/categories")
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String listCategory(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "category/list";
	}

	@GetMapping("/{categoryID}")
	public String findCategory(@PathVariable(value = "categoryID", required = true) String categoryID, Model model) {
		model.addAttribute("category", categoryService.getCategoryById(categoryID));
		return "category/list";
	}

	@PostMapping
	@ResponseBody
	public ResponseData createCategory(@RequestBody Category category, ResponseData responseData) {
		category.setCategoryID(null);
		boolean result = categoryService.saveCategory(category);
		responseData.setSuccess(result);
		return responseData;
	}

	@PatchMapping
	@ResponseBody
	public ResponseData updateCategory(@RequestBody Category category, ResponseData responseData) {
		if(category.getCategoryID() == null)
			return responseData;				
		
		boolean result = categoryService.saveCategory(category);
		responseData.setSuccess(result);
		return responseData;
	}

	@DeleteMapping
	public String deleteCategory(HttpServletRequest request, Model model) {
		String[] cids = {};

		if (request.getParameter("cids[]") != null) {
			cids = request.getParameterValues("cids[]");
		}

		List<String> notDeleted = new ArrayList<>();
		List<String> deletedProducts = new ArrayList<>();

		for (String cid : cids) {

			if (categoryService.deleteCategoryById(cid))
				deletedProducts.add(cid);

			else
				notDeleted.add(cid);

		}

		if (deletedProducts.size() != cids.length)
			model.addAttribute("deleteError", true);
		else
			model.addAttribute("deleteSuccess", true);

		model.addAttribute("countDeleted", deletedProducts.size());
		model.addAttribute("countSend", cids.length);
		model.addAttribute("notDeleted", notDeleted);
		model.addAttribute("deletedProducts", deletedProducts);
		model.addAttribute("displayMessage", true);

		return "category/list";
	}

}
