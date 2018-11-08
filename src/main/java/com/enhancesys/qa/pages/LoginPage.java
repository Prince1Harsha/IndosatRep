package com.enhancesys.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enhancesys.qa.base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//div[@class='contact-us-form-left']//input[@id='password' and @name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn-submit btnCls']")
	WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
}
