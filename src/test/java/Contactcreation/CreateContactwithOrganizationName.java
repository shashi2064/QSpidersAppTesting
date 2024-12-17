package Contactcreation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateContactwithOrganizationName {

	@Test
	public void CreateContactwithOrganizationName() throws Exception {

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

		XSSFSheet sh = book.getSheet("Contact_data");

		String lastname = sh.getRow(7).getCell(2).getStringCellValue();

		driver.findElement(By.name("lastname")).sendKeys(lastname);

		String mainwindow = driver.getWindowHandle();

		driver.findElement(By.xpath("//img[@title='Select']")).click();

		Set<String> windowhandles = driver.getWindowHandles();

		for (String win : windowhandles) {

			driver.switchTo().window(win);

			if (!mainwindow.equals(win)) {

				driver.findElement(By.xpath("//a[text()='Prospiders']")).click();

			}

		}

		driver.switchTo().window(mainwindow);

		String mobilenumber = sh.getRow(7).getCell(4).getStringCellValue();

		driver.findElement(By.id("mobile")).sendKeys(mobilenumber);

		driver.findElement(By.xpath("(//input[contains(@value,'Save')])[2]")).click();

		WebElement getlastname = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]"));

		String fetchlstname = getlastname.getText();

		System.out.println(fetchlstname);

		if (fetchlstname.contains(lastname)) {

			System.out.println("Give text matched with the success message");

		} else {
			System.out.println("Text has not matched");

		}

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();

		Thread.sleep(3000);

		WebElement getlastnamefromgrid = driver.findElement(By.xpath("//a[text()='Jerry']"));

		String fetchlstnamefrmindex = getlastnamefromgrid.getText();

		System.out.println(fetchlstnamefrmindex);

		if (fetchlstnamefrmindex.equalsIgnoreCase(lastname)) {

			System.out.println("Give text matched with the success message");
		} else {
			System.out.println("Text has not matched");
		}

		driver.quit();

	}

}
