package com.spronq.resttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by edh on 02/03/2018.
 */
public class GoogleWebTest {

    @Test
    public static void SearchSpronq() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.get("https://google.com");

        WebElement searchbox = driver.findElement(By.xpath("//input[@name='q']"));
        searchbox.sendKeys("Spronq");

        WebElement button = driver.findElement(By.xpath("//center/input[1]"));
        button.click();

        WebElement result = driver.findElement(By.xpath("//h3[1]"));
        Assert.assertEquals("SpronQ – van idee naar IT", result.getText());
        driver.close();
    }


    @Test
    public static void SearchSpronqWithPageObjects() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.get("https://google.com");

        GoogleHomePage home = new GoogleHomePage(driver);
        home.enterSearchText("Spronq");
        GoogleResultPage result =  home.submit();
        Assert.assertEquals("SpronQ – van idee naar IT", result.getFirst());

        driver.close();
    }

}