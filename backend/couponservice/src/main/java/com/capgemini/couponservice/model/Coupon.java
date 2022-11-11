package com.capgemini.couponservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "coupons")
public class Coupon 
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
	
	
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coupon(String couponId, String category,  int price ,String offer, String companyName,String expiryDate) {
		super();
		this.couponId = couponId;
		this.category = category;
		
		this.offer = offer;
		this.companyName = companyName;
		this.price=price;
		this.expiryDate = expiryDate;
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

	@Override
	public String toString() {
		return String.format("Coupon[coupon Id='%s', category='%s',  price='%s',offer='%s', companyName='%s',expirtDate='%s']", couponId,  category,  price,offer,  companyName, expiryDate );
	}
	

}
