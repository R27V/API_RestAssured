package crud.Operation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining {

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
		               //resp.then().log().all(); -do for analysing the response, we capture the id
		//To capture information from response we use jsonPath() method from response interface
		//this jsonPath() method is similar to jasonValueCheck snippet of postman
		
		int value = resp.jsonPath().get("id");
		System.out.println(value);
		      //get() method always return object , here int is taken because we capture data in int form.
		     //.id is not use bcoz jason understand that this is the first info if we have to capture 2nd or 3rd value then we have to use(.)
		
		//Step3: Provide it as input to GET request
		Response res = get("/store/order/"+value);
		res.then().log().all();
		
	}
}
