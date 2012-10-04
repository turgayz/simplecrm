package com.turgayzengin.simplecrm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CaseComment extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;

   @ManyToOne
   private User user;
   
   

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