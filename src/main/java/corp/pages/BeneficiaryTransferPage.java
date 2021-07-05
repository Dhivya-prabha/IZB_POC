package corp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BeneficiaryTransferPage extends MenuPage {

	public AddBeneficiaryPage clickAddBeneficiary() {
		click(locateElement("xpath","//span[text()='Add Beneficiary ']"), "Add Beneficiary");
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='Loading...']")));
		return new AddBeneficiaryPage();
	}
	
	
}
