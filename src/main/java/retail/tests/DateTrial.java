package retail.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


import retail.api.GetAccountTransactions;
import retail.data.Months;
import retail.pages.StatementPage;

public class DateTrial {

	public static java.util.Date calculateMonthEndDate(int month, int year) {
	    int[] daysInAMonth = { 29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    int day = daysInAMonth[month];
	    boolean isLeapYear = new GregorianCalendar().isLeapYear(year);

	    if (isLeapYear && month == 2) {
	        day++;
	    }
	    GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
	    java.util.Date monthEndDate = new java.util.Date(gc.getTime().getTime());
	    return monthEndDate;
	}

	public static void main(String[] args) {
	    int month = 2;
	    int year = 2021;
	    final java.util.Date calculatedDate = calculateMonthEndDate(month, year);
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    String format2 = format.format(calculatedDate);
	    System.out.println("Calculated month end date : " + format2);
	} 
}
