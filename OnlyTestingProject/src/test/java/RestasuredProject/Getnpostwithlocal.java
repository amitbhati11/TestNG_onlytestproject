package RestasuredProject;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Getnpostwithlocal {
	
	
	
	@DataProvider(name="testdata")
	
	public Object [][] getpostdata() {
		
		return new Object [][]{
			{"Nanu","bhati",1},{"nani","bhati",2}
	
		};
	}
		@Test(dataProvider="testdata")
		
		public void postmethod(String FName,String Lname,int SId ) {
			
			baseURI="http://localhost:3000";
			
			JSONObject request=new JSONObject();
			request.put("F_name",FName);
			request.put("L_name",Lname);
			request.put("SubID", SId);
			
			given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
			.post("/users").then().statusCode(201).log().all();
			
			}
		
	@Test
		public void getmethod() {
			
			baseURI="http://localhost:3000";
			
			given().when().get("/users").then().statusCode(200).log().all();
		}
			
	}


