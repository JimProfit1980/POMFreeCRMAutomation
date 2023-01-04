package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginCredentialsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.pages.NewContactSavedPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase {
	
	ContactPage contactPage;
	NewContactPage newContactPage;
	NewContactSavedPage newContactSavedPage;
	LoginPage loginPage;
	LoginCredentialsPage loginCredentialsPage;
	HomePage homePage;
	
	public NewContactPageTest() {
		super();
	}
	
	
	
	
	@Test(dataProvider="getTestData")
	public void addNewContact(String firstname,String lastname,String company,String email) throws InterruptedException {
		newContactSavedPage = newContactPage.enterNewContactDetailsIn(firstname,lastname,company,email);
		System.out.println("Fullname: " + newContactPage.getFullName()); 
		Assert.assertTrue(newContactSavedPage.getNewContactFullName().contains(newContactPage.getFullName()));	
	}
	
	@Test
	public void addNewContacts() throws InterruptedException {
		newContactSavedPage = newContactPage.enterNewContactDetailsIn();
		System.out.println("Fullname: " + newContactPage.getFullName()); 
		Assert.assertTrue(newContactSavedPage.getNewContactFullName().contains(newContactPage.getFullName()));	
	}
	
	@DataProvider
	public Object[][] getTestData() throws EncryptedDocumentException, IOException {
		Object data[][] = TestUtil.getTestData(0);
		return data;
	}
	
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
