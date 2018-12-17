package com.crm.qa.pages;





import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baselayer.baseclass;


public class Loginpage extends baseclass {

//object reposiortry
@FindBy(name="username")
WebElement username;
//
@FindBy(name="password")
WebElement password ;
//
@FindBy(xpath="//input[@type='submit']")
WebElement loginbtn ;

@FindBy(xpath="//img[@class='img-responsive']")
WebElement cmrimg;


public Loginpage()
{
	PageFactory.initElements(driver, this);
}

public String gettitle(){
//System.out.println(driver.getTitle());
   return driver.getTitle();
    
}

public boolean prsenceofimg(){
return	cmrimg.isDisplayed();
}

public Homepage login(String username1, String password2){
 username.sendKeys(username1);
 password.sendKeys(password2);
 loginbtn.submit();;
 return new Homepage();
}

}