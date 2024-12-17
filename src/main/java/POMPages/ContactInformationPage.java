package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

	@FindBy(xpath = "//span[contains(text(),'Contact Information')]")
	private WebElement contactInformation;

	public String getcontactInformation() {

		String ss = contactInformation.getText();

		return ss;

	}
	
	@FindBy(xpath = "(//a[text()='Contacts'])[1]") 
	private WebElement clickcontact;
	
	public void getclickcontact()
	{
		this.clickcontact.click();
	}

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
