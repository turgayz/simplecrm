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

@Entity
@Table(name="CASES")
public class Case extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;

   @ManyToOne
   private Employee assignedEmployee;
   
   @ManyToOne
   private Customer customer;
   
   @OneToMany
   private List<CaseComment> caseComments;
   
   @Temporal(TemporalType.TIMESTAMP)
   private Date openedDate;

   @Temporal(TemporalType.TIMESTAMP)
   private Date closedDate;
   
   @ManyToOne
   private Order order;
   
   @ManyToOne
   private Person submitter;
   
   private boolean isClosed;
   
   private String priority; //TODO: enum yap
   
   private String status; //TODO: enum yap
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

public Employee getAssignedEmployee() {
	return assignedEmployee;
}

public void setAssignedEmployee(Employee assignedEmployee) {
	this.assignedEmployee = assignedEmployee;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public List<CaseComment> getCaseComments() {
	return caseComments;
}

public void setCaseComments(List<CaseComment> caseComments) {
	this.caseComments = caseComments;
}

public Date getOpenedDate() {
	return openedDate;
}

public void setOpenedDate(Date openedDate) {
	this.openedDate = openedDate;
}

public Date getClosedDate() {
	return closedDate;
}

public void setClosedDate(Date closedDate) {
	this.closedDate = closedDate;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public Person getSubmitter() {
	return submitter;
}

public void setSubmitter(Person submitter) {
	this.submitter = submitter;
}

public boolean isClosed() {
	return isClosed;
}

public void setClosed(boolean isClosed) {
	this.isClosed = isClosed;
}

public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}   
  
}