package testcases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	public static void main(String[] args) {
		HttpURLConnection conn;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.interviewbit.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		List<WebElement> all= driver.findElements(By.tagName("a"));
		for(int i=0;i<all.size();i++) {
		try {
		String link = all.get(i).getAttribute("href");
		System.out.println(link);
		if(link==""|| link==null) {
			continue;
			
		}
		if(!link.startsWith("https://www.interview")){
            System.out.println("URL belongs to another domain, skipping it.");
            continue;
        }
		
		conn =  (HttpURLConnection)(new URL(link).openConnection());
		conn.setRequestMethod("HEAD");
		conn.connect();
		int response = conn.getResponseCode();
		if(response>400) {
			System.out.println("Broken");
		}else
			System.out.println("Not Broken");
		
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		driver.quit();
	}

}
