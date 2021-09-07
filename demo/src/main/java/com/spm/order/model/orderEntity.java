package com.spm.order.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class orderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "datePurchase")
	private String date;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "nettot")
	private float nettot;
	
	@Column(name = "discount")
	private int discount;
	
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<ItemEntity> items = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getNettot() {
		return nettot;
	}

	public void setNettot(float nettot) {
		this.nettot = nettot;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
		
		for(ItemEntity i: items) {
			i.setOrder(this);
		}
	}

}
