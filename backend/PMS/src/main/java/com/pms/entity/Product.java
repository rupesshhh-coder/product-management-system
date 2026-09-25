package com.pms.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;

	@Column(name = "product_name", nullable = false, unique = true)
	private String name;

	@Column(name = "product_cost")
	private float cost;

	@Column(name = "Category")
	private String category;

	@Column(name = "product_quantity")
	private int qty;

	public Product() {

	}

	public Product(int id, String name, float cost, String category, int qty) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.category = category;
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
