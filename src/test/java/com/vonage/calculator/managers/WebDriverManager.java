package com.vonage.calculator.managers;


import com.vonage.calculator.enums.DriverType;
import com.vonage.calculator.enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public WebDriverManager() {
		try {
			driverType = FileReaderManager.getInstance().getApplicationProperties().getBrowser();
			environmentType = FileReaderManager.getInstance().getApplicationProperties().getEnvironment();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
	
	public WebDriver getDriver() throws IOException {
		if(driver == null) driver = createDriver();
		return driver;
	}
	
	private WebDriver createDriver() throws IOException {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}
	
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() throws IOException {
        switch (driverType) {	    
        case FIREFOX : driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getApplicationProperties().getDriverPath());
        	driver = new ChromeDriver();
    		break;
        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
    		break;
        }
        
        if(FileReaderManager.getInstance().getApplicationProperties().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getApplicationProperties().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	
	
	public void quitDriver() {
		driver.close();
		driver.quit();		
	}

}
