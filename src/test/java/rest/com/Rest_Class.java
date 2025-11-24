package rest.com;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import io.restassured.response.Response;


public class Rest_Class {
	
	public Response response;
	 
	String TOKEN_Generated= "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJTdXBlckFkbWluIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvYW5vbnltb3VzIjoiMTA0NDEiLCJ1c2VySWQiOiI2ODUiLCJqdGkiOiI3ZThkM2E5ZC0wOWU5LTQ3NTYtYWY1OS0wMTMzMDc5ODhmYjEiLCJ1c2VyYXV0aCI6IjEwNDQxLDEwNDQxIVN1cGVyQWRtaW4hMDQwMkRBZG1pbjAwMDAxITY4NSIsImV4cCI6MTc2NDAxMDc2MywibmJmIjoxNzYzOTc4MzYzLCJpc3MiOiJodHRwczovL21zaWJwbGNybS5jby5pbi8iLCJhdWQiOiJodHRwczovL21zaWJwbGNybS5jby5pbi8ifQ.BF8JJnloHJLqhEqldvYKAuzstK2OoAwbFmIFCYljYUE";
	String apiKey = "";
	String BASE_URI ="https://a8s1b1c5n6.execute-api.ap-south-1.amazonaws.com";
	// ...................................................................................
		@Test(priority = 1)
		public void getuserliststatus() {
			RestAssured.baseURI = BASE_URI;
	 
			String payload = "{"
			        + "\"dealerID\":[{\"dealerID\":10441}],"
			        + "\"cityName\":[],"
			        + "\"regionName\":[],"
			        + "\"dealerParent\":[],"
			        + "\"userId\":685"
			        + "}";

	 
			// Sending POST request with Authorization and API Key headers
			response = given().relaxedHTTPSValidation().contentType(ContentType.JSON)
					.header("authorization", TOKEN_Generated).body(payload).when()
					.post("/dev/api/usermanagement/getuserliststatus").then().extract().response();
			StatusCode(); // Get Status Code with Message
		}
		
		@Test(priority = 2)
		public void Locationsummary() {
			RestAssured.baseURI = "https://test.msibplcrm.co.in";
			
	 
			String payload = "{"
			        + "\"dealerID\":[{\"dealerID\":10441}],"
			        + "\"userId\":685,"
			        + "\"fromDate\":\"01-11-2025\","
			        + "\"toDate\":\"20-11-2025\""
			        + "}";


	 
			// Sending POST request with Authorization and API Key headers
			response = given().relaxedHTTPSValidation().contentType(ContentType.JSON)
					.header("authorization", TOKEN_Generated).body(payload).when()
					.post("/report/insurance/getdistancetravelledsummaryreport").then().extract().response();
			StatusCode(); // Get Status Code with Message
		}
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		private void StatusCode() {
			// Validate response status code
			int statusCode = response.getStatusCode();
			String statusMessage = getHttpStatusMessage(statusCode);
	 
			Assert.assertEquals(statusCode, 200,
					"Expected status code 200 OK, but received: " + statusCode + " (" + statusMessage + ")");
	 
			// Print response body
			 System.out.println("RESPONSE BODY :::::: >>>>>>>>>> \n " +"\n "+
			 response.getBody().asString());
	 
		}
	 
		// ...............................................................................................
		private static String getHttpStatusMessage(int statusCode) {
			switch (statusCode) {
			case 200:
				return "OK";
			case 400:
				return "Bad Request";
			case 401:
				return "Unauthorized";
			case 403:
				return "Forbidden";
			case 404:
				return "Not Found";
			case 500:
				return "Internal Server Error";
			case 502:
				return "Bad Gateway";
			case 503:
				return "Service Unavailable";
			case 504:
				return "Gateway Timeout";
			default:
				return "Unknown Status";
			}
		}
}
