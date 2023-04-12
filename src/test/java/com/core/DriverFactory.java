package com.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	
	public static WebDriver driver = null;
	
	public static WebDriver getDriver() {

		if (driver == null) {
				
			String browser = GlobalProperty.getProperty("browser.type");
			String pathDriver = GlobalProperty.getProperty("path.driver");
			
			if (browser.equals("chrome")) {
		
				System.setProperty("webdriver.chrome.driver", pathDriver+"chromedriver");
				driver = new ChromeDriver();
			}
			
			if (browser.equals("chrome_headless")) {
				System.setProperty("webdriver.chrome.driver", pathDriver+"chromedriver");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("window-size=370x527");
				
				driver = new ChromeDriver(options);
			}
			
			if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", pathDriver+"geckodriver");
				driver = new FirefoxDriver();
			}
			
			if (browser.equals("firefox_headless")) {
				System.setProperty("webdriver.gecko.driver", pathDriver+"geckodriver");
				
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				//options.addArguments("--window-size").addArguments("370,527");
				options.addArguments("--width=370");
				options.addArguments("--height=527");
				
				driver = new FirefoxDriver(options);
			}
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
