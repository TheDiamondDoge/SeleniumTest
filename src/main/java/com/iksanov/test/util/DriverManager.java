package com.iksanov.test.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by The Diamond Doge on 11.12.2017.
 */
public class DriverManager {

    private static DriverManager instance;
    private WebDriver driver;

    public static WebDriver getDriver(){
        if(instance == null){
            instance = new DriverManager();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");

            instance.driver = new ChromeDriver(chromeOptions);
        }

        return instance.driver;
    }
}
