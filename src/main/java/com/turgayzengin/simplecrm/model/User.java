package com.turgayzengin.simplecrm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
@NamedQuery(name = "user.findByUserName", query = "select u from User u where u.userName=:userName")
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(mappedBy = "user")
	private Person person;

	@OneToMany
	private List<Role> roles;

	@NotNull
	@Size(min = 1, max = 25)
	private String userName;

	@NotNull
	@Size(min = 1, max = 25)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

}