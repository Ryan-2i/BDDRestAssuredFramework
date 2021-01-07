package requests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import com.google.gson.JsonObject;

public class SimplePostTest {
 
 @Test
 public static void genericPost(JsonObject json, String friendlyName)
 {   
 RestAssured.baseURI = TestContext.configFileReader.getApplicationUrl(friendlyName);;
 
 RequestSpecification httpRequest = RestAssured.given();
 
 httpRequest.header("Content-Type", "application/json");
 httpRequest.body(json);
 
 TestContext.response = httpRequest.post();
 
 }

}
