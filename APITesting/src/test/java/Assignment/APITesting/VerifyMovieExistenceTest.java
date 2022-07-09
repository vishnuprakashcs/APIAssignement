package Assignment.APITesting;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtilities.ExcelUtility;
import Pojo.GetResults;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class VerifyMovieExistenceTest extends APIBase
{
	@Test
	public void VerifyMovieExistence() throws Exception
	{
		ArrayList<String> data=ExcelUtility.getData("VerifyMovieExistence", "APITest");
		ArrayList<String> movies = new ArrayList<>(Arrays.asList(data.get(1).toString().split(",")));
		
		RequestSpecification req = given().spec(this.requestSpec);
		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		GetResults results = req.when().get("/3/movie/top_rated").then().spec(responseSpec).extract().as(GetResults.class);
		for(int i=0; i<movies.size(); i++)
		{
			System.out.println(movies.get(i).toString());
			Assert.assertTrue(VerifyMovieExists(results, movies.get(i).toString()), "Failure reason: Given movie not exists in the top rated list.");
		}
	}
	
	private boolean VerifyMovieExists(GetResults results, String movieName)
	{
		for(int i=0; i<results.getResults().size(); i++)
		{
			if(results.getResults().get(i).getOriginal_title().equalsIgnoreCase(movieName))
			{
				return true;
			}
		}
		
		return false;
	}
}