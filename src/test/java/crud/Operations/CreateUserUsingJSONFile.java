package crud.Operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUserUsingJSONFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		 baseURI = "https://reqres.in";
		 
		//Step1: Create the required data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data.json");
		
		//Step2: Send the request and validate the response
		given()
		   .body(fis)
		   .contentType(ContentType.JSON)
		.when()
		   .post("/api/users")
		.then()
		   .assertThat().statusCode(201)
		   .log().all();
		
	}
}
