package crud.Operation;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class CreateUser {

	public static void main(String[] args) {
		
		//Step1: Create the required data
		JSONObject obj = new JSONObject();
		obj.put("name", "Renu Verma");
		obj.put("job", "Automation Tester");
		
		//Step2: Send the request
		//1st Method to write by using restassured class
//		given()
//		  .body(obj)
//		  .contentType(ContentType.JSON)
//		.when()
//		  .post("https://reqres.in/api/users")
//		.then()
//		  .assertThat().statusCode(201)
//		  .log().all();
		
		//2nd method by using validatableResponse
		ValidatableResponse vResp = given()
				  .body(obj)
				  .contentType(ContentType.JSON)
				.when()
				  .post("https://reqres.in/api/users")
				.then()
				  .assertThat().statusCode(201)
				  .log().all();
		
		//Step3: Validate the response
		
	}
}
