package com.iksanov.test.pages;

import com.iksanov.testing.pages.FiltersMenu;
import com.iksanov.testing.pages.MarketCatalogPage;
import com.iksanov.testing.pages.MarketHomePage;
import com.iksanov.testing.pages.YandexHomePage;
import com.iksanov.testing.util.DriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by The Diamond Doge on 11.12.2017.
 */
public class YandexMarketTest {
    private static WebDriver driver;
    private MarketCatalogPage marketCatalogPage;
    private WebDriverWait wait;

    private final String MARKET_LINK = "//a[contains(@class, 'home-link')][text()='Маркет']";
    private final String LAPTOPS_LINK = "//div[@class='catalog-menu__list']/a[text()='Ноутбуки']";
    private final String ALL_FILTRES_MENU = "//a[text()= 'Перейти ко всем фильтрам']";

    private void getInitialStateForTest(){
        YandexHomePage yandexHomePage = new YandexHomePage();
        yandexHomePage.load();

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MARKET_LINK)));

        yandexHomePage.findAndClick(MARKET_LINK);

        new MarketHomePage().computersClick();

        marketCatalogPage = new MarketCatalogPage();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LAPTOPS_LINK)));
        marketCatalogPage.findAndClick(LAPTOPS_LINK);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALL_FILTRES_MENU)));
        marketCatalogPage.findAndClick(ALL_FILTRES_MENU);

        new FiltersMenu()
                .setLaptopBrand("Lenovo")
                .setLaptopBrand("HP")
                .setMaxPrice("30000")
                .search();

        marketCatalogPage.getAmountOfLaptopsOnPage();
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = DriverManager.getDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void checkIfTenElementsOnPageAfterSearch() throws Exception {
        getInitialStateForTest();
        Assert.assertEquals("Check if there are expected amount of elements", true,
                    marketCatalogPage.checkAmountEquals(12));
    }

    @Test
    public void checkIfFirstSearchedLaptopExists(){
        getInitialStateForTest();
        marketCatalogPage
                .searchNthFromFound(0)
                .search();

        Assert.assertEquals("Check if first searched laptop exists",true, marketCatalogPage.check());
    }
}