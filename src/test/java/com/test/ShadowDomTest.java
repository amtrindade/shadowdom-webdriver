package com.test;

import org.junit.Test;

import com.core.BaseTest;
import com.page.ShadowDomPage;

public class ShadowDomTest extends BaseTest {
	
	private ShadowDomPage shadowPage;

	@Test
	public void testShadowDom() {
		shadowPage = new ShadowDomPage();
		shadowPage.open();
		shadowPage.inputFirstName("Antonio");
		shadowPage.inputLastName("Trindade");
	}
}
