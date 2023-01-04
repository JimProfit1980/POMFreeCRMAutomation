package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginCredentialsPage extends TestBase{
	
	
	//Page Factory or OR	
	
	@FindBy(name="email")
	WebElement emailInputField;
	
	@FindBy(name="password")
	WebElement passwordInputField;
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement loginSubmitBtn;
	
public HomePage login(String userName,String passWord) throws InterruptedException {	
	emailInputField.sendKeys(userName);
	passwordInputField.sendKeys(passWord);	
	loginSubmitBtn.click();	
	Thread.sleep(4000);
		return new HomePage();
	}

public LoginCredentialsPage() {
	PageFactory.initElements(driver, this);
}



}

	
