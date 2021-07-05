package retail.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAccountBalances extends BaseRest {


	public static Map<String, String> getMaxAccountBalances(){

		init();
		Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.body("{\"accountType\" : \"S\",\r\n" + 
						"\"brnCode\" : \"001\",\r\n" + 
						"\"channelType\": \"INTERNET\",\r\n" + 
						"\"customerId\" : \"10333204\",\r\n" + 
						"\"language\": \"en\",\r\n" + 
						"\"requestId\": \"ACCOUNTSUMMARY\",\r\n" + 
						"\"ipAddress\": \"223.182.206.140\",\r\n" + 
						"\"userName\": \"testuser\"}")
				.post("/bankingservices/accountEnquiry/getBalances");
		
		response.prettyPrint();

		Map<String, String> map = new HashMap<>();
		List<String> lstAccount = response.jsonPath().getList("accounts.accNo");
		List<Object> lstBalances = response.jsonPath().getList("accounts.localBalance");
		
		double max = Double.MIN_VALUE;
		String account = "";
		for (int i = 0; i < lstAccount.size(); i++) {
			System.out.println(lstBalances.get(i));
			double balance = Double.valueOf(lstBalances.get(i).toString());
			if(balance > max) {
				max = balance;
				account = lstAccount.get(i);
			}
		}
		map.put(account, ""+max);
		return map;

	}

	
	@Test
	public void testAccounts() {
		GetAccountBalances.getMaxAccountBalances();
	}




}
