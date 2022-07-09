package Assignment.APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtilities.ExcelUtility;
import Pojo.GetResults;
import Utilities.RequestSpecBuilderUtility;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;

public class VerifyTopRatedMovieTest extends APIBase
{
	@Test
	public void VerifyTopRatedMovie() throws Exception
	{
		GetResults rc = given().spec(this.requestSpec).expect().defaultParser(Parser.JSON)
				.when().get("/3/movie/top_rated").as(GetResults.class);
		ArrayList<String> datas=ExcelUtility.getData("VerifyTopRatedMovie", "APITest");
		String movieName = datas.get(1).toString();
		Double movieVoteAvg = GetGivenMovieRating(rc, movieName);
		Assert.assertTrue(VerifyTopMovieRatingValue(rc, movieVoteAvg), "Failure reason : Given movie rating is not the top one.");
	}

	public double GetGivenMovieRating(GetResults results, String movieName)
	{
		Double voteAvg  = null; 
		for(int i=0; i<results.getResults().size(); i++)
		{
			if(results.getResults().get(i).getOriginal_title().equals(movieName))
			{
				voteAvg =  Double.parseDouble(results.getResults().get(i).getVote_average());
			}
		}

		return voteAvg;
	}

	public boolean VerifyTopMovieRatingValue(GetResults results, Double movieRating)
	{
		boolean ratingStatus  = true;
		Double voteAvg = null;
		for(int i=0; i<results.getResults().size(); i++)
		{
			voteAvg =  Double.parseDouble(results.getResults().get(i).getVote_average());
			if(movieRating < voteAvg)
			{
				ratingStatus = false;
			}
		}

		return ratingStatus;
	}
}
