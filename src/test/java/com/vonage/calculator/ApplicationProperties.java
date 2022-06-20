package com.vonage.calculator;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.vonage.calculator.enums.DriverType;
import com.vonage.calculator.enums.EnvironmentType;
import org.json.*;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class ApplicationProperties {
    private JSONObject jsonObject;
    public ApplicationProperties(String env)  {
        try {
            InputStream inputStream = new FileInputStream(new File("application.yml"));

            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);
             jsonObject=new JSONObject(data);
        } catch (FileNotFoundException e) {
            System.out.println("No such file ");
            throw new RuntimeException("No config file");
        } catch (Exception e1) {
            e1.printStackTrace();
            throw new RuntimeException("Failed to read config file");
        }

    }

    public String getDriverPath(){
        String driverPath = JsonPath.read(jsonObject.toString(),"driverPath").toString();
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = JsonPath.read(jsonObject.toString(),"implicitlyWait").toString();
        if(implicitlyWait != null) {
            try{
                return Long.parseLong(implicitlyWait);
            }catch(NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public String getApplicationUrl() {
        String url = JsonPath.read(jsonObject.toString(),"url").toString();
        if(url != null) return url;
        else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public DriverType getBrowser() {
        String browserName = JsonPath.read(jsonObject.toString(),"browser").toString();
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public EnvironmentType getEnvironment() {
        String environmentName = JsonPath.read(jsonObject.toString(),"environment").toString();
        if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    public Boolean getBrowserWindowSize() {
        Boolean windowSize = JsonPath.read(jsonObject.toString(),"windowMaximize");
        if(windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

}
