package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement click_Organizations;
	
	public void getclick_Organizations() {
		this.click_Organizations.click();
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement click_create_Organizations;
	
	public void getclick_create_Organizations() {
		this.click_create_Organizations.click();
	}
	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


}
