package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import requests.TestContext;

import java.io.IOException;

import com.google.gson.JsonObject;

import io.cucumber.java.en.And;

public class Steps {
	
	@Given("GET request on url: {string} with searchParam {string}")
	public void getEmployeeById(String friendlyName, String searchParam) {
		requests.SimpleGetTest.genericGetWithParam(friendlyName, searchParam);
	}
	
	@Given("GET request on url: {string}")
	public void getEmployeeById(String friendlyName) {
		requests.SimpleGetTest.genericGet(friendlyName);
	}
	
	@Then("Check the response status is {int}")
	public void checkResponseStatus(int status) {
		requests.SimpleResponseValidation.checkResponseStatus(status);
	}
	@And("Check the status line is correct for HTTP request")
	public void checkResponseStatusLine() {
		requests.SimpleResponseValidation.checkStatusLineHTTP();
	}
	@And("Check headers")
	public void checkHeaders() {
		requests.SimpleResponseValidation.checkHeaders();
	}
	
	@And("Check response key {string} contains value {string}")
	public void checkResponseBodyString(String key, String value) {
		requests.SimpleResponseValidation.checkResponseKeyContainsValue(key, value);
	}
	
	@And("Check response key {string} contains value {int}")
	public void checkResponseBodyInt(String key, int value) {
		requests.SimpleResponseValidation.checkResponseKeyContainsValue(key, value);
	}
	
	@Given("POST data to url: {string} from the json file: {string}")
	public void postEmployeeById(String friendlyName, String fileName) throws IOException {
		JsonObject json = requests.JsonParsing.getJsonFromFile(fileName);
		requests.SimplePostTest.genericPost(json, friendlyName);
	}
	
	@And("The key {string} is returned in the response")
	public void checkResponseKeyPresent(String key) {
		requests.SimpleResponseValidation.checkResponseKeyPresent(key);
	}
	
	@Then("The response Json matches the Json from file {string}")
	public void checkResponseJsonIsCorrect(String fileName) throws IOException {
		String expectedJson = requests.JsonParsing.getJsonFromFile(fileName).toString();
		String actualJson = TestContext.response.body().asString();
		
		requests.SimpleResponseValidation.compareJson(actualJson, expectedJson);
	}
}
