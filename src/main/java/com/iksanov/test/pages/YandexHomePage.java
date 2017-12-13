package com.iksanov.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by The Diamond Doge on 11.12.2017.
 */
public class YandexHomePage extends AbstractPage {

    private final static String URL = "http://www.yandex.ru";

    @FindBy(xpath = "//a[contains(@class, 'home-link')][text()='Маркет']")
    private WebElement marketBtn;

    public YandexHomePage load(){
        driver.navigate().to(URL);
        return this;
    }
}
