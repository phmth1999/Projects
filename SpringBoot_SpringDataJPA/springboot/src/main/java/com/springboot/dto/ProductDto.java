package com.springboot.dto;

public class ProductDto extends BaseDto{
	private String id_productdetail;
	private String img;
	private String name;
	private double price;
	private int quantity;

	public String getId_productdetail() {
		return id_productdetail;
	}

	public void setId_productdetail(String id_productdetail) {
		this.id_productdetail = id_productdetail;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
