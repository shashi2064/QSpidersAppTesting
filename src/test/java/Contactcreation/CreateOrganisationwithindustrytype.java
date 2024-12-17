package Contactcreation;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrganisationwithindustrytype {

	@Test
	public void CreateOrganisationwithindustrytype() throws Exception {

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Properties\\contact.properties");

		Properties p = new Properties();

		p.load(fi);

		String username = p.getProperty("username");

		String Password = p.getProperty("pwd");

		String URl = p.getProperty("URL");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(URl);

		driver.findElement(By.name("user_name")).sendKeys(username);

		driver.findElement(By.name("user_password")).sendKeys(Password);

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		FileInputStream excel = new FileInputStream("D:\\Qspider Classes\\Selenium.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(excel);

		XSSFSheet sh = book.getSheet("Org_data");

		String Org_name = sh.getRow(4).getCell(2).getStringCellValue();

		driver.findElement(By.name("accountname")).sendKeys(Org_name);

		WebElement industry = driver.findElement(By.name("industry"));
		Select se = new Select(industry);
		String indusry_drop = sh.getRow(4).getCell(3).getStringCellValue();
		se.selectByValue(indusry_drop);

		WebElement type = driver.findElement(By.name("accounttype"));
		Select se_type = new Select(type);
		String type_drop = sh.getRow(4).getCell(4).getStringCellValue();
		se_type.selectByValue(type_drop);

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

			if (validate_success.contains("Jspiders")) {

				System.out.println("Test case passed");

			}

			else {
				System.out.println("Test case failed");
			}

			driver.findElement(By.xpath("//a[text()='Organizations']")).click();

			String index_validate = driver.findElement(By.xpath("//a[@title='Organizations'][text()='Jspiders']"))
					.getText();

			if (index_validate.contains("Jspiders")) {

				System.out.println("Test case passed");

			}

			else {
				System.out.println("Test case failed");
			}

		}

		driver.quit();

	}

}
