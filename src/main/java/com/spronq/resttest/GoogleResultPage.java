package com.spronq.resttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by edh on 13/03/2018.
 */
public class GoogleResultPage extends PageObject {
    @FindBy(how = How.XPATH, using = "//h3[1]")
    private WebElement first;

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public String getFirst(){
        return this.first.getText();
    }

}
