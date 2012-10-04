package com.turgayzengin.simplecrm.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.turgayzengin.simplecrm.model.User;
import com.turgayzengin.simplecrm.service.UserService;


@ManagedBean
@SessionScoped
public class Login {
	@EJB
	private UserService userService;
		
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public static final String SUCCESS = "Welcome";
	public static final String FAILURE = "Incorrect username and password combination";

	private String userName;
	private String password;
	private User currentUser = null;
	
	public String login() {
		String view = null;
		User user = userService.findByUserName(userName);

		if (user != null && user.getPassword().equals(password)) {
			view = "home.xhtml";
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(SUCCESS));
			currentUser = user;
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, FAILURE,
							FAILURE));
		}

		return view;
	}
	
	public boolean isLoggedIn() {
		return currentUser!=null;
	}

	public String getCurrentTime() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
