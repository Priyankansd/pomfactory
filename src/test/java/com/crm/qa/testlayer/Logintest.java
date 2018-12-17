package com.crm.qa.testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baselayer.baseclass;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class Logintest extends baseclass{

	
	Loginpage lp;
	Homepage homepage;
	
	
	public Logintest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	 lp=new Loginpage();
	}
	
	@Test
	public void loginpagettitletest() {
		String title=lp.gettitle();
		 Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test
	public void imgprsnc() {
	boolean img=lp.prsenceofimg();
	  Assert.assertTrue(img);
	}
	@Test(priority=3)
	public void logintest() {
homepage=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	

	@AfterMethod
	public void teardown() {
	driver.quit();
	}
	
	
}
