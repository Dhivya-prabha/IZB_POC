package retail.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class BaseRest {

	static Properties prop = new Properties();
	
	
	public static void init() {
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/environment.properties")));
		} catch (IOException e) {}
		RestAssured.baseURI = prop.getProperty("API_Server");
		RestAssured.authentication = RestAssured.oauth2("Bearer "+getToken());

	}

	private static String getToken() {

		Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.body("{\"userName\":\"hariuser\",\"password\":\"l5YVVZZBBy2NimOgMNi+pg==\",\"requestId\":\"LOGIN\",\"module\":\"LOGIN\",\"channelType\":\"RETAIL\",\"language\":\"en\",\"ipAddress\":\"0.0.0.0\"}")
				.post("apigateway/bankingservices/public/login");

		Headers headers = response.headers();
		return headers.getValue("access_token");

	}
}
