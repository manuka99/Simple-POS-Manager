package com.spm.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="TBL_ITEM")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
    @Column(name = "itemName")
    private String productName;
    
    @Column(name = "qty")
    private int qty;
    
    @Column(name = "uprice")
    private float uprice;
    
    @Column(name="tot")
    private float tot;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="orderID")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private orderEntity order;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getUprice() {
		return uprice;
	}

	public void setUprice(float uprice) {
		this.uprice = uprice;
	}
 
	public void setTot(float tot) {
		this.tot = tot;
	}

	public float getTot() {
		return uprice * qty;
	}
	
    
	public orderEntity getOrder() {
		return order;
	}

	public void setOrder(orderEntity order) {
		this.order = order;
	}

}
