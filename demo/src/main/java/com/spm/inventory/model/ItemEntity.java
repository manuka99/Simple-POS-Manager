/*
 * IT19152288
 * Bandara M.H.M.N.D.T.
 */

package com.spm.inventory.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	public long getId() {
		return id;
	}
	
	@ManyToMany
	@JoinTable(
			name="item_order",
			joinColumns = @JoinColumn(name="itemid"),
			inverseJoinColumns = @JoinColumn(name="OrderId"))
	Set<OrderEntity> order;
	
	public Set<OrderEntity> getOrder() {
		return order;
	}

	public void setOrder(Set<OrderEntity> order) {
		this.order = order;
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
	

}
