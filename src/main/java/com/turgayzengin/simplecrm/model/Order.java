package com.turgayzengin.simplecrm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ORDERS")
public class Order extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;

   @ManyToOne
   private Customer customer;
   
   @NotNull
   @Temporal(TemporalType.TIMESTAMP)
   private Date orderEntryDate;
   
   @OneToMany(mappedBy="order")
   private List<OrderLine> orderLines;
   
   private String status; //TODO: enum yap

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   


public Date getOrderEntryDate() {
	return orderEntryDate;
}

public void setOrderEntryDate(Date orderEntryDate) {
	this.orderEntryDate = orderEntryDate;
}

public List<OrderLine> getOrderLines() {
	return orderLines;
}

public void setOrderLines(List<OrderLine> orderLines) {
	this.orderLines = orderLines;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
  
}