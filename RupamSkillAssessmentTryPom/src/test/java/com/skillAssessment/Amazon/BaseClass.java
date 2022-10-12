package com.skillAssessment.Amazon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	Properties prop;
	String browser, baseurl;
	
	public BaseClass() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("config//config.properties"));
			browser = prop.getProperty("browser");
			baseurl = prop.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\RKUMA346\\eclipse-workspace\\RupamSkillAssessmentTryPom\\chromedriver.exe");
		    driver = new ChromeDriver();
		}
		else {
			throw new Exception("Mention Browser is not supported!!");
		}
		
		}
		catch(FileNotFoundException e) {
		  e.printStackTrace();	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//init method will initialize all the elements in web page and Page Factory is a class
	public void init() {
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 10));
		driver.manage().deleteAllCookies();
	}
	
	public void switchToNewpage() {
//		Set<String> window = driver.getWindowHandles();
//		Iterator<String> iterate = window.iterator();
//		String secondWindow = iterate.next();
//		driver.switchTo().window(secondWindow);
	
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());

	       driver.switchTo().window(newTab.get(1));
	}
}
