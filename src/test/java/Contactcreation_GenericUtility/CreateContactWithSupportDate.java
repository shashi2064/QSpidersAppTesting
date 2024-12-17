package Contactcreation_GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Vtiger_GenericUtility.FetchDate_and_Calender;
import com.Vtiger_GenericUtility.FetchExcelfile;
import com.Vtiger_GenericUtility.FetchPropertyfile;
import com.Vtiger_GenericUtility.webdriverUtilitys;

import BaseClass.BaseClass;
import POMPages.ContactInformationPage;
import POMPages.ContactPage;
import POMPages.CreateNewContact;
import POMPages.LoginPage;

public class CreateContactWithSupportDate extends BaseClass {

	@Test
	public void CreateContactselectingSupportDate() throws Exception {

		String time = property.getDataFrompropertyfile("timeouts");

		FetchExcelfile excel = new FetchExcelfile();

		String contact_lastname = excel.getDataFromExcelfile("ContactData", 4, 2);

		wb.Implicitywait(driver, time);

		ContactPage ctpage = new ContactPage(driver);

		CreateNewContact cnc = new CreateNewContact(driver);

		ContactInformationPage cntinfopage = new ContactInformationPage(driver);

		// After Login Click on contact and Click on Create New contact
		ctpage.getclick_contact();

		ctpage.getCreateContact();

		// Enter Username and click on save
		cnc.getlastname(contact_lastname);

		FetchDate_and_Calender dd = new FetchDate_and_Calender();

		cnc.getst_date(dd.getDate());

		cnc.getenddate(dd.getcalender());

		cnc.getclick_on_Save();

		Thread.sleep(4000);

		String verifystartdate = cnc.getverifystartdate();

		if (verifystartdate.equalsIgnoreCase(dd.getDate())) {

			System.out.println("Test case passed");

		} else {
			System.out.println("Test case failed");
		}

		String verifyenddate = cnc.getverifyenddate();

		System.out.println(verifyenddate);

		if (verifyenddate.equalsIgnoreCase(dd.getcalender())) {

			System.out.println("Test case passed");

		} else {

			System.out.println("Test case failed");

		}

	}

}
