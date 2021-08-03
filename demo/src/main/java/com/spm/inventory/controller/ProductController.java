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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.spm.inventory.dto.NewProductDTO;
import com.spm.inventory.dto.UpdateProductDTO;
import com.spm.inventory.model.Product;
import com.spm.inventory.model.ResponseData;
import com.spm.inventory.service.CategoryService;
import com.spm.inventory.service.ProductService;


/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

@Controller
@RequestMapping("/panel/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "product/list";
	}

	@GetMapping("/{productID}")
	public String findProduct(@PathVariable(value = "productID", required = true) String productID, Model model) {
		model.addAttribute("product", productService.getProductById(productID));
		model.addAttribute("categories", categoryService.getAllCategories());
		return "product/product";
	}

	@PostMapping
	@ResponseBody
	public ResponseData createProduct(NewProductDTO newProductDTO, ResponseData responseData)
			throws JsonMappingException, JsonProcessingException {
//		Product product = new ObjectMapper().readValue(productString, Product.class);

		Product product = newProductDTO.buildProduct();
		boolean result = productService.saveProduct(product);
		responseData.setSuccess(result);
		return responseData;
	}

	@PatchMapping
	@ResponseBody
	public ResponseData updateProduct(UpdateProductDTO updateProductDTO, ResponseData responseData) {
		if (updateProductDTO.getProductID() == null)
			return responseData;

		Product product = updateProductDTO.buildProduct();
		boolean result = productService.saveProduct(product);
		responseData.setSuccess(result);
		return responseData;
	}

	@DeleteMapping
	public String deleteProduct(HttpServletRequest request, Model model) {
		String[] cids = {};

		if (request.getParameter("pids[]") != null) {
			cids = request.getParameterValues("pids[]");
		}

		List<String> notDeleted = new ArrayList<>();
		List<String> deletedProducts = new ArrayList<>();

		for (String cid : cids) {

			if (productService.deleteProductById(cid))
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

		return "product/list";
	}

}
