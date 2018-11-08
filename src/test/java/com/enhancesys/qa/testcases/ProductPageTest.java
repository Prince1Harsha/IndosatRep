package com.enhancesys.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.enhancesys.qa.base.TestBase;
import com.enhancesys.qa.pages.HomePage;
import com.enhancesys.qa.pages.LoginPage;
import com.enhancesys.qa.pages.ProductPage;
import com.enhancesys.qa.util.TestUtil;

public class ProductPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	
	public String sheetName = "productslist";
	
	public ProductPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		productPage = new ProductPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		productPage = homePage.clickOnProductMenu();
	}
	/*
	@Test(priority=1)
	public void createCategoryTest() throws InterruptedException
	{
		productPage.clickOnMasterLink();
		Thread.sleep(4000);
		//productPage.createProductCategoryAndChangeStatus();
		productPage.createProductSubCategoryAndChangeStatus();
	}
	
	@Test(priority=1)
	public void viewProductsTest() throws InterruptedException
	{
		productPage.viewProductsAndSearch();
		Thread.sleep(3000);
	}
	
	
	@DataProvider
	public Object[][] getENHTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider = "getENHTestData")
	public void createNewProductTest(String Name,String ProductDescription,String Brand, String ProductCategory,String ProductSubCategory,String ExtProductid,String IsSerialized,String MinimumPrice,String MaximumPrice,String SalePrice,String MRP,String ReorderLevel) throws InterruptedException
	{
		//productPage.createProductUsingExcel("hstarterpack","Starter", "mybrand", "mycat","mysubcat","extprdid","yes","100","300","250","500","100");
		productPage.createProductUsingExcel(Name, ProductDescription, Brand, ProductCategory, ProductSubCategory, ExtProductid, IsSerialized, MinimumPrice, MaximumPrice, SalePrice, MRP, ReorderLevel);
	}
	*/
	
	@Test(priority=1)
	public void createProductTest() throws Exception
	{
		productPage.createProductUsingExcel();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
