package com.spm.inventory.dto;

import java.io.IOException;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import com.spm.inventory.model.Category;
import com.spm.inventory.model.Product;
import com.spm.inventory.util.FileUploadUtil;


/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

public class NewProductDTO {

	private String name;

	private String description;

	private double price;

	private double tax;

	private String portion;

	private boolean active;

	private boolean trashed;

	private boolean manageStock;

	private int initialStockCount;

	private int remainingStockCount;

	private int lowStockThreshold;

	private String categoryID;

	private MultipartFile image;

	public NewProductDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getPortion() {
		return portion;
	}

	public void setPortion(String portion) {
		this.portion = portion;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isTrashed() {
		return trashed;
	}

	public void setTrashed(boolean trashed) {
		this.trashed = trashed;
	}

	public boolean isManageStock() {
		return manageStock;
	}

	public void setManageStock(boolean manageStock) {
		this.manageStock = manageStock;
	}

	public int getInitialStockCount() {
		return initialStockCount;
	}

	public void setInitialStockCount(int initialStockCount) {
		this.initialStockCount = initialStockCount;
	}

	public int getRemainingStockCount() {
		return remainingStockCount;
	}

	public void setRemainingStockCount(int remainingStockCount) {
		this.remainingStockCount = remainingStockCount;
	}

	public int getLowStockThreshold() {
		return lowStockThreshold;
	}

	public void setLowStockThreshold(int lowStockThreshold) {
		this.lowStockThreshold = lowStockThreshold;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Product buildProduct() {
		Product product = new Product();
		product.setName(this.name);
		product.setDescription(this.description);
		product.setPrice(this.price);
		product.setTax(this.tax);
		product.setPortion(this.portion);
		product.setActive(this.active);
		product.setTrashed(this.trashed);
		product.setManageStock(this.manageStock);
		product.setInitialStockCount(this.initialStockCount);
		product.setRemainingStockCount(this.remainingStockCount);
		product.setLowStockThreshold(this.lowStockThreshold);
		product.setCategory(new Category(this.categoryID));
		
		if(this.image != null) {
	        try {
	        	String filename = this.image.getOriginalFilename();
	        	String extension = filename.substring(filename.lastIndexOf("."));
	        	String newName = UUID.randomUUID().toString().replaceAll("-", "").concat(extension);
				FileUploadUtil.saveFile("uploads/public/products", newName, this.image);
				product.setImageID(newName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return product;
	}

}
