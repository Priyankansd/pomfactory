package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baselayer.baseclass;

public class Homepage extends baseclass {

	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/a")
	WebElement contacts;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")
	WebElement newcontacts;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement deals;

	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement task;
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}


public String verifyhomepagetitle() {
String verifyhomepage=driver.getTitle();
return verifyhomepage;
}
public boolean presenceofname(){
	
return	usernamelabel.isDisplayed();
}


public contactspage contacticon() {
 contacts.click();
 return new contactspage();
}

public contactspage contactnewicon() {
	
	Actions Ac=new Actions(driver);
	Ac.moveToElement(contacts).perform();
	newcontacts.click();
	 return new contactspage();
	}

public dealspage dealicon() {
	 deals.click();
	 return new dealspage();
	}

public taskpage taskicon() {
	 task.click();
	 return new taskpage();
	}








}
