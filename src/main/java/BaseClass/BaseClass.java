package BaseClass;

import org.testng.annotations.Test;

import com.Vtiger_GenericUtility.FetchDataBase;
import com.Vtiger_GenericUtility.FetchPropertyfile;
import com.Vtiger_GenericUtility.webdriverUtilitys;

import POMPages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {

	public WebDriver driver = null;

	public FetchPropertyfile property = new FetchPropertyfile();

	public FetchDataBase fdb = new FetchDataBase();

	public webdriverUtilitys wb = new webdriverUtilitys();

	public static WebDriver sdriver = null;

	@BeforeSuite
	public void beforeSuite() {

		// fdb.connectiontodb();
	}

	@AfterSuite
	public void afterSuite() {

//		fdb.closeconwithDatabase();
	}

	@BeforeTest
	public void beforeTest() {

		System.out.println("Parallel excution started");
	}

	@AfterTest
	public void afterTest() {

		System.out.println("Parallel execution stopped");
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass() {

		// public void beforeClass(String BROWSER) { == For configuration testing

		String BROWSER = property.getDataFrompropertyfile("Browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (BROWSER.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		sdriver = driver;

	}

	@AfterClass
	public void afterClass() {

		wb.QuitTheBrowser(driver);
	}

	@BeforeMethod
	public void beforeMethod() {

		String URl = property.getDataFrompropertyfile("URL");

		wb.Navigatetoapplication(driver, URl);

		wb.Maxmisewindow(driver);

		LoginPage lp = new LoginPage(driver);

		String user_n = property.getDataFrompropertyfile("username");

		System.out.println(user_n);

		String Pwd_p = property.getDataFrompropertyfile("pwd");

		System.out.println(Pwd_p);

		lp.logintoapp(user_n, Pwd_p);

	}

	@AfterMethod
	public void afterMethod() {

		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(ele).build().perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
