package corp.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import services.WebDriverServiceImpl;

public class TransfersPage extends WebDriverServiceImpl {
	
	public BeneficiaryTransferPage clickBeneficiaryTransfer() {
		click(locateElement("xpath","//span[text()='Beneficiary Transfer']"), "Beneficiary Transfer");
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='Loading...']")));
		return new BeneficiaryTransferPage();
	}
	
	public void clickBulkTransfers() {
		click(locateElement("xpath","//span[text()='Bulk Transfers']"), "Bulk Transfers");
	}
	
	public void clickFileUpload() {
		click(locateElement("xpath","//span[text()='File Upload']"), "File Upload");
	}

}
