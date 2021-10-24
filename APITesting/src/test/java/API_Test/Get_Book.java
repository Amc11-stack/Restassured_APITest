package API_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Book {
	
	private static final String[] getbook_details = null;
	String isbn;
	@Test
	public void getbook_details()
	{
		
		RestAssured.baseURI="https://bookstore.toolsqa.com/BookStore/v1";
		
		Response rs=RestAssured.given().when().get("/Books").then().extract().response();
		
		Assert.assertEquals(rs.getStatusCode(), 200);
		
		System.out.println(rs.body().prettyPrint());
		
		JsonPath js= new JsonPath(rs.asString());
		   isbn= js.getString("books[4].isbn"); 
		  //System.out.println(Long.parseLong(a));
	}
	
	
	@Test(dependsOnMethods = "getbook_details" )
	public void postbookdetails() {
		
        RestAssured.baseURI="https://bookstore.toolsqa.com/BookStore/v1";
		
		Response rs=RestAssured.given().queryParam("ISBN", isbn).when().get("/Book").then().extract().response();
		System.out.println(rs.getBody().asPrettyString());
		
	}
	
	@Test
	public void additionalstatement() {
		
        System.out.println("test cases are passed");
		
	}

}
