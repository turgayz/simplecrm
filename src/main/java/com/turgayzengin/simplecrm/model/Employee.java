package com.turgayzengin.simplecrm.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

   @ManyToOne
   private Department department;


public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}
  
}