package CreateOrganisation_GenericUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.Vtiger_GenericUtility.FetchExcelfile;
import com.Vtiger_GenericUtility.RandomInt;

import BaseClass.BaseClass;
import POMPages.CreateNewOrganisation;
import POMPages.OrganisationInformationpage;
import POMPages.OrganisationPage;

public class V_tiger_CreateorganisationAllScenarios extends BaseClass {

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

	}

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
