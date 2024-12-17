package Contactcreation_GenericUtility;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger_GenericUtility.FetchDate_and_Calender;
import com.Vtiger_GenericUtility.FetchExcelfile;
import com.Vtiger_GenericUtility.FetchPropertyfile;
import com.Vtiger_GenericUtility.RandomInt;
import com.Vtiger_GenericUtility.webdriverUtilitys;

import BaseClass.BaseClass;
import POMPages.ContactInformationPage;
import POMPages.ContactPage;
import POMPages.CreateNewContact;
import POMPages.CreateNewOrganisation;
import POMPages.LoginPage;
import POMPages.OrganisationInformationpage;
import POMPages.OrganisationPage;

public class V_tiger_ContactCreationAllScenarios extends BaseClass {

	@Test
	public void Contactcreation() throws Exception {

		LoginPage lp = new LoginPage(driver);

		FetchPropertyfile property = new FetchPropertyfile();

		FetchExcelfile excel = new FetchExcelfile();

		webdriverUtilitys wb = new webdriverUtilitys();

		ContactPage ctpage = new ContactPage(driver);

		CreateNewContact cnc = new CreateNewContact(driver);

		ContactInformationPage cntinfopage = new ContactInformationPage(driver);

		String time = property.getDataFrompropertyfile("timeouts");

		String con = excel.getDataFromExcelfile("ContactData", 1, 2);

		wb.Implicitywait(driver, time);

		// After Login Click on contact and Click on Create New contact
		ctpage.getclick_contact();

		ctpage.getCreateContact();

		// Enter Username and click on save
		cnc.getlastname(con);

		cnc.getclick_on_Save();

		boolean fetchlstname = cntinfopage.getcontactInformation().contains(con);
		System.out.println(fetchlstname);
		Assert.assertEquals(fetchlstname, true);

		/*
		 * if (fetchlstname.contains(con)) {
		 * 
		 * System.out.println("Give text matched with the success message");
		 * 
		 * } else { System.out.println("Text has not matched");
		 * 
		 * }
		 */

		Thread.sleep(3000);

		cntinfopage.getclickcontact();

		Thread.sleep(3000);

		WebElement getlastnamefromgrid = driver.findElement(By.xpath("//a[text()='" + con + "']"));

		boolean fetchlstnamefrmindex = getlastnamefromgrid.getText().equalsIgnoreCase(con);

		System.out.println(fetchlstnamefrmindex);
		Assert.assertEquals(fetchlstnamefrmindex, true);

		/*
		 * if (fetchlstnamefrmindex.equalsIgnoreCase(con)) {
		 * 
		 * System.out.println("Give text matched with the success message"); } else {
		 * System.out.println("Text has not matched"); }
		 */

		wb.Takescreenshot(driver, "D:\\Qspider Classes.png");

	}

