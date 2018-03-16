package com.spronq.resttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by edh on 13/03/2018.
 */
public class GoogleHomePage extends PageObject {

    @FindBy(how = How.XPATH, using = "//input[@name='q']")
    private WebElement searchText;

    @FindBy(how = How.XPATH, using = "//center/input[1]")
    private WebElement submitButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchText(String q){
        this.searchText.sendKeys(q);

    }

    public GoogleResultPage submit(){
        submitButton.click();
        return new GoogleResultPage(driver);
    }

}