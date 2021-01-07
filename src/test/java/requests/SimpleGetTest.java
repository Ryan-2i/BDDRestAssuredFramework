package requests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
 
public class SimpleGetTest {
	
@Test
public static void genericGet(String friendlyName) {
	
RestAssured.baseURI = TestContext.configFileReader.getApplicationUrl(friendlyName);
	 
RequestSpecification httpRequest = RestAssured.given();
	 
TestContext.response = (httpRequest.request(Method.GET));  
	 
}
 
 @Test
 public static void genericGetWithParam(String friendlyName, String searchParam) {  
	 
 RestAssured.baseURI = TestContext.configFileReader.getApplicationUrl(friendlyName);
 
 RequestSpecification httpRequest = RestAssured.given();
 
 TestContext.response = (httpRequest.request(Method.GET, "/"+searchParam));  
 
 }
}
