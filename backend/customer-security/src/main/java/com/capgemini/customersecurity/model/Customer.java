package com.capgemini.customersecurity.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customer")
public class Customer 
{

		@Id
		private int customerId;
		@Field
		private String customerName;
		@Field
		private String customerAddress;
		@Field
		private String customerCreditNo;
		@Field
		private String customerBankName;
		@Field
		private long customerMobile;
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Customer(int customerId, String customerName, String customerAddress, String customerCreditNo,
				String customerBankName, long customerMobile) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerAddress = customerAddress;
			this.customerCreditNo = customerCreditNo;
			this.customerBankName = customerBankName;
			this.customerMobile = customerMobile;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getCustomerAddress() {
			return customerAddress;
		}
		public void setCustomerAddress(String customerAddress) {
			this.customerAddress = customerAddress;
		}
		public String getCustomerCreditNo() {
			return customerCreditNo;
		}
		public void setCustomerCreditNo(String customerCreditNo) {
			this.customerCreditNo = customerCreditNo;
		}
		public String getCustomerBankName() {
			return customerBankName;
		}
		public void setCustomerBankName(String customerBankName) {
			this.customerBankName = customerBankName;
		}
		public long getCustomerMobile() {
			return customerMobile;
		}
		public void setCustomerMobile(long customerMobile) {
			this.customerMobile = customerMobile;
		}
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
					+ customerAddress + ", customerCreditNo=" + customerCreditNo + ", customerBankName="
					+ customerBankName + ", customerMobile=" + customerMobile + "]";
		}
		
		

}
