package RestasuredProject;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class putpatchndelete {
	
	
	@DataProvider(name="testdata1")
	
	public Object [][] getputdata(){
		
		return new Object [][]{
			
			{"chemistry"}
		};
	}
		
		@Test(dataProvider="testdata1")
		
		public void getputmethod( String name) {
			
			baseURI="http://localhost:3000";
			JSONObject rq=new JSONObject();
			rq.put("name",name);
			
			
			
			
			given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rq.toJSONString()).when()
			.put("/Subject").then().statusCode(200).log().all();
		}
		
		
		
		@DataProvider(name="testdata2")
		
		public Object [][] getpatchdata(){
			
			return new Object [][]{
				
				{"physics"}
			};
		}
			
			@Test(dataProvider="testdata2")
			
			public void getpatchmethod( String name) {
				
				baseURI="http://localhost:3000";
				JSONObject rqe=new JSONObject();
				rqe.put("name",name);
				
				
				
				
				given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rqe.toJSONString()).when()
				.patch("/Subject").then().statusCode(200).log().all();
		
		}
			
			@DataProvider(name="testdeletedata")
			
			public Object [] deletedata(){
				
				return new Object [] {
					
					
					5,6
				};
				
				
			}
			
			@Test(dataProvider="testdeletedata")
			
			public void deletemethod(int id) {
				baseURI="http://localhost:3000";
				
				given().when().delete("/users").then().statusCode(204).log().all();
				
			}
	}




