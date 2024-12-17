package CreateOrganisation_GenericUtility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Vtiger_GenericUtility.FetchExcelfile;
import com.Vtiger_GenericUtility.FetchPropertyfile;
import com.Vtiger_GenericUtility.RandomInt;
import com.Vtiger_GenericUtility.webdriverUtilitys;

import BaseClass.BaseClass;

public class CreateOrganisationwthPhonenumber extends BaseClass {

	@Test
	public void CreateOrganisationwithPhonenumber() throws Exception {

		String time = property.getDataFrompropertyfile("timeouts");

		FetchExcelfile excel = new FetchExcelfile();

		RandomInt r = new RandomInt();

		String Orgname = excel.getDataFromExcelfile("Ord_Data", 7, 2) + r.Randomnumbergeneration();

		String Orgphone = excel.getDataFromExcelfile("Ord_Data", 7, 3);

		wb.Implicitywait(driver, time);

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(Orgname);

		driver.findElement(By.id("phone")).sendKeys(Orgphone);

		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();

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

			String validate_success = driver
					.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();

			System.out.println(validate_success);

			if (validate_success.contains(Orgname)) {

				System.out.println("Test case passed");

			}

			else {
				System.out.println("Test case failed");
			}

			driver.findElement(By.xpath("//a[text()='Organizations']")).click();

			String index_validate = driver
					.findElement(By.xpath("//a[@title='Organizations'][text()='" + Orgname + "']")).getText();

			if (index_validate.contains(Orgname)) {

				System.out.println("Test case passed");

			}

			else {
				System.out.println("Test case failed");
			}

		}

	}

}
