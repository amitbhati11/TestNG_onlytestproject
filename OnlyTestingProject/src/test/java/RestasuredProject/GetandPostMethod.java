package RestasuredProject;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetandPostMethod {
	
	
	@DataProvider(name="postdata")
	
	public Object [][] getpostdata(){
		
		return new Object [][] {
			
			{"Eins","Scien"}
		
		};
		
	}
	
	@Test(dataProvider="postdata")
	
	public void postmethod(String name, String job) {
		
		baseURI="https://reqres.in";
		
		JSONObject rt=new JSONObject ();
		rt.put("name", name);
		rt.put("job", job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rt.toJSONString()).
		when().post("/api/users").
		then().statusCode(201).log().all();
		
	}
	
	@Test
	
	public void getmethod() {
		
		baseURI="https://reqres.in";
		
		given().when().get("/api/users?page=2").then().statusCode(200).log().all();
		
		
		
	}
	

}
