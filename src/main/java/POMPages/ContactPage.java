package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement click_contact;

	public void getclick_contact() {
		this.click_contact.click();
	}

	@FindBy(xpath = "//img[contains(@title,'Create Contact')]")
	private WebElement CreateContact;

	public void getCreateContact() {
		this.CreateContact.click();
	}

	/*
	 * @FindBy(xpath = "//a[text()='" + con + "']") private WebElement
	 * click_CreateContact;
	 * 
	 * public void getclick_CreateContact() { this.click_CreateContact.click(); }
	 */

	// Initialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
