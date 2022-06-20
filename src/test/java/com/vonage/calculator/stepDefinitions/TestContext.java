package com.vonage.calculator.stepDefinitions;


import com.vonage.calculator.managers.PageObjectManager;
import com.vonage.calculator.managers.WebDriverManager;

import java.io.IOException;
import java.net.http.HttpResponse;

public class TestContext {




	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
//	private ScenarioContext scenarioContext;
	public HttpResponse<String> token;
	public HttpResponse<String> response;

	public TestContext() throws IOException {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
//		scenarioContext = new ScenarioContext();
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

//	public ScenarioContext getScenarioContext() {
//		return scenarioContext;
//	}

}
