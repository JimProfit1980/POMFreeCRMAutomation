package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginCredentialsPage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends TestBase{
	ContactPage contactPage;
	LoginPage loginPage;
	LoginCredentialsPage loginCredentialsPage;
	HomePage homePage;
	
	public ContactPageTest() {
		super();
	}
	
	@Test(priority=1)
	public void contactPageValidated() throws InterruptedException {			
		boolean nameTextFound = contactPage.nameTextValidated();
		Assert.assertTrue(nameTextFound);		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		TestBase.initialization();		
		 loginPage = new LoginPage();
		 loginCredentialsPage = loginPage.loginButtonClicked();
		 homePage = loginCredentialsPage.login(property.getProperty("username"),property.getProperty("password"));	
		 contactPage = homePage.contactIconClicked();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
