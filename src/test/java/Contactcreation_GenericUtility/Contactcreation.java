package Contactcreation_GenericUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Vtiger_GenericUtility.FetchExcelfile;
import com.Vtiger_GenericUtility.FetchPropertyfile;
import com.Vtiger_GenericUtility.webdriverUtilitys;

import BaseClass.BaseClass;
import POMPages.ContactInformationPage;
import POMPages.ContactPage;
import POMPages.CreateNewContact;
import POMPages.LoginPage;

public class Contactcreation extends BaseClass {

	@Test
	public void Contactcreation() throws Exception {

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

		String fetchlstname = cntinfopage.getcontactInformation();

		System.out.println(fetchlstname);

		if (fetchlstname.contains(con)) {

			System.out.println("Give text matched with the success message");

		} else {
			System.out.println("Text has not matched");

		}

		Thread.sleep(3000);

		cntinfopage.getclickcontact();

		Thread.sleep(3000);

		WebElement getlastnamefromgrid = driver.findElement(By.xpath("//a[text()='" + con + "']"));

		String fetchlstnamefrmindex = getlastnamefromgrid.getText();

		System.out.println(fetchlstnamefrmindex);

		if (fetchlstnamefrmindex.equalsIgnoreCase(con)) {

			System.out.println("Give text matched with the success message");
		} else {
			System.out.println("Text has not matched");
		}

		wb.Takescreenshot(driver, "D:\\Qspider Classes.png");

	}

}

// String browser = property.getDataFrompropertyfile("Browser");

// String URl = property.getDataFrompropertyfile("URL");

// String user_n = property.getDataFrompropertyfile("username");

// String Pwd_p = property.getDataFrompropertyfile("pwd");

//wb.QuitTheBrowser(driver);

// wb.Explicitwait_titlecontains(driver, time, URl);

// Login Page Enter Username and Password
// Lgnpage.getusername(user_n);

// Lgnpage.getpassword(Pwd_p);

// Lgnpage.getclick_submit();

/*
 * WebElement first = driver.findElement(By.name("salutationtype")); Select se =
 * new Select(first); se.selectByValue("Mr.");
 * 
 * driver.findElement(By.name("firstname")).sendKeys(con);
 */

/*
 * WebDriver driver = null;
 * 
 * if (browser.equalsIgnoreCase("chrome")) {
 * 
 * driver = new ChromeDriver();
 * 
 * } else if (browser.equalsIgnoreCase("Edge")) {
 * 
 * driver = new EdgeDriver(); }
 * 
 * else if (browser.equalsIgnoreCase("Firefox")) { driver = new FirefoxDriver();
 * }
 */

// wb.Navigatetoapplication(driver, URl);

//LoginPage Lgnpage = new LoginPage(driver);