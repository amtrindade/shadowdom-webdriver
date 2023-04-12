package com.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static com.core.DriverFactory.getDriver;

public class BasePage {

    public void waitElement(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .ignoring(Exception.class)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
