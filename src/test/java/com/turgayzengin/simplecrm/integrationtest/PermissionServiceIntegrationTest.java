package com.turgayzengin.simplecrm.integrationtest;

import static org.junit.Assert.*;

import java.util.logging.Logger;

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

import com.turgayzengin.simplecrm.model.Permission;
import com.turgayzengin.simplecrm.service.PermissionService;

@RunWith(Arquillian.class)
public class PermissionServiceIntegrationTest {
   @Deployment
   public static Archive<?> createTestArchive() {
      return ShrinkWrap.create(WebArchive.class, "test.war")
    		  .addPackage("com.turgayzengin.simplecrm.dao")
    		  .addPackage("com.turgayzengin.simplecrm.model")
    		  .addPackage("com.turgayzengin.simplecrm.service")
    		  .addPackage("com.turgayzengin.simplecrm.util")
            //.addClasses(Permission.class, Resources.class)
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("log4j.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
            // Deploy our test datasource
            //.addAsWebInfResource("test-ds.xml", "test-ds.xml");
   }

   @Inject
   PermissionService permissionService;
   
   @Inject
   Logger logger;

   @Test
   @InSequence(1)
   public void testInsertPermission() throws Exception {
	   Permission permission = new Permission();
	   permission.setName("Permission 1");
      
	   permissionService.insert(permission);
      assertNotNull(permission.getId());
      logger.info(permission.getName() + " was persisted with id " + permission.getId());
   }
   
   @Test
   @InSequence(2)
   public void testFindPermissionById() throws Exception {
	   Permission permission = permissionService.find(1L);
	   	   
      assertNotNull(permission);
      assertEquals("Permission 1", permission.getName());      
   }
   
   @Test
   @InSequence(3)
   public void testFindPermissionByName() throws Exception {
	   Permission permission = permissionService.findByName("Permission 1");	   	   
      assertNotNull(permission);     
   }
   
}