	@Test
	public void CreateContactwithOrganizationName() throws Exception {

		LoginPage lp = new LoginPage(driver);

		FetchPropertyfile property = new FetchPropertyfile();

		FetchExcelfile excel = new FetchExcelfile();

		RandomInt r = new RandomInt();

		int rand = r.Randomnumbergeneration();

		ContactPage ctpage = new ContactPage(driver);

		CreateNewContact cnc = new CreateNewContact(driver);

		ContactInformationPage cntinfopage = new ContactInformationPage(driver);

		OrganisationPage Op = new OrganisationPage(driver);

		CreateNewOrganisation cno = new CreateNewOrganisation(driver);

		OrganisationInformationpage OIP = new OrganisationInformationpage(driver);

		String time = property.getDataFrompropertyfile("timeouts");

		String Orgname = excel.getDataFromExcelfile("ContactData", 7, 3) + rand;

		String Contact_lastname = excel.getDataFromExcelfile("ContactData", 7, 2);

		String mobilenumber = excel.getDataFromExcelfile("ContactData", 7, 4);

		webdriverUtilitys wb = new webdriverUtilitys();

		wb.Implicitywait(driver, time);

		Op.getclick_Organizations();

		Op.getclick_create_Organizations();

		cno.getAccountname(Orgname);

		cno.getorg_save();

		Thread.sleep(4000);

		try {
			Alert alert = driver.switchTo().alert();

			String popupmsg = alert.getText();

			if (popupmsg.equalsIgnoreCase("Organization Name Already Exists!")) {

				System.out.println(popupmsg);

				alert.accept();

			}

		} catch (NoAlertPresentException ex) {

			System.out.println("Alert is NOT Displayed");

			boolean validate_success = OIP.getvalidate_success().contains(Orgname);
			System.out.println(validate_success);
			Assert.assertEquals(validate_success, true);

			/*
			 * if (validate_success.contains(Orgname)) {
			 * 
			 * System.out.println("Test case passed");
			 * 
			 * }
			 * 
			 * else { System.out.println("Test case failed"); }
			 */

			OIP.getClick_org();

			boolean index_validate = driver
					.findElement(By.xpath("//a[@title='Organizations'][text()='" + Orgname + "']")).getText()
					.contains(Orgname);

			Assert.assertEquals(index_validate, true);
			/*
			 * if (index_validate.contains(Orgname)) {
			 * 
			 * System.out.println("Test case passed");
			 * 
			 * }
			 * 
			 * else { System.out.println("Test case failed"); }
			 */

		}

		// After Login Click on contact and Click on Create New contact
		ctpage.getclick_contact();

		ctpage.getCreateContact();

		// Enter Username and click on save
		cnc.getlastname(Contact_lastname);

		String mainwindow = driver.getWindowHandle();

		cno.getclick_select();

		wb.Multiple_windohandles_URL(driver);

		driver.findElement(By.xpath("//a[text()='" + Orgname + "']")).click();

		driver.switchTo().window(mainwindow);

		cnc.getlastname(Contact_lastname);

		cnc.getclick_on_Save();

		boolean fetchlstname = cntinfopage.getcontactInformation().contains(Contact_lastname);

		System.out.println(fetchlstname);
		
		Assert.assertEquals(fetchlstname, true);

		/*if (fetchlstname.contains(Contact_lastname)) {

			System.out.println("Give text matched with the success message");

		} else {
			System.out.println("Text has not matched");

		}*/

		Thread.sleep(3000);

		ctpage.getclick_contact();

		Thread.sleep(3000);

		WebElement getlastnamefromgrid = driver.findElement(By.xpath("//a[text()='" + Contact_lastname + "']"));

		boolean fetchlstnamefrmindex = getlastnamefromgrid.getText().equalsIgnoreCase(Contact_lastname);

		System.out.println(fetchlstnamefrmindex);
		Assert.assertEquals(fetchlstnamefrmindex, true);

		/*if (fetchlstnamefrmindex.equalsIgnoreCase(Contact_lastname)) {

			System.out.println("Give text matched with the success message");
		} else {
			System.out.println("Text has not matched");
		}*/

	}

	@Test
	public void CreateContactselectingSupportDate() throws Exception {

		LoginPage lp = new LoginPage(driver);

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

		boolean verifystartdate = cnc.getverifystartdate().equalsIgnoreCase(dd.getDate());
		Assert.assertEquals(verifystartdate, true);

		/*
		 * if (verifystartdate.equalsIgnoreCase(dd.getDate())) {
		 * 
		 * System.out.println("Test case passed");
		 * 
		 * } else { System.out.println("Test case failed"); }
		 */

		boolean verifyenddate = cnc.getverifyenddate().equalsIgnoreCase(dd.getcalender());
		System.out.println(verifyenddate);
		Assert.assertEquals(verifyenddate, true);

		/*
		 * if (verifyenddate.equalsIgnoreCase(dd.getcalender())) {
		 * 
		 * System.out.println("Test case passed");
		 * 
		 * } else {
		 * 
		 * System.out.println("Test case failed");
		 * 
		 * }
		 */

	}

}
