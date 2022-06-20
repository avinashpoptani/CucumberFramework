package com.vonage.calculator.stepDefinitions;

import com.vonage.calculator.pageObjects.CalculatorPage;
import io.cucumber.java8.En;
import io.cucumber.java.Scenario;

public class CalculatorStepsDef implements En {
    CalculatorPage calculatorPage;
    TestContext testContext;
    Scenario scenario;
    public CalculatorStepsDef(TestContext context) {
        testContext = context;
        calculatorPage=testContext.getPageObjectManager().getCalculatorPage();

        Given("^user is on Calculator Page$", () -> {
            calculatorPage.navigateTo_CalculatorPage();
            testContext.currentScenario.log("Attach string");
            calculatorPage.clickOn_Calculate();
        });
    }
}
