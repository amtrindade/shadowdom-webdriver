package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.core.BasePage;
import com.core.GlobalProperty;

public class ShadowDomPage extends BasePage {
	
	
	public ShadowDomPage open() {
		getDriver().get(GlobalProperty.getProperty("url.shadow"));
		return this;
		
	}

	public ShadowDomPage inputFirstName(String firstName) {
		//shadow open
		String tfInputName = "return document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')";
		WebElement tfName = (WebElement) ((JavascriptExecutor)getDriver()).executeScript(tfInputName);		

		tfName.sendKeys(firstName);
		return this;
	}

	public ShadowDomPage inputLastName(String lastName) {
		//shadow closed
		String el = "document.querySelector('my-web-component').myRoot.querySelector('#lname').value ='"+lastName+"'";
		((JavascriptExecutor)getDriver()).executeScript(el);
		return this;
	}
	
	public ShadowDomPage inputEmail(String email) {


		
		return this;
	}

	public String getValueFirstName() {
		String tfInputName = "return document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')";
		WebElement tfName = (WebElement) ((JavascriptExecutor)getDriver()).executeScript(tfInputName);		
		
		return tfName.getAttribute("value");
	}

	public String getValueLastName() {
		String el = "document.querySelector('my-web-component').myRoot.querySelector('#lname').value";
		return (String)((JavascriptExecutor)getDriver()).executeScript(el);
		
	}

//	public void addEmailExternal(String emailExternal){
//		By externalEmail = $By.shadowRootCss("#app > sfc-shell > sdf-page-layout > div > div > div > sdf-focus-pane > div.flex.flex-row > div.flex.flex-col.pt-6 > div.overflow-scroll > form > div:nth-child(3) > sdf-input#shadow-root #input");
//
//		FluentWait<WebDriver> wait = new FluentWait<>(getDriver()).ignoring(Exception.class).pollingEvery(Duration.ofSeconds(1)).withTimeout(Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.presenceOfElementLocated(externalEmail));
//
//		WebElement emailAddExt = getDriver().findElement(externalEmail);
//
//		emailAddExt.sendKeys(emailExternal);
//		return this;
//	}


}
