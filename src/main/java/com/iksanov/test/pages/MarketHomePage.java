package com.iksanov.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by The Diamond Doge on 11.12.2017.
 */
public class MarketHomePage extends AbstractPage{

    @FindBy(xpath = "//*[text() = 'Компьютеры']")
    private WebElement computers;


    public void computersClick() {

        if(!computers.isDisplayed()){
            findAndClick("//*[text() = 'Все категории']/..");
            computers.click();
        } else {
            computers.click();
        }

    }
}
