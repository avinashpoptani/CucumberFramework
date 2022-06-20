package com.vonage.calculator.stepDefinitions;


import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }
    @Before
    public void doSomethingAfterStep(Scenario scenario){
        System.out.println("inside before");
        testContext.currentScenario =scenario;
    }


    @After()
    public void afterScenario(Scenario scenario) {

        try {
            byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
        } catch (IOException e) {
        }
        testContext.getWebDriverManager().quitDriver();
    }
}
