package Assignment.APITesting;

import org.testng.annotations.BeforeTest;
import Utilities.RequestSpecBuilderUtility;
import io.restassured.specification.RequestSpecification;

public class APIBase 
{
	RequestSpecification requestSpec;
	
	@BeforeClass
	public void SetUp() throws Exception
	{
		requestSpec = RequestSpecBuilderUtility.BuildRequestSpec();
	}
}
