package com.turgayzengin.simplecrm.unittest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.util.logging.Logger;


import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.turgayzengin.simplecrm.dao.UserDAO;
import com.turgayzengin.simplecrm.model.User;
import com.turgayzengin.simplecrm.service.UserService;

public class UserServiceUnitTest {	
	private UserService userService;
	private UserDAO userDAO = mock(UserDAO.class);
	private Logger log = mock(Logger.class);
	private User adminUser;
	
	@SuppressWarnings("rawtypes")
	@Before
    public void setUp() throws Exception {
		userService = new UserService();
		userService.setLogger(log);
		userService.setUserDAO(userDAO);
		
		adminUser = new User();
		adminUser.setId(1L);
		adminUser.setUserName("admin");
		adminUser.setPassword("admin");		
		
		when(userDAO.findByUserName((adminUser.getUserName()))) //(String)any()
        	.thenReturn(adminUser);
		
		doAnswer(new Answer() {
		    public Object answer(InvocationOnMock invocation) {
		        Object[] args = invocation.getArguments();
		        System.out.println("log prints: " + args[0]);
		        return null;
		    }})
		.when(log).info(anyString());
    }
	
	@Test
	public void shouldFindAdminByName() {		
		User admin = userService.findByUserName("admin");
		assertNotNull(admin);
		
		verify(userDAO).findByUserName("admin");
		verify(userDAO, times(1)).findByUserName("admin");

	}
	
	@Test
	public void shouldNotFindNonExistentUser() {		
		User user = userService.findByUserName("user1");
		assertNotNull(user);
	}
}
