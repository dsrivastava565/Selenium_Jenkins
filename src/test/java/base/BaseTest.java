package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fl1,fl2;
	
	@BeforeMethod
	public void setup() throws IOException {
		System.out.print("The path is"+System.getProperty("user.dir"));
		if(driver==null) {
			fl1 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
			fl2 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/locators.properties");
			prop.load(fl1);
			loc.load(fl2);
			
			
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			
		}else if(prop.getProperty("browser").equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			 driver = new SafariDriver();
			driver.get(prop.getProperty("testurl"));
		}
		driver.manage().window().fullscreen();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.print("Teardown");

	}

}
