package com.turgayzengin.simplecrm.unittest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.turgayzengin.simplecrm.model.User;
import com.turgayzengin.simplecrm.service.UserService;
import com.turgayzengin.simplecrm.web.Login;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FacesContext.class)
public class LoginUnitTest {
	private UserService userService = mock(UserService.class);
	private FacesContext facesContext = mock(FacesContext.class);
	private Login login;
	private User adminUser;		
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	@Before
    public void setUp() throws Exception {
		PowerMockito.mockStatic(FacesContext.class);		
	    
		login = new Login();		
		login.setUserService(userService);		
		
		adminUser = new User();
		adminUser.setId(1L);
		adminUser.setUserName("admin");
		adminUser.setPassword("admin");		
		
		when(userService.findByUserName((adminUser.getUserName())))
        	.thenReturn(adminUser);
		
		when(facesContext.getCurrentInstance())
    		.thenReturn(facesContext);
		
		doAnswer(new Answer() {
		    public Object answer(InvocationOnMock invocation) {
		        Object[] args = invocation.getArguments();
		        FacesMessage facesMessage = (FacesMessage) args[1];
		        System.out.println("FacesContext'e mesaj eklendi: " + args[0] + " - " + facesMessage.getSummary());
		        return null;
		    }})
		.when(facesContext).addMessage(anyString(), (FacesMessage)any());
    }
	
	@Test
	public void adminShouldLoginSuccessfully() {
		login.setUserName("admin");
		login.setPassword("admin");
		String returnPage = login.login();
		assertEquals("home.xhtml", returnPage);
		
	}
	
	@Test
	public void nonExistentUserShouldNotLogin() {
		login.setUserName("user1");
		login.setPassword("user1");
		String returnPage = login.login();
		assertEquals(null, returnPage);
	}
}
