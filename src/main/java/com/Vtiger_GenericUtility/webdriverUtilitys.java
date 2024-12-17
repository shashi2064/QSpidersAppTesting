package com.Vtiger_GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverUtilitys {

	public void Maxmisewindow(WebDriver driver) {

		driver.manage().window().maximize();
	}

	public void Implicitywait(WebDriver driver, String wait_time) {

		Long lo = Long.parseLong(wait_time);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(lo));
	}

	public void Explicitwait_Visibilityofelement(WebDriver driver, String wait_time, WebElement ele) {

		Long lo = Long.parseLong(wait_time);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(lo));

		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void Explicitwait_elementtobeclickable(WebDriver driver, String wait_time, WebElement ele) {

		Long lo = Long.parseLong(wait_time);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(lo));

		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void Explicitwait_titlecontains(WebDriver driver, String wait_time, String title) {

		Long lo = Long.parseLong(wait_time);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(lo));

		wait.until(ExpectedConditions.titleContains(title));
	}

	public void Navigatetoapplication(WebDriver driver, String URL) {

		driver.get(URL);
	}

	public void closeTheBrowser(WebDriver driver) {

		driver.close();
	}

	public void QuitTheBrowser(WebDriver driver) {

		driver.quit();
	}

	public void Multiple_windohandles_URL(WebDriver driver) {

		Set<String> windowhandles = driver.getWindowHandles();

		for (String win : windowhandles) {

			driver.switchTo().window(win);

			if (driver.getCurrentUrl().equalsIgnoreCase(win)) {

				break;

			}

		}
	}

	public void Selectbyvisibiletext(WebElement ele, String Se_Vble_text) {

		Select se = new Select(ele);
		se.selectByVisibleText(Se_Vble_text);
	}

	public void SelectbyIndex(WebElement ele, int Se_Idx) {

		Select se = new Select(ele);
		se.selectByIndex(Se_Idx);
	}

	public void selectbyValue(WebElement ele, String Se_value) {

		Select se = new Select(ele);
		se.selectByValue(Se_value);
	}

	public void FramebyIndex(WebDriver driver, int i) {
		driver.switchTo().frame(i);
	}

	public void Framebywebelement(WebDriver driver, WebElement ele) {

		driver.switchTo().frame(ele);
	}

	public void FramebyIdorName(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}

	public void Framebacktowindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void FrametoParentwindow(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	// Actions
	public void MouseoverMovetoElemet(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}

	public void ClickAndHold(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold().build().perform();
	}

/*	public void KeydownAndKeyUp(WebDriver driver, WebElement src, WebElement target) {
		Actions action = new Actions(driver);
		action.keyDown(src, target);
	}*/

	// accept
	public void accept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	// Dismiss

	public void dismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void Takescreenshot(WebDriver driver, String Path) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File dst=new File(Path);
		
		try {
			FileUtils.copyFile(src, dst);
			
		} catch (IOException e) {
			
			System.out.println("Screenshot has not captured");
		}
	}
}
