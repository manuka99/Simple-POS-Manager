package com.spm.inventory.dto;

import com.spm.inventory.model.Product;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */

public class UpdateProductDTO extends NewProductDTO {

	private String productID;

	private String imageID;

	public UpdateProductDTO() {
		super();
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getImageID() {
		return imageID;
	}

	public void setImageID(String imageID) {
		this.imageID = imageID;
	}

	public Product buildProduct() {
		Product product = super.buildProduct();
		product.setProductID(this.productID);
		if (product.getImageID() == null)
			product.setImageID(this.imageID);
		return product;
	}

}
