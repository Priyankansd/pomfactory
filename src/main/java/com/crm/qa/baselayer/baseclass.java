package com.crm.qa.baselayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.testutil;

public class baseclass {

	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver eh;;
	 public static WebEventListener WebeventListener;
	public baseclass() {
      
		
	try {
		 prop=new Properties();
FileInputStream ip=new FileInputStream
("C:\\Users\\nishan\\eclipse-workspace\\pomfactoryframework\\src\\main\\java\\com\\crm\\qa\\config\\congif.properties"); 
		prop.load(ip);
	}

	catch(FileNotFoundException e){
		e.printStackTrace();
	}
	catch(IOException e){
		e.printStackTrace();
	}

	}


	 public static void initialization() 
	 {
	 String browser=prop.getProperty("browser");
	 
	 if(browser.equals("chrome"))
	 {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\nishan\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");	 
		driver=new ChromeDriver();	 
			 
	 }
	 else if(browser.equals("FF"))
	 {
		System.setProperty("webdriver.driver.gecko", "C:/Users/nishan/Downloads/geckodriver.exe");	 
		driver=new FirefoxDriver();	 
			 
	 }
	 
	 eh = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
	 WebeventListener = new WebEventListener();
		eh.register(WebeventListener);
	//	driver = eh;
	 driver.manage().window().maximize();
		 		driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(testutil.implicitwait, TimeUnit.SECONDS);
				driver.get(prop.getProperty("url"));
	 }
	 
}
