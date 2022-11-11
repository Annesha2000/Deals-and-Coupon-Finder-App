package com.capgemini.dealservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "deals")
public class Deal
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
	

	public Deal(String dealId, String name, int price, String companyName, String imgUrl) {
		super();
		this.dealId = dealId;
		this.name = name;
		this.price = price;
		this.companyName = companyName;
		this.imgUrl = imgUrl;
	}

	public Deal() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return String.format("Deal[deal Id='%s', name='%s' , price='%s', companyName='%s' ,  imgUrl='%s' ]", dealId,  name,   price,  companyName , imgUrl );
	}

}
