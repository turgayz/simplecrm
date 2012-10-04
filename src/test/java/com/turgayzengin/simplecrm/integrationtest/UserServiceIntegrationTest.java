package com.turgayzengin.simplecrm.integrationtest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.inject.Inject;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.turgayzengin.simplecrm.model.User;
import com.turgayzengin.simplecrm.service.UserService;

@RunWith(Arquillian.class)
@PrepareForTest(FacesContext.class)
public class UserServiceIntegrationTest {		
	
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "simplecrm_test.war")
				.addPackage("com.turgayzengin.simplecrm.dao")
				.addPackage("com.turgayzengin.simplecrm.model")
				.addPackage("com.turgayzengin.simplecrm.service")
				.addPackage("com.turgayzengin.simplecrm.web")
				.addPackage("com.turgayzengin.simplecrm.util")
				// .addClasses(Permission.class, Resources.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
						.addAsResource("log4j.xml")
				.addAsResource("import.sql")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource(new File("src/main/webapp/WEB-INF", "faces-config.xml"))
				.addAsWebInfResource("test-ds.xml");
		// Deploy our test datasource
		// .addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}

	@Inject
	UserService userService;

	@Inject
	Logger logger;

	@Test
	@InSequence(1)
	public void adminShouldLoginSuccessfully() throws Exception {
		User user = userService.findByUserName("admin");
		assertNotNull(user);
	}

	@Test
	@InSequence(2)
	public void nonExistentUserShouldNotLogin() throws Exception {
		User user = userService.findByUserName("user123");
		assertNull(user);
	}

}
