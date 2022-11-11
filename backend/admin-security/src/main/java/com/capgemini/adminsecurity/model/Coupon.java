package com.capgemini.adminsecurity.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Coupon 
{
	@Id
	private String couponId;
	@Field
	private String category;
	@Field
	private int count;
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

	public Coupon(String couponId, String category, int count, int price ,String offer, String companyName,String expiryDate) {
		super();
		this.couponId = couponId;
		this.category = category;
		this.count = count;
		this.offer = offer;
		this.companyName = companyName;
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
	public int getCount() {
		return count;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCount(int count) {
		this.count = count;
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
		return String.format("Coupon[coupon Id='%s', category='%s', count='%s', price='%s',offer='%s', companyName='%s',expirtDate='%s']", couponId,  category,  count,  price,offer,  companyName, expiryDate );
	}

}
