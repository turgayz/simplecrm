package com.turgayzengin.simplecrm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;

   @NotNull
   @Size(min = 1, max = 40)
   @Column(unique=true)
   private String name;
   
   @NotNull
   private Address address;
   
   @OneToMany(mappedBy="customer")
   private List<CustomerContact> contacts;
   
   @OneToMany(mappedBy="customer")
   private List<Order> orders;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public List<Order> getOrders() {
	return orders;
}

public void setOrders(List<Order> orders) {
	this.orders = orders;
}

public List<CustomerContact> getContacts() {
	return contacts;
}

public void setContacts(List<CustomerContact> contacts) {
	this.contacts = contacts;
}
  
}