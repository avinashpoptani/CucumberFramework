package com.vonage.calculator.stepDefinitions;

import com.vonage.calculator.pageObjects.CalculatorPage;
import io.cucumber.java8.En;

public class CalculatorStepsDef implements En {
    CalculatorPage calculatorPage;
    TestContext testContext;
    public CalculatorStepsDef(TestContext context) {
        testContext = context;
        calculatorPage=testContext.getPageObjectManager().getCalculatorPage();
        Given("^user is on Calculator Page$", () -> {
            calculatorPage.navigateTo_CalculatorPage();
            calculatorPage.clickOn_Calculate();
        });
    }
}
