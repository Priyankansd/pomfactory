package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.baselayer.baseclass;

public class contactspage extends baseclass{
	
@FindBy(xpath="//form[@id='vContactsForm']/table/tbody/tr[1]/td")	
WebElement usernamelabel;

@FindBy(xpath="//input[@value='52539740']")	
WebElement checkbox;


@FindBy(id="first_name")	
WebElement contactfirstname;

@FindBy(id="surname")	
WebElement contactlastname;


@FindBy(xpath="//input[@value='Save']")
WebElement save;


public contactspage(){
	PageFactory.initElements(driver,this);
}


public boolean checkcontactdisplay()
{
	return usernamelabel.isDisplayed();
}


public void checkboxactivating()
{
	checkbox.click();
}

public void fillcontactform(String title,String firstname,String lastname)
{
Select st =new Select(driver.findElement(By.xpath("//*[@id='contactForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select")));
st.selectByVisibleText(title);
contactfirstname.sendKeys(firstname);
contactlastname.sendKeys(lastname);
save.submit();
}






}