package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginCredentialsPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginCredentialsPage loginCredentialsPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		TestBase.initialization();		
		 loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
	String currentTitle = loginPage.validateLoginPageTitle();
	Assert.assertEquals(currentTitle,"Free CRM #1 cloud software for any business large or small");
	}
	
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean isImageDisplayed = loginPage.isCrmLogoDisplayed();
		Assert.assertTrue(isImageDisplayed);
	}
	
	@Test(priority=3)
	public void loginCRMTest() throws InterruptedException {
	loginCredentialsPage = loginPage.loginButtonClicked();
	homePage = loginCredentialsPage.login(property.getProperty("username"),property.getProperty("password"));		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
