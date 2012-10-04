package com.turgayzengin.simplecrm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class OrderLine extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;  
   
   @ManyToOne
   private Order order;
   
   @NotNull
   private Product product;
   
   @NotNull
   private Integer quantity;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

   
  
}