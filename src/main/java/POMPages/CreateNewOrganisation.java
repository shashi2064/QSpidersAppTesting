package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganisation {

	@FindBy(name = "accountname")
	private WebElement Accountname;

	public void getAccountname(String orgname) {
		this.Accountname.sendKeys(orgname);
	}

	@FindBy(xpath = "//input[contains(@value,'Save')]")
	private WebElement org_save;

	public void getorg_save() {
		this.org_save.click();
	}

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement click_select;

	public void getclick_select() {
		this.click_select.click();
	}

	@FindBy(name = "industry")
	private WebElement industry;

	public WebElement getindustry() {
		return industry;
	}

	@FindBy(name = "accounttype")
	private WebElement acct_type;

	public WebElement getacct_type() {
		return acct_type;
	}

	public CreateNewOrganisation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
