/*
 * IT19152288
 * Bandara M.H.M.N.D.T.
 */

package com.spm.inventory.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ORDER")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(mappedBy = "order")
	Set<ItemEntity> items;
	
	@Column(name = "cname")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "total")
	private String total;
	
	@Column(name = "option")
	private String option;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<ItemEntity> getItems() {
		return items;
	}

	public void setItems(Set<ItemEntity> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	
}