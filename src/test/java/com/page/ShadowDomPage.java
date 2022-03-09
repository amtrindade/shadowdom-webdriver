package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.core.GlobalProperty;

public class ShadowDomPage {
	
	
	public ShadowDomPage open() {
		getDriver().get(GlobalProperty.getProperty("url.shadow"));
		return this;
		
	}

	public ShadowDomPage inputFirstName(String firstName) {
		//shadow open
		String tfElement = "return document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')";
		WebElement tfName = (WebElement) ((JavascriptExecutor)getDriver()).executeScript(tfElement);
		tfName.sendKeys(firstName);
		return this;
	}

	public ShadowDomPage inputLastName(String lastName) {
		//shadow closed
		String el = "document.querySelector('my-web-component').myRoot.querySelector('#lname').value ='"+lastName+"'";
		((JavascriptExecutor)getDriver()).executeScript(el);
		
//		String element = "return document.querySelector('my-web-component').myRoot.querySelector('#lname')";
//		WebElement tfLastName = (WebElement) ((JavascriptExecutor)getDriver()).executeScript(element);
//		tfLastName.sendKeys(lastName);
		return this;
	}
	
	public ShadowDomPage inputEmail(String email) {
		
		
		return this;
	}

}
