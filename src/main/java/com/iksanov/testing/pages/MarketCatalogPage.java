package com.iksanov.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Pattern;


/**
 * Created by The Diamond Doge on 11.12.2017.
 */
public class MarketCatalogPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement headerSearch;

    @FindBy(xpath = "//span[@class ='button2__text']/..")
    private WebElement headerSearchBtn;

    @FindBy(xpath = "//span[text()='Показать подходящие']/..")
    private WebElement accept;

    @FindBy(xpath = "//div[@class='n-title__text']/h1")
    private WebElement nameOfTheLaptop;

    private List<WebElement> foundLaptops;
    private String searchedLaptopName;


    public MarketCatalogPage getAmountOfLaptopsOnPage(){
        String xpath = "//*[contains(@class, 'n-snippet-card2 i-bem b-zone')]";
        foundLaptops = driver.findElements(By.xpath(xpath));
        return this;
    }

    public boolean checkAmountEquals(int expectedAmount){
        if(expectedAmount == foundLaptops.size()){
            return true;
        } else {
            return false;
        }
    }

    public MarketCatalogPage searchNthFromFound(int index){
        searchedLaptopName = foundLaptops.get(index).findElement(By.xpath("//a[contains(@class, 'link n-link_theme')]")).getText();
        headerSearch.sendKeys(searchedLaptopName);
        return this;
    }

    public void search(){
        headerSearchBtn.click();
    }

    public boolean check(){
        //if(searchedLaptopName.equals(nameOfTheLaptop.getText())){
        if(Pattern.compile(searchedLaptopName).matcher(nameOfTheLaptop.getText()).find()){
            return true;
        } else {
            return false;
        }
    }
}
