package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class LoginPage extends BaseTest{
	

	@FindBy(id = "login_id")
	WebElement emailField;
	
	@FindBy(id = "nextbtn")
	WebElement nextButton;
	
	@FindBy(id = "password")
	WebElement passwordfield;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void EnterEmail(String username) {
		emailField.sendKeys(username);
		nextButton.click();
	}
	
	public void EnterPassword(String password) {
		passwordfield.sendKeys(password);
		nextButton.click();
	}
	

}
