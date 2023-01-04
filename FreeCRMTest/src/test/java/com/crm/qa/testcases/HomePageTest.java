package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginCredentialsPage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginCredentialsPage loginCredentialsPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		TestBase.initialization();		
		 loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void homePageTest() throws InterruptedException {
	loginCredentialsPage = loginPage.loginButtonClicked();
	homePage = loginCredentialsPage.login(property.getProperty("username"),property.getProperty("password"));	
	Assert.assertTrue(homePage.userNameValidated());
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
