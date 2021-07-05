package retail.api;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAccountTransactions extends BaseRest {
	public static List<String> getFullStatement(String acctNumber, String customerId, String fromDate,String toDate) {
		init();
		/*
		 * String fromDate = "2020-12-01"; String toDate = "2021-01-31"; String
		 * acctNumber = "0011030011945"; String customerId = "10210776";
		 */

		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).body("{\"accountNo\":\""
				+ acctNumber + "\",\"customerId\":\"" + customerId + "\",\"fromDate\":\"" + fromDate
				+ "\",\"requestId\":\"FULLSTATEMENT\",\"toDate\":\"" + toDate
				+ "\",\"userName\":\"hariuser\",\"brnCode\":\"001\",\"channelType\":\"RETAIL\",\"language\":\"en\",\"ipAddress\":\"0.0.0.0\"}")
				.post("/apigateway/bankingservices/accounts/fullStatement");

		response.prettyPrint();

		List<String> txnDate = response.jsonPath().getList("items.txnValuedDate");

		for (String eachDate : txnDate) {
			System.out.println(eachDate);

		}

		return txnDate;

	}

	@Test
	public void testAccounts() {
		GetAccountTransactions.getFullStatement("0011030011945","10210776","2020-12-01","2021-01-31");
	}

}
