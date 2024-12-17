package CreateOrganisation_GenericUtility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger_GenericUtility.FetchExcelfile;
import com.Vtiger_GenericUtility.FetchPropertyfile;
import com.Vtiger_GenericUtility.RandomInt;
import com.Vtiger_GenericUtility.webdriverUtilitys;

import BaseClass.BaseClass;
import POMPages.CreateNewOrganisation;
import POMPages.LoginPage;
import POMPages.OrganisationInformationpage;
import POMPages.OrganisationPage;

public class CreateOrganisation extends BaseClass {

	@Test
	public void Organisationcreation() throws Exception {

		OrganisationPage Op = new OrganisationPage(driver);

		CreateNewOrganisation cno = new CreateNewOrganisation(driver);

		OrganisationInformationpage OIP = new OrganisationInformationpage(driver);

		FetchExcelfile excel = new FetchExcelfile();

		RandomInt r = new RandomInt();

		int rand = r.Randomnumbergeneration();

		String time = property.getDataFrompropertyfile("timeouts");

		String Orgname = excel.getDataFromExcelfile("Ord_Data", 1, 2) + rand;

		BaseClass b = new BaseClass();

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

			boolean actresult = validate_success.contains(Orgname);

			System.out.println(validate_success);

			Assert.assertEquals(actresult, true);

			OIP.getClick_org();

			String index_validate = driver
					.findElement(By.xpath("//a[@title='Organizations'][text()='" + Orgname + "']")).getText();

			boolean actorgresult = index_validate.contains(Orgname);

			Assert.assertEquals(actorgresult, true);

//			if (index_validate.contains(Orgname)) {
//
//				System.out.println("Test case passed");
//
//			}
//
//			else {
//				System.out.println("Test case failed");
//			}

		}

	}
}
