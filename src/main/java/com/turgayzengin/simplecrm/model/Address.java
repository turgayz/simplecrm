package com.turgayzengin.simplecrm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;

   @NotNull
   @Size(min = 1, max = 50)
   private String address1;
   
   @Size(max = 50)
   private String address2;
   
   @Size(max = 10)
   private String zipCode;
   
   @Size(max = 20)
   private String city;
   
   @Size(max = 20)
   private String state;
   
   @Size(max = 20)
   private String country;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

public String getAddress1() {
	return address1;
}

public void setAddress1(String address1) {
	this.address1 = address1;
}

public String getAddress2() {
	return address2;
}

public void setAddress2(String address2) {
	this.address2 = address2;
}

public String getZipCode() {
	return zipCode;
}

public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}
  
}