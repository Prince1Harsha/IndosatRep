package com.enhancesys.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.Select;

import com.enhancesys.qa.base.TestBase;
import com.enhancesys.qa.util.ExcelDataApi;

public class ProductPage extends TestBase
{
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Master']")
	WebElement masterLink;

	@FindBy(xpath="//span[@class='menu-text' and text()='Create Product']")
	WebElement createProductLink;
	
	//Object Repository for Product Category

	@FindBy(xpath="//a[@id='id1']//i[@class='icon-list']")
	WebElement productCategoryIcon;
	
	@FindBy(xpath="//button[@id='createProductValue']")
	WebElement createProductCategoryButton;
		
	@FindBy(xpath="//kout//input[@class='form-control required' and @placeholder='Name']")
	WebElement productCategoryName;
	
	@FindBy(xpath="//button[@id='createProductValueButton']")
	WebElement productCategorySubmit;
	
	@FindBy(xpath="//tr[@id='1']//a[@title='Change Status']")
	WebElement productCategoryChangeStatusIcon;
	
	@FindBy(xpath="//button[@id='createProductValueButton']")
	WebElement productCategoryChangeStatusSubmit;
	
	//Object Repository for Product Sub Category
	
	@FindBy(xpath="//a[@id='id2']//i[@class='icon-list']")
	WebElement productSubCategoryIcon;
	
	@FindBy(xpath="//button[@id='createProductValue' and text()='Create']")
	WebElement createProductSubCategoryButton;
	
	@FindBy(xpath="//kout//input[@class='form-control required' and @placeholder='Name']")
	WebElement productSubCategoryName;
	
	@FindBy(xpath="//button[@id='createProductValueButton']")
	WebElement productSubCategorySubmit;
	
	@FindBy(xpath="//tr[@id=1]//a[@title='Change Status']//i[@class='icon-cog']")
	WebElement productSubCategoryChangeStatusIcon;
	
	@FindBy(xpath="//kout//button[@id='createProductValueButton']")
	WebElement productSubCategoryChangeStatusSubmit;
	
	@FindBy(xpath="//button[@data-bb-handler='ok' and @class='btn btn-primary']")
	WebElement productSubCategoryConfirmPopup;
	
	@FindBy(xpath="//span[@class='menu-text' and text()='Products']")
	WebElement viewProductsLink;
	
	@FindBy(xpath="//td[@class='ui-search-input']//input[@type='text' and @name='description']")
	WebElement productViewDescriptionFilterBox;
		
	@FindBy(xpath="//i[@class='icon-list-alt']")
	WebElement viewProductsIconAfterSearch;
	
	@FindBy(xpath="//button[@id='backToPrdValueGrid']")
	WebElement backButtonAfterProductsView;
	
	// Edit Product Object repository
	@FindBy(xpath="//tr[@id='2']//a[@title='Edit']//i[@class='icon-edit']")
	WebElement editIconOfSearchedProduct;
	
//Create Product Object repository
	@FindBy(xpath="//span[text()='Create Product']")
	WebElement createProductsLink;
	
	@FindBy(xpath="//input[@type='text' and @name='description']")
	WebElement createProductNameField;
	
	@FindBy(xpath="//kout//textarea[@name='prd_info']")
	WebElement createProductDescriptionField;
	
	@FindBy(xpath="//select[@name='brand']")
	WebElement createProductBrandSelection;
	
	@FindBy(xpath="//select[@name='prd_ctgr']")
	WebElement createProductCategory;
	
	@FindBy(xpath="//select[@name='prd_sub_ctgr']")
	WebElement createProductSubCategory;
	
	@FindBy(xpath="//input[@name='skuCode']")
	WebElement createProductExtProductId;
	
	@FindBy(xpath="//select[@name='prd_sl']")
	WebElement createProductIsSerialized;
	
	@FindBy(xpath="//input[@name='prd_price_min']")
	WebElement createProductMinPrice;
	
	@FindBy(xpath="//input[@name='prd_price_max']")
	WebElement createProductMaxPrice;
	
	@FindBy(xpath="//input[@name='prd_prc_asgd']")
	WebElement createProductSalePrice;
	
	@FindBy(xpath="//input[@name='prd_prc_allc']")
	WebElement createProductMRP;
	
	@FindBy(xpath="//input[@name='prd_reorder']")
	WebElement createProductReorderLevel;
	
	@FindBy(xpath="//button[@id='prdSubmitBtn']")
	WebElement createProductSubmitButton;
	
	public ProductPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMasterLink()
	{
		masterLink.click();
	}
	
