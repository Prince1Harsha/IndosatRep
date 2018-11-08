package com.enhancesys.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.enhancesys.qa.base.TestBase;
import com.enhancesys.qa.pages.HomePage;
import com.enhancesys.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	HomePage homePage;
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}
}
