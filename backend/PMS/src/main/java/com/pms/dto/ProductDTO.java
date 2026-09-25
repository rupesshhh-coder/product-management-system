package com.pms.dto;

public class ProductDTO {

	private int id;

	private String name;

	private float cost;

	private String category;

	private int qty;

	public ProductDTO() {
	}

	public ProductDTO(int id, String name, float cost, String category, int qty) {
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
