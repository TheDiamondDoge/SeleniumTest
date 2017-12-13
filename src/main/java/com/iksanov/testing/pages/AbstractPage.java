package com.iksanov.testing.pages;

import com.iksanov.testing.util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by The Diamond Doge on 11.12.2017.
 */
public abstract class AbstractPage  {
    protected WebDriver driver;

    protected AbstractPage(){
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected void findAndClick(String xpath){
        WebElement webElement = driver.findElement(By.xpath(xpath));
        webElement.click();
    }
}
