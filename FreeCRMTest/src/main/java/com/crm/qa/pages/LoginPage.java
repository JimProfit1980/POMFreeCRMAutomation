package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or OR
	@FindBy(xpath="//div[@class='rd-navbar-brand']/a[@href='https://freecrm.com']")
	WebElement crmLogoImage;
	
	@FindBy(xpath="//*[text()='Log In']")
	WebElement loginBtn;	
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;	
	
	public boolean isCrmLogoDisplayed() {
		return crmLogoImage.isDisplayed();
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public LoginCredentialsPage loginButtonClicked() throws InterruptedException{		
		loginBtn.click();
		Thread.sleep(4000);
		
        return new LoginCredentialsPage();
	}
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

}
