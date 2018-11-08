package com.enhancesys.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.enhancesys.qa.base.TestBase;

public class UploadPage extends TestBase 
{
	//Access to Upload Menu
	@FindBy(xpath="//span[@class='menu-text' and text()='Upload']")
	WebElement uploadMenu;
	
	//Access Download Summary submenu
	@FindBy(xpath="//span[@class='menu-text' and text()='Download Summary']")
	WebElement downloadSummary;
	
	//Access Upload summary submenu
	@FindBy(xpath="//span[@class='menu-text' and text()='Upload Summary ']")
	WebElement uploadSummary;
	
	//Download button before selecting template type
	@FindBy(xpath="//button[@id='downloadForm' and text()='Download']")
	WebElement downloadButton;
	
	//Upload button before selecting template type
	@FindBy(xpath="//button[@id='uploadForm']")
	WebElement uploadButton;
	
	//To select the template type to download
	@FindBy(xpath="//kout//select[@class='form-control required' and @name='select_template_type']")
	WebElement selectDownloadTemplateType;
	
	//To select the template type to upload
	@FindBy(xpath="//kout//select[@class='form-control required' and @name='select_template_type']")
	WebElement selectUploadTemplateType; 
	
	//Choose file to upload
	@FindBy(xpath="//kout//input[@type='file' and @name='chosen_file']")
	WebElement chooseFileButton;
	
	//Submit button to upload the template from upload summary
	@FindBy(xpath="//kout//button[@id='uploadFileSumbit']")
	WebElement uploadTemplateSubmit;
	
	//Submit button to download the template from download summary
	@FindBy(xpath="//kout//button[@id='downloadFileSumbit']")
	WebElement downloadTemplateSubmit;
	
	//Refresh icon to wait for status to be completed
	@FindBy(xpath="//span[@class='ui-icon icon icon-refresh green']")
	WebElement downloadSummaryRefreshIcon;
	
	//Check status label is completed
	@FindBy(xpath="//tr[@id='1']//span[@class='label label-sm label-success' and text()='Completed']")
	WebElement checkCompletedStatusLabel;
	
	//Button to download the existing template after finally prepared
	@FindBy(xpath="//tr[@id='1']//i[@class='icon-download']")
	WebElement downloadTemplateButton;
	
	public UploadPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUploadMenu()
	{
		uploadMenu.click();		
	}
	
	public void downloadTemplate() throws InterruptedException
	{
		downloadSummary.click();
		Thread.sleep(2000);
		downloadButton.click();
		
		//Selecting the template to download
		Select select=new Select(driver.findElement(By.xpath("//kout//select[@class='form-control required' and @name='select_template_type']")));
		select.selectByVisibleText(prop.getProperty("template_type"));
		
		downloadTemplateSubmit.click();
		downloadSummary.click();
		downloadSummaryRefreshIcon.click();
		downloadSummaryRefreshIcon.click();
		downloadSummaryRefreshIcon.click();
		
		Thread.sleep(8000);
		downloadTemplateButton.click();
		/*WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@id='1']//span[@class='label label-sm label-success' and text()='Completed']")));
		Thread.sleep(4000);
		
		if(checkCompletedStatusLabel.equals("Completed"))
		{
			downloadTemplateButton.click();
		}*/		
	}
	
	public void uploadTemplate() throws InterruptedException
	{
		uploadSummary.click();
		Thread.sleep(2000);
		uploadButton.click();
		Select select = new Select(driver.findElement(By.xpath("//kout//select[@class='form-control required' and @name='select_template_type']")));
		select.selectByVisibleText(prop.getProperty("template_type"));
		chooseFileButton.sendKeys("C:\\Users\\ENH173\\Desktop\\INDOSAT\\CreateProduct_07062018_135258.xlsm");
		uploadTemplateSubmit.click();
		uploadSummary.click();
		downloadSummaryRefreshIcon.click();
		downloadSummaryRefreshIcon.click();
		downloadSummaryRefreshIcon.click();
		Thread.sleep(7000);
	}
}
