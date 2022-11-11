package com.capgemini.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "cart")
public class CartCoupon 
{
	@Id
	private String couponId;
	@Field
	private String category;
	
	@Field
	private int price;
	@Field
	private String offer;
	@Field
	private String companyName;
	@Field
	private String expiryDate;
	
	@Field
	private int quantity;
	
	public CartCoupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CartCoupon(String couponId, String category, int price, String offer, String companyName, String expiryDate,
			int quantity) {
		super();
		this.couponId = couponId;
		this.category = category;
		this.price = price;
		this.offer = offer;
		this.companyName = companyName;
		this.expiryDate = expiryDate;
		this.quantity = quantity;
	}


	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "CartCoupon [couponId=" + couponId + ", category=" + category + ", price=" + price + ", offer=" + offer
				+ ", companyName=" + companyName + ", expiryDate=" + expiryDate + ", quantity=" + quantity + "]";
	}

	
	

}
