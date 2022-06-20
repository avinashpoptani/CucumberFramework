package com.vonage.calculator.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/test",
        plugin = { "pretty", "json:target/cucumber.json",
                "junit:target/Cucumber.xml",
                "html:target/cucumber-reports.html"},
        glue="com.vonage.calculator.stepDefinitions"
)
public class TestRunner {
}