package com.capgemini.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cart")
public class CartDeal 
{
	@Id
	private String dealId;
	@Field
	private String name;
	
	@Field
	private int price;
	
	@Field
	private String companyName;
	
	@Field
	private String imgUrl;
	
	@Field
	private int quantity;

	public CartDeal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDeal(String dealId, String name, int price, String companyName, String imgUrl, int quantity) {
		super();
		this.dealId = dealId;
		this.name = name;
		this.price = price;
		this.companyName = companyName;
		this.imgUrl = imgUrl;
		this.quantity = quantity;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartDeal [dealId=" + dealId + ", name=" + name + ", price=" + price + ", companyName=" + companyName
				+ ", imgUrl=" + imgUrl + ", quantity=" + quantity + "]";
	}

	
	
	

}
