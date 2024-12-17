package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInformationpage {

	public OrganisationInformationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Organization Information')]")
	private WebElement validate_success;

	public String getvalidate_success() {
		String V_success = validate_success.getText();

		return V_success;

	}

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement Click_org;

	public void getClick_org() {
		Click_org.click();
	}

}
