package Utilities;

import java.util.ArrayList;

import GenericUtilities.ExcelUtility;

public class GlobalConstants
{
	public static final String BaseURL = "https://api.themoviedb.org";
	public static String GetAPIKey() throws Exception
	{
		ArrayList<String> datas=ExcelUtility.getData("APIKey", "APISettings");
		return datas.get(1).toString();
	}
}
