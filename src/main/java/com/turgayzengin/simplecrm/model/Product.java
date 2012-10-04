package com.turgayzengin.simplecrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;

   @NotNull
   @Size(min = 1, max = 20)
   @Column(unique=true)
   private String code;
   
   @NotNull
   @Size(min = 1, max = 50)
   @Column(unique=true)
   private String name;
   
   @NotNull
   private Integer stockAmount;
   
   @NotNull
   private Double price;

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

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public Integer getStockAmount() {
	return stockAmount;
}

public void setStockAmount(Integer stockAmount) {
	this.stockAmount = stockAmount;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}
  
}