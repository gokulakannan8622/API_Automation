package BasicCode;

import static io.restassured.RestAssured.baseURI;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthLogin {

	@Test	
	public void AuthLogin() {
		// TODO Auto-generated method stub
	baseURI = "https://fakestoreapi.com";
		
	    
	    String requestBody = "{\n" +
	            "  \"username\": \"kate_h\",\n" +
	            "  \"password\": \"kfejk@*_\" \n}";
	    
	  Response response = null;
	  
	  response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("/auth/login");
	  
	  System.out.print("Response :"+ response.asString());
	  System.out.print("StatusCode :"+ response.getStatusCode());
	  assertEquals(200, response.getStatusCode());
	}
}
