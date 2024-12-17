package Contactcreation;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Contactcreation {

	@Test
	public void Commonprogram() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("shashi123");

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[contains(@title,'Create Contact')]")).click();

		WebElement first = driver.findElement(By.name("salutationtype"));
		Select se = new Select(first);
		se.selectByValue("Mr.");

		driver.findElement(By.name("firstname")).sendKeys("Shashi1");

		driver.findElement(By.name("lastname")).sendKeys("kanth1");

		driver.findElement(By.xpath("(//input[contains(@value,'Save')])[2]")).click();

		WebElement getlastname = driver
				.findElement(By.xpath("//span[contains(text(),'kanth1 Shashi1 -  Contact Information')]"));

		String fetchlstname = getlastname.getText();

		System.out.println(fetchlstname);

		if (fetchlstname.contains("kanth1 Shashi1")) {

			System.out.println("Give text matched with the success message");

		} else {
			System.out.println("Text has not matched");

		}

		Thread.sleep(3000);

		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();

		Thread.sleep(3000);

		WebElement getlastnamefromgrid = driver.findElement(By.xpath("//a[text()='kanth1']"));

		String fetchlstnamefrmindex = getlastnamefromgrid.getText();

		System.out.println(fetchlstnamefrmindex);

		if (fetchlstnamefrmindex.equalsIgnoreCase("kanth1")) {

			System.out.println("Give text matched with the success message");
		} else {
			System.out.println("Text has not matched");
		}

		driver.quit();

	}

}
