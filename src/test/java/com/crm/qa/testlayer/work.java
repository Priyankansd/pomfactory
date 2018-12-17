package com.crm.qa.testlayer;



	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


	public class work
	{
	 public static void main(String[] args)
	 {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\nishan\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
			//	System.setProperty("webdriver.gecko.driver","C:\\Users\\nishan\\Downloads\\geckodriver.exe");
			
		WebDriver driver=new ChromeDriver();
	 driver.get("https://www.crmpro.com/index.html?e=1");
	 //stores username address in @a1
	 WebElement unTexBox=driver.findElement(By.xpath("//*[@id=\'loginForm\']/div/input[1]"));
	 //refresh and username get new address x1
	 driver.navigate().refresh();
	 //try to enter admin using old address a1
	 unTexBox.sendKeys("admin");
	 }
	}
