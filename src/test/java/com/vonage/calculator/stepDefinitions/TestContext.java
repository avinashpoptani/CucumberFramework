package com.vonage.calculator.stepDefinitions;


import com.vonage.calculator.managers.PageObjectManager;
import com.vonage.calculator.managers.WebDriverManager;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.net.http.HttpResponse;

public class TestContext {




	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	public Scenario currentScenario;
	public HttpResponse<String> token;
	public HttpResponse<String> response;

	public TestContext() throws IOException {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}



}
