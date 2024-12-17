package CreateOrganisation_GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
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
import POMPages.CreateNewOrganisation;
import POMPages.LoginPage;
import POMPages.OrganisationInformationpage;
import POMPages.OrganisationPage;

public class CreateOrganisationwithindustryandtype extends BaseClass{

	@Test
	public void CreateOrganisationwithindustrytype() throws Exception {

		String time = property.getDataFrompropertyfile("timeouts");

		FetchExcelfile excel = new FetchExcelfile();

		RandomInt r = new RandomInt();
		int rand = r.Randomnumbergeneration();

		String Orgname = excel.getDataFromExcelfile("Ord_Data", 4, 2) + rand;

		String indusry_drop = excel.getDataFromExcelfile("Ord_Data", 4, 3);

		String type_drop = excel.getDataFromExcelfile("Ord_Data", 4, 4);

		wb.Implicitywait(driver, time);

		OrganisationPage Op = new OrganisationPage(driver);

		CreateNewOrganisation cno = new CreateNewOrganisation(driver);

		OrganisationInformationpage OIP = new OrganisationInformationpage(driver);

		Op.getclick_Organizations();

		Op.getclick_create_Organizations();

		cno.getAccountname(Orgname);

		wb.selectbyValue(cno.getindustry(), indusry_drop);

		Thread.sleep(1000);

		wb.selectbyValue(cno.getacct_type(), type_drop);

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

			if (index_validate.equalsIgnoreCase(Orgname)) {

				System.out.println("Test case passed");

			}

			else {
				System.out.println("Test case failed");
			}

		}

	}

}
