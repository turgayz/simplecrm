package com.turgayzengin.simplecrm.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("CUSTOMER")
public class CustomerContact extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

   @ManyToOne
   private Customer customer;

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

  
}