	public void createProductCategoryAndChangeStatus() throws InterruptedException
	{
		productCategoryIcon.click();
		Thread.sleep(4000);
		createProductCategoryButton.click();
		Thread.sleep(2000);
		productCategoryName.sendKeys(prop.getProperty("product_category_name"));
		Select select = new Select(driver.findElement(By.xpath(prop.getProperty("product_line_value_xpath"))));
		select.selectByVisibleText(prop.getProperty("product_line_value"));
		productCategorySubmit.click();
		driver.findElement(By.xpath("//div[@class='modal-footer']//button[@class='btn btn-primary' and text()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='modal-footer']//button[@class='btn btn-primary' and text()='OK']")).click();
		Thread.sleep(1000);
		productCategoryChangeStatusIcon.click();		
		Select select1=new Select(driver.findElement(By.xpath(prop.getProperty("change_status_value_xpath"))));
		select1.selectByVisibleText(prop.getProperty("change_status_value"));
		productCategoryChangeStatusSubmit.click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='OK']")).click();		
	}
	
	public void createProductSubCategoryAndChangeStatus() throws InterruptedException
	{
		productSubCategoryIcon.click();
		Thread.sleep(1000);
		createProductSubCategoryButton.click();
		Thread.sleep(2000);
		productSubCategoryName.sendKeys("hautosubcat6");
		Select select = new Select(driver.findElement(By.xpath("//select[@id='parentProductValueId']")));
		select.selectByVisibleText("Starter Pack");
		productSubCategorySubmit.click();
		driver.findElement(By.xpath("//button[@data-bb-handler='confirm' and @class='btn btn-primary']")).click();
		Thread.sleep(2000);
		productSubCategoryConfirmPopup.click();
		productSubCategoryChangeStatusIcon.click();
		Select select1 = new Select(driver.findElement(By.xpath("//kout//select[@class='form-control required' and @id='status']")));
		select1.selectByVisibleText("Active");
		Thread.sleep(2000);
		productSubCategoryChangeStatusSubmit.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-bb-handler='confirm']")).click();
		productSubCategoryConfirmPopup.click();
		//productViewDescriptionFilterBox.sendKeys("HVoucher");
		//productViewDescriptionFilterBox.sendKeys(Keys.ENTER);
	}
	
	public void viewProductsAndSearch() throws InterruptedException
	{
		//1.Click on Products link under Products Menu
		viewProductsLink.click(); 
		//2.Search Product with Product description and click on Enter Button
		productViewDescriptionFilterBox.sendKeys("hstarterpack");
		Thread.sleep(3000);
		productViewDescriptionFilterBox.sendKeys(Keys.ENTER);
		//3.After searching for product click on view icon to see details of product
		Thread.sleep(2000);
		viewProductsIconAfterSearch.click();
		Thread.sleep(6000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)","");
		Thread.sleep(3000);
		backButtonAfterProductsView.click();
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,-500)","");
	}
	
	public void viewProductsSearchAndEdit() throws InterruptedException
	{
		//1.Click on Products link under Products Menu
		viewProductsLink.click(); 
		//2.Search Product with Product description and click on Enter Button
		productViewDescriptionFilterBox.sendKeys("hstarterpack");
		Thread.sleep(3000);
		productViewDescriptionFilterBox.sendKeys(Keys.ENTER);
		//3.After searching for product click on edit icon to edit details of product
		Thread.sleep(2000);
		editIconOfSearchedProduct.click();
		Thread.sleep(3000);	
	}
	/*
	public void createProductUsingExcel(String name,String prdDesc,String brand,String prdCgry,String prdSubCat,String extPrdId,String isSerialized,String minPrice,String maxPrice,String salePrice,String MRP,String reorder) throws InterruptedException
	{
		createProductLink.click();
		createProductNameField.sendKeys(name);
		createProductDescriptionField.sendKeys(prdDesc);
		createProductBrandSelection.sendKeys(brand);
		createProductCategory.sendKeys(prdCgry);
		createProductSubCategory.sendKeys(prdSubCat);
		createProductExtProductId.sendKeys(extPrdId);
		createProductIsSerialized.sendKeys(isSerialized);
		createProductMinPrice.sendKeys(minPrice);
		createProductMaxPrice.sendKeys(maxPrice);
		createProductSalePrice.sendKeys(salePrice);
		createProductMRP.sendKeys(MRP);
		createProductReorderLevel.sendKeys(reorder);
		Thread.sleep(3000);
		createProductSubmitButton.click();
		
	}
	*/
	
	public void createProductUsingExcel() throws Exception
	{
		createProductLink.click();
		Thread.sleep(4000);
		//ExcelDateUtil util = new ExcelDateUtil();
		ExcelDataApi api  = new ExcelDataApi("C:\\Users\\ENH173\\Desktop\\products.xlsx");
		createProductNameField.sendKeys(api.getCellData("productslist",0,1));
		createProductDescriptionField.sendKeys(api.getCellData("productslist",1,1));
		Thread.sleep(2000);
		createProductBrandSelection.sendKeys(api.getCellData("productslist",2,1));
		Select select1 = new Select(createProductCategory);
		select1.selectByVisibleText(api.getCellData("productslist",3,1));
		Thread.sleep(2000);
		createProductSubCategory.sendKeys(api.getCellData("productslist",4, 1));
		createProductExtProductId.sendKeys(api.getCellData("productslist",5,1));
		Select select2 = new Select(createProductIsSerialized);
		select2.selectByVisibleText(api.getCellData("productslist",6,1));
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,250)","");
		createProductMinPrice.sendKeys(api.getCellData("productslist", 7, 1));
		createProductMaxPrice.sendKeys(api.getCellData("productslist",8, 1));
		
		//Use of 3 New Element locators
		driver.findElement(new ByAll(By.name(" "), By.id(" "), By.xpath(" ")));
		driver.findElement(new ByIdOrName(""));
	}
}
