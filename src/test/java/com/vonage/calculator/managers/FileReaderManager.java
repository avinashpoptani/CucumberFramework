package com.vonage.calculator.managers;


import com.vonage.calculator.ApplicationProperties;

import java.io.IOException;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ApplicationProperties applicationProperties;

	
	private FileReaderManager() {
	}
	
	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }
	 


	public ApplicationProperties getApplicationProperties() throws IOException {
		return (applicationProperties == null) ? applicationProperties = new ApplicationProperties("test") : applicationProperties;
	}
	 

}
