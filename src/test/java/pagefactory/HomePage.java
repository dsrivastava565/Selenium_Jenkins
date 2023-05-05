package pagefactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage extends BaseTest{

	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signButton;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	
	}
	
	public LoginPage ClickSignButton() {
		signButton.click();
//		TakesScreenshot scr = ((TakesScreenshot)driver);
//		File srcfile = scr.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyToFile(srcfile, "destination");
		return new LoginPage();
	}
	
}
