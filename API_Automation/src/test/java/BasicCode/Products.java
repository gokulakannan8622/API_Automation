package BasicCode;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Products {
	public void GetAllProducts() {
		// TODO Auto-generated method stub
		baseURI = "https://fakestoreapi.com/products";
		given()
	      .when().get().prettyPrint();

	}
	@Test
	public void GetProductsId() {
		// TODO Auto-generated method stub
		baseURI = "https://fakestoreapi.com";
		given()
	      .when().get("/products/20").prettyPrint();
		
	}

	public void AddProduct() {
		// TODO Auto-generated method stub
	baseURI = "https://fakestoreapi.com";
		
	    
	    String requestBody = "{\n" +
	            "  \"id\": \"21\",\n" +
	            "  \"title\": \"Mobile\",\n" +
	            "  \"price\": \"15000.00\",\n" +
	            "  \"description\": \"Smartphone\",\n" +
	            "  \"category\": \"Phone\",\n" +
	            "  \"image\": \"http://example.com\" \n}";
	    
	  Response response = null;
	  
	  response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("/products");
	  
	  System.out.print("Response :"+ response.asString());
	  System.out.print("StatusCode :"+ response.getStatusCode());
	  assertEquals(201, response.getStatusCode());
	}

	public void UpdateProduct() {
		// TODO Auto-generated method stub
	baseURI = "https://fakestoreapi.com";
		
	    
	    String requestBody = "{\n" +
	            "  \"id\": \"21\",\n" +
	            "  \"title\": \"Mobile\",\n" +
	            "  \"price\": \"15000.00\",\n" +
	            "  \"description\": \"Smartphone\",\n" +
	            "  \"category\": \"Phone\",\n" +
	            "  \"image\": \"http://example.com\" \n}";
	    
	    Response response = given()
	    		.contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .put("/products/20")
                .then()
                .extract().response();

	    assertEquals(200, response.getStatusCode());
	}
	
	public void DeleteProduct() {
		// TODO Auto-generated method stub
	baseURI = "https://fakestoreapi.com";
	    
	    Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/products/20")
                .then()
                .extract().response();

	    assertEquals(200, response.getStatusCode());
	}	  
}
