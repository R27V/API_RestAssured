package crud.Operations;

import static io.restassured.RestAssured.*;

public class GetUser {

	public static void main(String[] args) {
		
		baseURI = "https://reqres.in";
		
		//Step1: Create a required data 
		
		//Step2: Send the request and validate the response
		// No pre-condition is required so we start from when() operation
//		given()
//		   .pathParam("id", 2)
//		.when()
//		  .get("/api/users/{id}")
		when()
		  .get("/api/users/2")
		.then()
		   .log().all(); 
		
		
	}
}
