package com.crm.qa.testlayer;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baselayer.baseclass;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.contactspage;
import com.crm.qa.util.testutil;

public class Homepagetest extends baseclass{
	
	Loginpage lp;
	Homepage homepage;
	testutil tu;
	 contactspage  contactspage;
	 
	Homepagetest()
   {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	 lp=new Loginpage();
	 tu =new testutil();
	 contactspage=new  contactspage();
	 homepage=lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyhomeptitletest() {
   String title=homepage.verifyhomepagetitle();
		AssertJUnit.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyname() {
		tu.switchtoframe();
   boolean name=homepage.presenceofname();
		AssertJUnit.assertTrue(name);
	}
	
	@Test
	public void contactclick() {
		tu.switchtoframe();
		 contactspage =homepage.contacticon();
	
	}
	
	@Test(priority=4)
	public void contactnew() {
		tu.switchtoframe();
		 contactspage =homepage.contactnewicon();
	
	}
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
	

}
