package Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderUtility
{
	public static RequestSpecification BuildRequestSpec() throws Exception
	{
		try 
		{
			return new RequestSpecBuilder().setBaseUri(GlobalConstants.BaseURL).addQueryParam("api_key", GlobalConstants.GetAPIKey()).build();
		} 
		catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
}
