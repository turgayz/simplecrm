package com.turgayzengin.simplecrm.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISC")
public abstract class Person extends BaseEntity implements Serializable {

	@Id
	   @GeneratedValue
	   private Long id;
	
	
	   @OneToOne
	   private User user;
	
   @NotNull
   @Size(min = 1, max = 25)
   private String name;
   
   @NotNull
   @Size(min = 1, max = 25)
   private String surName;
   
   @Size(max = 40)
   private String title;
   
   @Size(max = 20)
   private String phone;
   
   @Size(max = 20)
   private String mobile;
   
   @Size(max = 20)
   private String fax;
   
   @NotNull
   @Size(max = 40)
   private String eMail;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

public String getSurName() {
	return surName;
}

public void setSurName(String surName) {
	this.surName = surName;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getFax() {
	return fax;
}

public void setFax(String fax) {
	this.fax = fax;
}

public String geteMail() {
	return eMail;
}

public void seteMail(String eMail) {
	this.eMail = eMail;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
  
}