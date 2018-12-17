package com.crm.qa.testlayer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.baselayer.baseclass;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.contactspage;
import com.crm.qa.util.testutil;

public class contactspagetest extends baseclass {
 Loginpage lp;
 Homepage hm;
 testutil tu;
contactspage cp;
String sheetname ="contacts";	


contactspagetest(){
		super();
		
	}
	
@BeforeMethod
public void setup(){
initialization();
lp=new Loginpage();
tu=new testutil();
cp=new contactspage();
hm=lp.login(prop.getProperty("username"),prop.getProperty("password"));
tu.switchtoframe();
cp=hm.contacticon();

}




@Test
public void displaycontactname() 
{
	//tu.switchtoframe();
boolean contact=cp.checkcontactdisplay();
	Assert.assertTrue(contact);
}

@Test
public void checkbx() 
{
	cp.checkboxactivating() ;

}

@DataProvider(name="gettestdata")
public Object[][] gettestdata() throws InvalidFormatException
{
	Object[][] data=tu.formcontactfilldata(sheetname);
	return data;
}

@Test(dataProvider="gettestdata", enabled =false)
public void contactformfill(String title,String firstname,String lastname) 
{
	hm.contactnewicon();
	cp.fillcontactform(title, firstname, lastname);
}

@AfterMethod
public void teardown() {
driver.quit();
}

	
	

}
