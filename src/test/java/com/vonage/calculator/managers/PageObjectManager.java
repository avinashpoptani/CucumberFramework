package com.vonage.calculator.managers;

import org.openqa.selenium.WebDriver;
import com.vonage.calculator.pageObjects.*;

public class PageObjectManager {
	private WebDriver driver;
//	private LoginPage loginPage;

	private CalculatorPage calculatorPage;

	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public CalculatorPage getCalculatorPage(){
		return (calculatorPage == null) ? calculatorPage = new CalculatorPage(driver) : calculatorPage;
	}

}
