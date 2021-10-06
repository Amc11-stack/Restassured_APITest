package API_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Book {
	
	@Test
	public void getbook_details()
	{
		
		RestAssured.baseURI="https://bookstore.toolsqa.com/BookStore/v1";
		
		Response rs=RestAssured.given().when().get("/Books").then().extract().response();
		
		Assert.assertEquals(rs.getStatusCode(), 200);
		
		System.out.println(rs.body().prettyPrint());
	}

}
