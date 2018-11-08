package com.enhancesys.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.enhancesys.qa.base.TestBase;
import com.enhancesys.qa.pages.HomePage;
import com.enhancesys.qa.pages.LoginPage;
import com.enhancesys.qa.pages.UploadPage;

public class UploadPageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	UploadPage uploadPage;
	
	public UploadPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		uploadPage = new UploadPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		uploadPage = homePage.clickOnUploadMenu();	
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void downloadTemplateTest() throws InterruptedException
	{
		//uploadPage.downloadTemplate();
		uploadPage.uploadTemplate();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
