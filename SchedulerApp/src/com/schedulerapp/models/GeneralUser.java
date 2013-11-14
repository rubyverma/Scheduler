package com.schedulerapp.models;

import java.sql.Date;

public class GeneralUser {
        
        private int userId;
        private int clientId;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private Date dob;
        private String address;
        private String gender;
        private String tocken;
        private int emailVerified;
        private String gcmRegId;
        
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getClientId() {
			return clientId;
		}
		public void setClientId(int clientId) {
			this.clientId = clientId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getTocken() {
			return tocken;
		}
		public void setTocken(String tocken) {
			this.tocken = tocken;
		}
		public int getEmailVerified() {
			return emailVerified;
		}
		public void setEmailVerified(int emailVerified) {
			this.emailVerified = emailVerified;
		}
		public String getGcmRegId() {
			return gcmRegId;
		}
		public void setGcmRegId(String gcmRegId) {
			this.gcmRegId = gcmRegId;
		}
        
        
        
}
