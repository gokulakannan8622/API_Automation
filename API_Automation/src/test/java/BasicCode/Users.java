package BasicCode;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Users {
	
	 @BeforeSuite
	
	    public static void setup() {
	        RestAssured.baseURI = "https://fakestoreapi.com";
	    }
	 @Test
	public void GetAllUser() {
		// TODO Auto-generated method stub
	
		given()
	      .when().get("/users").prettyPrint();

	}
	
	public void GetProductsId() {
		// TODO Auto-generated method stub
		
		given()
	      .when().get("/users/1").prettyPrint();
		
	}

	public void AddProduct() {
		// TODO Auto-generated method stub
	
		
	    
	    String requestBody = "{\n" +
	            "  \"id\": \"10\",\n" +
	            "  \"username\": \"testuser001\",\n" +	       
	            "  \"email\": \"test@test.com\",\n" +
	            "  \"password\": \"fakeapi123\" \n}";
	    
	  Response response = null;
	  
	  response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("/users");
	  
	  System.out.print("Response :"+ response.asString());
	  System.out.print("StatusCode :"+ response.getStatusCode());
	  assertEquals(201, response.getStatusCode());
	}

	public void UpdateProduct() {
		// TODO Auto-generated method stub
	
		
	    
	    String requestBody = "{\n" +
	            "  \"id\": \"9\",\n" +
	            "  \"username\": \"testuser004\",\n" +	       
	            "  \"email\": \"test1@test.com\",\n" +
	            "  \"password\": \"fakeapi123\" \n}";
	    
	    Response response = given()
	    		.contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .put("users/9")
                .then()
                .extract().response();

	    assertEquals(200, response.getStatusCode());
	}
	
	public void DeleteProduct() {
		// TODO Auto-generated method stub
	
	    
	    Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/users/2")
                .then()
                .extract().response();

	    assertEquals(200, response.getStatusCode());
	}	  
		

}
