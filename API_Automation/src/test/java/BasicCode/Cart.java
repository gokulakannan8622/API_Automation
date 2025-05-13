package BasicCode;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.apache.xmlbeans.impl.values.JavaListObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Cart {
	 @BeforeSuite
		
	    public static void setup() {
	        RestAssured.baseURI = "https://fakestoreapi.com";
	    }
	
	public void GetAllCartItems() {
		// TODO Auto-generated method stub
	
		given()
	      .when().get("/carts").prettyPrint();

	}
	
	public void GetCartProductsId() {
		// TODO Auto-generated method stub
		
		given()
	      .when().get("/carts/1").prettyPrint();
		
	}

	public void AddProductInCart() {
		// TODO Auto-generated method stub
	
	
			
	    
	    String requestBody = "{\n" +
	            "  \"id\": \"10\",\n" +
	            "  \"userId\": \"testuser001\",\n" +	       	           
	             " \"products\": [{\n" +
            "  \"id\": \"21\",\n" +
            "  \"title\": \"Mobile\",\n" +
            "  \"price\": \"15000.00\",\n" +
            "  \"description\": \"Smartphone\",\n" +
            "  \"category\": \"Phone\",\n" +
            "  \"image\": \"http://example.com\" \n}]\n}";
	  Response response = null;
	  
	  response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("/carts");
	  
	  System.out.print("Response :"+ response.asString());
	  System.out.print("StatusCode :"+ response.getStatusCode());
	  assertEquals(200, response.getStatusCode());
	}
	
	public void UpdateProductInCart() {
		// TODO Auto-generated method stub
	
		
	    
	    String requestBody = "{\n" +
	            "  \"id\": \"4\",\n" +
	            "  \"userId\": \"testuser001\",\n" +	       	           
	             " \"products\": [{\n" +
            "  \"id\": \"21\",\n" +
            "  \"title\": \"Mobile\",\n" +
            "  \"price\": \"15000.00\",\n" +
            "  \"description\": \"Smartphone\",\n" +
            "  \"category\": \"Phone\",\n" +
            "  \"image\": \"http://example.com\" \n}]\n}";
	    
	    Response response = given()
	    		.contentType(ContentType.JSON)
             .and()
             .body(requestBody)
             .when()
             .put("/carts/9")
             .then()
             .extract().response();

	    assertEquals(200, response.getStatusCode());
	}
	 @Test
	public void DeleteProduct() {
		// TODO Auto-generated method stub
	
	    
	    Response response = given()
             .header("Content-type", "application/json")
             .when()
             .delete("/carts/2")
             .then()
             .extract().response();

	    assertEquals(200, response.getStatusCode());
	}	  
		

}
