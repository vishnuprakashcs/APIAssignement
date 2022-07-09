package Assignment.APITesting;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtilities.ExcelUtility;
import Utilities.ResponseSpecUtility;
import Utilities.SessionIDUtility;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.ResponseSpecification;

public class VerifyMovieRatingUpdate extends APIBase
{
	@Test
	public void VerifyRatingPostRequest() throws Exception
	{
		ArrayList<String> datas=ExcelUtility.getData("VerifyRatingPostRequest", "APITest");
		String movieId = datas.get(1).toString();
		String guest_session_id=SessionIDUtility.GetSessionID();
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("value", datas.get(2).toString());
		
		ResponseSpecification responseSpec = ResponseSpecUtility.BuildresponseSpec(201);
		String getPostResponse= given().spec(this.requestSpec).queryParam("guest_session_id", guest_session_id)
				.header("Content-Type","application/json")
				.body(map).when().post("/3/movie/"+movieId+"/rating")
				.then().spec(responseSpec).extract().response().asString();
		
		System.out.println(getPostResponse);
		JsonPath js=new JsonPath(getPostResponse);
		String successState=js.getString("success");
		System.out.println(successState);
		Assert.assertTrue(successState.equals("true"), "Failure reason : Post request of movie rating is not successfull.");
	}
	
}
