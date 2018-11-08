package com.enhancesys.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.enhancesys.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//span[@class='menu-text' and text()='Home']")
	WebElement homeMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Inbox ']")
	WebElement inboxMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='My Network ']")
	WebElement myNetworkMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Product']")
	WebElement productMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Order ']")
	WebElement orderMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Stock ']")
	WebElement stockMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Sales ']")
	WebElement salesMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Administrator']")
	WebElement administratorMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Aggregates ']")
	WebElement aggregatesMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Journey Plan']")
	WebElement journeyPlanMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Upload']")
	WebElement uploadMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Reports']")
	WebElement reportsMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Messaging']")
	WebElement messagingMenu;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Interface']")
	WebElement interfaceMenu;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ProductPage clickOnProductMenu()
	{
		productMenu.click();
		return new ProductPage();
	}
	
	public OrderPage clickOnOrderMenu()
	{
		orderMenu.click();
		return new OrderPage();
	}
	
	public UploadPage clickOnUploadMenu()
	{
		uploadMenu.click();
		return new UploadPage();
	}
	
}
