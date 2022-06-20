package com.vonage.calculator.stepDefinitions.api;

import com.jayway.jsonpath.JsonPath;
import com.vonage.calculator.managers.FileReaderManager;
import com.vonage.calculator.stepDefinitions.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class APIStepDef implements En {

    TestContext testContext;
    HttpClient client;
    HttpRequest requestHttp;

    public APIStepDef(TestContext context) {
        testContext = context;
        Given("^the user is authorized$", () -> {
            client = HttpClient.newHttpClient();
            HttpRequest requestHttp = HttpRequest.newBuilder()
                    .uri(new URI(FileReaderManager.getInstance().getApplicationProperties().getApplicationUrl()))
                    .POST(HttpRequest.BodyPublishers.ofString("{ \"userName\":\"" + "USERNAME" + "\", \"password\":\"" + "PASSWORD" + "\"}"))
                    .build();
            testContext.token = client.send(requestHttp,
                    HttpResponse.BodyHandlers.ofString());
            assertEquals("message", 200, testContext.token.statusCode());
        });


        Given("^fetch the group Names$", () -> {
            client = HttpClient.newHttpClient();
            requestHttp = HttpRequest.newBuilder()
                    .header("Authorization", testContext.token.toString())
                    .uri(new URI(FileReaderManager.getInstance().getApplicationProperties().getApplicationUrl()))
                    .GET()
                    .build();
            testContext.response = client.send(requestHttp,
                    HttpResponse.BodyHandlers.ofString());
            assertEquals("message", 200, testContext.response.statusCode());
        });


        Given("^validate the following fields in response$", (DataTable fieldValues) -> {
            for (Map<String, String> fieldValue : fieldValues.asMaps(String.class, String.class)) {
                fieldValue.forEach((field, value) -> {
                            System.out.println((field + ":" + value));
                            assertEquals(JsonPath.read(JsonPath.parse(testContext.response.body()), field), value);
                        }
                );
            }
        });
    }

}
