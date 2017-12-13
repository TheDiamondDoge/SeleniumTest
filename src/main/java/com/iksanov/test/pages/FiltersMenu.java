package com.iksanov.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by The Diamond Doge on 12.12.2017.
 */
public class FiltersMenu extends AbstractPage {

    @FindBy(xpath = "//input[@id=\"glf-priceto-var\"]")
    private WebElement maxPriseInput;

    @FindBy(xpath = "//span[text()='Показать подходящие']/..")
    private WebElement acceptBtn;


    public FiltersMenu setLaptopBrand(String laptopBrand){
        driver.findElement(By.xpath("//label[text()='"+laptopBrand+"']")).click();
        return this;
    }

    public FiltersMenu setMaxPrice(String maxPrice){
        maxPriseInput.sendKeys(maxPrice);
        return this;
    }

    public void search(){
        acceptBtn.click();
    }

}
