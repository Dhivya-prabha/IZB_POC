package retail.data;

import java.util.Random;

public class AccountData {
	
	public static String getRandomAccount(String merchant) {		
		switch(merchant) {
			case "ZRA" : return "91"+(int)(new Random().nextDouble()*1000000000);
			case "Airtel_Topup" : return "97"+(int)(new Random().nextDouble()*10000000);		
			case "Afribus" : return "90"+(int)(new Random().nextDouble()*100000000);
			case "LiquidTelecom_Data" : return "90"+(long)(new Random().nextDouble()*10000000000L);
			default: return "91"+(int)(new Random().nextDouble()*1000000000);
		}
		
	}

}
