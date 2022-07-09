package Utilities;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SessionIDUtility 
{
	public static String GetSessionID() throws Exception
	{
		RequestSpecification req = given().spec(RequestSpecBuilderUtility.BuildRequestSpec());
		ResponseSpecification responseSpec = ResponseSpecUtility.BuildresponseSpec(200);
		String getSessionResponse = req.when().get("/3/authentication/guest_session/new").then().spec(responseSpec).extract().response().asString();
		
		System.out.println(getSessionResponse);
		JsonPath js=new JsonPath(getSessionResponse); //for parsing JSON
		return js.getString("guest_session_id");
	}
}
