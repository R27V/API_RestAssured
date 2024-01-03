package petStore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateOrder {

	public static void main(String[] args) throws FileNotFoundException {
		
        baseURI = "https://petstore.swagger.io/v2";
		
		//Step1: Create a post request - petstore using
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\petstore.json");
		
		Response resp = given()
                .body(fis)
                .contentType(ContentType.JSON)
            .when()    
                .post("/store/order");

         //Step2: Capture the data from response
           resp.then().log().all();
		
	}
}
