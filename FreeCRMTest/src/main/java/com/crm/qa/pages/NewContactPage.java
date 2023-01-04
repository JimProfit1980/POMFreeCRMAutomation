package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class NewContactPage extends TestBase {
	
	@FindBy(name="first_name")
	WebElement firstNameInputField;
	
	@FindBy(name="last_name")
	WebElement lastNameInputField;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement userNameEmailAddress;
	
	@FindBy(xpath="//div[@name='company']/input")
	WebElement companyName;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement cancelNewContactButton;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveNewContactButton;
	
	private String fullName = "";
	
	public NewContactSavedPage enterNewContactDetailsIn() throws InterruptedException {	
		lastNameInputField.sendKeys(TestUtil.createLastName());
		firstNameInputField.sendKeys(TestUtil.createFirstName());
		userNameEmailAddress.sendKeys(TestUtil.createEmailAddress());
		companyName.sendKeys(TestUtil.getCompanyName());
		setFullName();
		Thread.sleep(1000);
		saveNewContactButton.click();
		Thread.sleep(3000);
		return new NewContactSavedPage();
	}
	
	public NewContactSavedPage enterNewContactDetailsIn(String fName,String lName,String company,String emailAddress) throws InterruptedException {	
		lastNameInputField.sendKeys(lName);
		firstNameInputField.sendKeys(fName);
		userNameEmailAddress.sendKeys(emailAddress);
		companyName.sendKeys(company);
		setFullName();
		Thread.sleep(1000);
		saveNewContactButton.click();
		Thread.sleep(3000);
		return new NewContactSavedPage();
	}
	
	public void setFullName()
	{
		fullName = firstNameInputField.getAttribute("value") + " " + lastNameInputField.getAttribute("value");		
	}
	
	public String getFullName()
	{		
		return fullName;
	}
	
	
	public NewContactPage() {
		PageFactory.initElements(driver,this);
	}

}
