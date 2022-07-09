package Utilities;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecUtility
{
	public static ResponseSpecification BuildresponseSpec(int expectedStatusCode)
	{
		return new ResponseSpecBuilder().expectStatusCode(expectedStatusCode).expectContentType(ContentType.JSON).build();
	}
}
