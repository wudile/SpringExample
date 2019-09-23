package com.fdmgroup.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.fdmgroup.entity.User;

public class LoginControllerTest {

	@Test
	public void given_getrequesforlogin_when_noActiveSession_then_returnLoginPage() {
		
		HttpSession mockSession = mock(HttpSession.class);
		User mockUser = mock(User.class);
		
		LoginController controller = new LoginController();
		String nextPage = controller.loadLoginPage(mockSession, mockUser);
		
		verify(mockSession).getAttribute("activeUser");
		assertEquals("login", nextPage);
	}
	
	
	@Test
	public void given_getrequesforlogin_when_ActiveSession_then_returnHomePage() {
		
		HttpSession mockSession = mock(HttpSession.class);
		User mockUser = mock(User.class);
		
		when(mockSession.getAttribute("activeUser")).thenReturn("Test User Name");
		
		LoginController controller = new LoginController();
		String nextPage = controller.loadLoginPage(mockSession, mockUser);
		
		verify(mockSession).getAttribute("activeUser");
		assertEquals("home", nextPage);
	}
	
	
	
}
