package com.spm.inventory.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String productID;

	@Column(name = "name")
	private String name;

	@Lob
	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;

	@Column(name = "tax")
	private double tax;

	@Column(name = "portion")
	private String portion;

	@Column(name = "active")
	private boolean active;

	@Column(name = "trashed")
	private boolean trashed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@Transient
	private String imageUrl;

	private String imageID;

	private boolean manageStock;

	private int initialStockCount;

	private int remainingStockCount;

	private int lowStockThreshold;

	private Date productDate;

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImageUrl() {
		return "/uploads/public/products/" + imageID;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getImageID() {
		return imageID;
	}

	public void setImageID(String imageID) {
		this.imageID = imageID;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

}
