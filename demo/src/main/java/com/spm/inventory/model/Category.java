package com.spm.inventory.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "category_id")
	private String categoryID;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category", cascade = { CascadeType.ALL })
	private List<Product> products;

	public Category() {
		super();
	}

	public Category(String categoryID) {
		super();
		this.categoryID = categoryID;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
