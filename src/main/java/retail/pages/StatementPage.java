package retail.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.WebElement;

import retail.api.GetAccountTransactions;

public class StatementPage extends MenuPage {

	public StatementPage isShortcutDisplayed() {
		int shortcutsSize = locateElements("xpath", "//div[@class='parent-menus']/img").size();
		if (shortcutsSize == 10) {
			reportStep("All the 10 shortcuts are dispalyed.", "PASS");
		} else if (shortcutsSize < 10) {
			reportStep("Less than 10 shortcuts are displayed. Available options count is " + shortcutsSize, "FAIL");
		}
		return this;
	}

	public StatementPage clickDetailedStatement() {
		click(locateElement("xpath", "//span[text()='Detailed Statement']"), "Detailed Statement");
		System.out.println(" detailed st clicked");
		return this;
	}

	public StatementPage verifyLast10Transactions() {
		int size = locateElements("class", "statement-item").size();
		if (size == 10) {
			reportStep("The Last 10 transactions appeared as expected.", "PASS");
		} else if (size > 10) {
			reportStep("More than 10 transactions appear. The count was " + size, "FAIL");
		} else if (size < 10) {
			reportStep("Less than 10 transactions appear. The count was " + size, "WARNING");
		}
		return this;
	}

	public StatementPage selectStatementType(String transactionType) {
		if (transactionType.equalsIgnoreCase("Custom Dates")) {
			click(locateElement("xpath", "//button//span[contains(text(),'Custom Dates')]"), transactionType);
			click(locateElement("xpath", "//div[contains(@class,'DayPicker-Day') and @aria-disabled='false']"),
					"START DATE");
			click(locateElement("xpath",
					"(//div[contains(@class,'DayPicker-Day') and @aria-disabled='false'])[last()]"), "END DATE");
			clickUsingJs(locateElement("xpath", "//p[text()='Ok']"), "Ok Button");
		} else { // Last 2 Months //Last 3 Months //Current Month
			click(locateElement("xpath", "//button//span[contains(text(),'" + transactionType + "')]"),
					transactionType);
		}
		return this;
	}

	public StatementPage isTransactionDetailAvailable() {
		click(locateElement("class", "statement-item"), "Statement Item");
		verifyDisplayed(locateElement("xpath", "//div[@class='statement-expanded-value font-weight-bold']"),
				"Reference Number");
		return this;
	}

	// count : give it as either 2(for Last2Months transaction or 3 Last2Months
	// transaction)
	public StatementPage verifyTransactionsMonth(int count) throws ParseException {
		int prevMonth=0;
		int startingMonth = 0;
		
		
		// To get the previous 2 or 3 months from the current month
		List<String> prevMonthsList = new ArrayList<String>();
		LocalDate currentdate = LocalDate.now();
		Month currentMonth = currentdate.getMonth();
		int yearForEndDate = currentdate.getYear();
		int yearForStartDate = currentdate.getYear();
		
		for (int i = count; i > 0; i--) {
			prevMonthsList.add(currentMonth.minus(i).getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase());
			if(i==count) {
				startingMonth = currentMonth.minus(i).getValue();
				if((currentMonth.getValue() == 1 || currentMonth.getValue() == 2) && (count == 2 || count ==3)) {
					yearForStartDate = currentdate.getYear() - 1;
				}
				else if (currentMonth.getValue() == 3 && count == 3) {
					yearForStartDate = currentdate.getYear() - 1;
				}
				
				
			}
			else if(i==1) {
				prevMonth = currentMonth.minus(i).getValue();
				
				if(currentMonth.getValue() == 1) {
					yearForEndDate = currentdate.getYear() - 1;
				}
				
			}
					
		}

		String startDate = yearForStartDate+"-"+startingMonth+"-"+"01";
		String endDate = calculateMonthEndDate(prevMonth,yearForEndDate);
		
		Set<String> transactionMonthsSet = new LinkedHashSet<String>();

		// getting months from API
		List<String> strDates = GetAccountTransactions.getFullStatement(accountNumber,customerId,startDate,endDate);

		for (String eachDate : strDates) {

			DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
			Date date = format.parse(eachDate);
			SimpleDateFormat simpleformat = new SimpleDateFormat("MMM");
			String strMonth = simpleformat.format(date);
			transactionMonthsSet.add(strMonth.toUpperCase());

		}

		List<String> transactionMonthsList = new ArrayList<String>(transactionMonthsSet);

		// Checking if any month other than required is displayed
		transactionMonthsList.removeAll(prevMonthsList);

		if (transactionMonthsList.isEmpty()) {
			reportStep("Transactions for the specifed number of months are displayed correctly.", "PASS");
		} else {
			reportStep("Transactions are displayed other than the specifed number of months.", "FAIL");
		}
		return this;

	}

}
