package Contactcreation_GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

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

public class CreateContactselectionofOrganizationName extends BaseClass {

	@Test
	public void CreateContactwithOrganizationName() throws Exception {

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

			String validate_success = OIP.getvalidate_success();

			System.out.println(validate_success);

			if (validate_success.contains(Orgname)) {

				System.out.println("Test case passed");

			}

			else {
				System.out.println("Test case failed");
			}

			OIP.getClick_org();

			String index_validate = driver
					.findElement(By.xpath("//a[@title='Organizations'][text()='" + Orgname + "']")).getText();

			if (index_validate.contains(Orgname)) {

				System.out.println("Test case passed");

			}

			else {
				System.out.println("Test case failed");
			}

		}
		
		Thread.sleep(3000);

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

		String fetchlstname = cntinfopage.getcontactInformation();

		System.out.println(fetchlstname);

		if (fetchlstname.contains(Contact_lastname)) {

			System.out.println("Give text matched with the success message");

		} else {
			System.out.println("Text has not matched");

		}

		Thread.sleep(3000);

		ctpage.getclick_contact();
		
		WebElement getlastnamefromgrid = driver.findElement(By.xpath("//a[text()='" + Contact_lastname + "']"));

		String fetchlstnamefrmindex = getlastnamefromgrid.getText();

		System.out.println(fetchlstnamefrmindex);

		if (fetchlstnamefrmindex.equalsIgnoreCase(Contact_lastname)) {

			System.out.println("Give text matched with the success message");
		} else {
			System.out.println("Text has not matched");
		}

	}

}
