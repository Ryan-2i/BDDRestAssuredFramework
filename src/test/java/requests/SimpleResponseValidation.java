package requests;

import org.testng.Assert;
import org.testng.annotations.Test;

 
public class SimpleResponseValidation {

 
 @Test
 public static void checkResponseStatus(int status) {
	 Assert.assertEquals(TestContext.response.getStatusCode(), status, "Correct status code returned");
 }
 
 @Test
 public static void checkStatusLineHTTP() {
	 Assert.assertEquals(TestContext.response.getStatusLine(), "HTTP/1.1 200 OK", "Correct status line returned");

 }
 
 @Test
 public static void checkHeaders() {
	 Assert.assertEquals(TestContext.response.header("Content-Type"), "application/json");
	 Assert.assertEquals(TestContext.response.header("Server"), "nginx/1.16.0");
 }
 
 @Test
 public static <T> void checkResponseKeyContainsValue(String key, T value) {
	 Assert.assertEquals(TestContext.response.jsonPath().get("data."+key), value);
 }
 
 @Test
 public static void checkResponseKeyPresent(String key) {
	 Assert.assertFalse(TestContext.response.jsonPath().get("data."+key) == null);
 }
 
 @Test
 public static void compareJson(String actualJson, String expectedJson) {	
	Assert.assertEquals(actualJson, expectedJson);
 }

}
