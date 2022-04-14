package RestasuredProject;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class putpatchanddelete {
	
	@DataProvider(name="testdata")
	
	public Object [][] putmethod(){
		
		return new Object [][] {
			
			{"amit","sof"}
		};
		
	}
	
	@Test(dataProvider="testdata")
	
	public void getputmehtod(String Name, String Job) {
		
		baseURI="https://reqres.in/";
		
		JSONObject dd=new JSONObject();
		
		dd.put("name", Name);
		dd.put("job", Job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(dd.toJSONString()).when().put("/api/users/2").
		then().statusCode(200).log().all();
		
	}

	
@Test(dataProvider="testdata")
	
	public void getpatchmehtod(String Name, String Job) {
		
		baseURI="https://reqres.in/";
		
		JSONObject dd=new JSONObject();
		
		dd.put("name", Name);
		dd.put("job", Job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(dd.toJSONString()).when().patch("/api/users/2").
		then().statusCode(200).log().all();
		
	}

@Test

public void deletemethod() {
	
	
	baseURI="https://reqres.in/";
	
	given().when().delete("/api/users/2").then().statusCode(204).log().all();
}
}
