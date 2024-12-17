package Contactcreation;

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
import org.testng.annotations.Test;

public class CreateContactWithSupportDate {

	@Test
	public void CreateContactWithSupportDate() throws Exception {
		// Load the Property file

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

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[contains(@title,'Create Contact')]")).click();

		FileInputStream excel = new FileInputStream("D:\\Qspider Classes\\Selenium.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(excel);

		XSSFSheet sh = book.getSheet("ContactData");

		String Con_name = sh.getRow(1).getCell(0).getStringCellValue();

		driver.findElement(By.name("lastname")).sendKeys("Con_name");

		Date dobj = new Date();
		SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd");
		String startdate = simpleformat.format(dobj);

		System.out.println(startdate);

		WebElement st_date = driver.findElement(By.name("support_start_date"));
		st_date.clear();
		st_date.sendKeys(startdate);

		Calendar cal = simpleformat.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 90);
		String end_date = simpleformat.format(cal.getTime());
		System.out.println(end_date);

		WebElement enddate = driver.findElement(By.name("support_end_date"));
		enddate.clear();
		enddate.sendKeys(end_date);

		driver.findElement(By.xpath("(//input[contains(@value,'Save')])[2]")).click();

		Thread.sleep(4000);

		WebElement verifystartdate = driver.findElement(By.id("dtlview_Support Start Date"));

		if (verifystartdate.getText().equalsIgnoreCase(startdate)) {

			System.out.println("Test case passed");

		} else {
			System.out.println("Test case failed");
		}

		WebElement verifyenddate = driver.findElement(By.id("dtlview_Support End Date"));

		if (verifyenddate.getText().equalsIgnoreCase(end_date)) {

			System.out.println("Test case passed");

		} else {

			System.out.println("Test case failed");

		}
		book.close();

		driver.quit();

	}

}
