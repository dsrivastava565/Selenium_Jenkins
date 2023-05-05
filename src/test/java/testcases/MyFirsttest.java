package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class MyFirsttest extends BaseTest{
	static HomePage hp; 
	static LoginPage lp;
	@Test(dataProvider = "testdata")
	public static void LoginTest(String username, String password) throws InterruptedException {

		hp = new HomePage();
		lp  = hp.ClickSignButton();
		lp.EnterEmail(username);
		Thread.sleep(2000);
		lp.EnterPassword(password);
		
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] tData(){
		return new Object[][] {
			{"devesh.1721it1041@kiet.edu","Devesh@123"},
			{"tutori@gmail.com","Hello@123"} 
		};
	}
}
