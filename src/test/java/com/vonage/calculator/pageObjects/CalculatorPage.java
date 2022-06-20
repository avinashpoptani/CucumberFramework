package com.vonage.calculator.pageObjects;
import com.vonage.calculator.managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CalculatorPage {
    WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.ID, using = "Calculate") WebElement btn_Calculate;
    @FindBy(how = How.XPATH,using = "//li[1]/button") WebElement btn_prime;
    @FindBy(how = How.XPATH,using = "//li[2]/button") WebElement btn_even;

    @FindBy(how = How.ID, using = "Union") WebElement btn_Union;

    public void clickOn_Calculate() throws InterruptedException {
        btn_prime.click();
        btn_Union.click();
        btn_even.click();
        btn_Calculate.click();
        Thread.sleep(10000);
    }
    public void navigateTo_CalculatorPage() throws IOException {
        driver.get(FileReaderManager.getInstance().getApplicationProperties().getApplicationUrl());
    }
}
