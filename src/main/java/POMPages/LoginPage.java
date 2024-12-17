package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Login -- Enter the username

	@FindBy(name = "user_name")
	private WebElement username_TF;

	// Login -- Enter the Password

	@FindBy(name = "user_password")
	private WebElement password_TF;

	// login -- Click on Submit button

	@FindBy(id = "submitButton")
	private WebElement click_submit_t;

	// Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilize
	public void getusername(String username) {
		this.username_TF.sendKeys(username);
	}

	public void getpassword(String password) {

		this.password_TF.sendKeys(password);

	}

	public void getclick_submit() {
		this.click_submit_t.click();
	}

	public void logintoapp(String user_name, String Pass_word) {

		System.out.println("shashi username " + user_name);

		getusername(user_name);

		System.out.println("shashi username" + Pass_word);

		getpassword(Pass_word);

		getclick_submit();
		
		

	}

}
