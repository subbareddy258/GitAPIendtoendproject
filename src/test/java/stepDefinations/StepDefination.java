package stepDefinations;

import static io.restassured.RestAssured.given;


import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import pojo.AddPlace;
import pojo.Location;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefination {
	RequestSpecification restspec;
	ResponseSpecification response;
	RequestSpecification res;
	Response resp;
	@Given("API ADD place Paylod")
	public void api_ADD_place_Paylod() {
	    // Write code here that turns the phrase above into concrete actions
		AddPlace s= new AddPlace();
		s.setAccuracy(50);
		s.setAddress("29, side layout, cohen 09");
		s.setName("Frontline house");
		s.setPhone_number("(+91) 983 893 3937");
		s.setWebsite("website");
List<String> M	= new ArrayList<String>();
M.add("shoe");
M.add("shoe shops");
s.setTypes(M);
Location l= new Location();
l.setLat(-38.383494);
l.setLat(33.427362);
s.setLocation(l);


 restspec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("Key","qaclick123")
.setContentType(ContentType.JSON).build();


 response =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
 res=given().relaxedHTTPSValidation().spec(restspec).body(s);

	}

	@When("user calls {string} with post request")
	public void user_calls_with_post_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		resp =res.when().post("/maps/api/place/add/json").then().spec(response).extract().response();
	}

	@Then("Place should add successfully with STATUS code {int}")
	public void place_should_add_successfully_with_STATUS_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(resp.getStatusCode(),200);
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String KeyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	String RESP=    resp.asString();
	JsonPath js= new JsonPath(RESP);
	System.out.println(js);
	assertEquals(js.get(KeyValue).toString(),ExpectedValue);
	//this is latest
	}
	

	
}
