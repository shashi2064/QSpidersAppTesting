package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {

	// Declaration

	@FindBy(name = "lastname")
	private WebElement lastname;

	public void getlastname(String lastname) {

		this.lastname.sendKeys(lastname);

	}

	@FindBy(xpath = "(//input[contains(@value,'Save')])[2]")
	private WebElement click_on_Save;

	public void getclick_on_Save() {

		this.click_on_Save.click();

	}

	@FindBy(id = "mobile")
	private WebElement mobile_nbr;

	public void getmobile_nbr(String mobilenumber) {
		this.mobile_nbr.sendKeys(mobilenumber);
	}

	@FindBy(name = "support_start_date")
	private WebElement st_date;

	public void getst_date(String enter_stdate) {
		this.st_date.clear();
		this.st_date.sendKeys(enter_stdate);
	}

	@FindBy(name = "support_end_date")
	private WebElement enddate;

	public void getenddate(String enter_enddate) {
		this.enddate.clear();
		this.enddate.sendKeys(enter_enddate);
	}

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement verifystartdate;

	public String getverifystartdate() {

		String v_stdate = verifystartdate.getText();

		return v_stdate;
	}

	@FindBy(id = "dtlview_Support End Date")
	private WebElement verifyenddate;

	public String getverifyenddate() {

		String v_enddate = verifyenddate.getText();

		return v_enddate;
	}
	
	public CreateNewContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
