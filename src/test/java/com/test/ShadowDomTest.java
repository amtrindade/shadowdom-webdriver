package com.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.ShadowDomPage;

public class ShadowDomTest extends BaseTest {
	
	private ShadowDomPage shadowPage;

	@Test
	public void testShadowDom() throws InterruptedException {
		shadowPage = new ShadowDomPage();
		shadowPage.open();
		shadowPage.inputFirstName("Antonio");		
		shadowPage.inputLastName("Trindade");
			
		assertEquals("Antonio", shadowPage.getValueFirstName());
		//assertEquals("Trindade", shadowPage.getValueLastName());
	}
	
	@Test
	public void testWithFramewoorkShadowRoot() {
		shadowPage = new ShadowDomPage();
		shadowPage.open();
		shadowPage.inputFirstNameFramework("Antonio");
		//shadowPage.inputLastNameFramework("Trindade");
		assertEquals("Antonio", shadowPage.getValueFirstNameFramework());
	}
}
