package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
		assertEquals("Trindade", shadowPage.getValueLastName());
	}
}
