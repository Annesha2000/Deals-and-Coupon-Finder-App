package com.capgemini.customersecurity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User 
{
		@Id
		private String user_id;
		@NotBlank
		@Size(max = 20)
		private String username;
		@Indexed(unique = true)
		@NotBlank
		@Size(max=30)
		private String email;
		@NotBlank
		@Size(max=30)
		private String password;
		private long phone;
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 30) String email,
				@NotBlank @Size(max = 30) String password,long phone) {
			super();
			
			this.username = username;
			this.email = email;
			this.password = password;
			this.phone=phone;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		@Override
		public String toString() {
			return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password=" + password
					+ ", phone=" + phone + "]";
		}
		
		
		
		

}
