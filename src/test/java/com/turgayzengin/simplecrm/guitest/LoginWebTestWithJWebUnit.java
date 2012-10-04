package com.turgayzengin.simplecrm.guitest;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.junit.Before;
import org.junit.Test;

public class LoginWebTestWithJWebUnit {
	@Before
    public void prepare() {
        setBaseUrl("http://localhost:8080/simplecrm");
    }

    @Test
    public void testLogin() {
        beginAt("/login.jsf");        
        assertTitleEquals("Log in");
        setTextField("loginForm:username", "admin");
        setTextField("loginForm:password", "admin");
        clickButton("loginForm:login");
        assertTitleEquals("Home");
        assertElementPresent("homePageForm:welcome");
    }
}
