package com.crm.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginCredentialsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;

public class NewContactSavedTest extends TestBase{
	ContactPage contactPage;
	NewContactPage newContactPage;
	LoginPage loginPage;
	LoginCredentialsPage loginCredentialsPage;
	HomePage homePage;
	
	
	public NewContactSavedTest() {
		super();
	}
	
//	@Test
//	public void  getNewContactFullName() {
//		return newContactFullNameInputField.getText();
//	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		TestBase.initialization();		
		 loginPage = new LoginPage();
		 loginCredentialsPage = loginPage.loginButtonClicked();
		 homePage = loginCredentialsPage.login(property.getProperty("username"),property.getProperty("password"));	
		 newContactPage = homePage.addContactLinkClicked();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
