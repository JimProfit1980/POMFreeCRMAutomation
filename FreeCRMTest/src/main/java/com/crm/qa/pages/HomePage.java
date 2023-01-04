package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//div[text()='Contacts activity stream']")
	WebElement homePageImage;	
	
	@FindBy(className="user-display")
	WebElement userName;
	
	@FindBy(xpath="//*[contains(@class,'home icon')]")
	WebElement homeIcon;
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contactIcon;
	
	@FindBy(xpath="//a[@href='/contacts']/..//i[@class='plus inverted icon']")
	WebElement addContactLink;
	
	
	public boolean userNameValidated() {
		return userName.isDisplayed();
	}
	
	public boolean homeHeaderImageValidated() {
		return homePageImage.isDisplayed();
	}	
	
	public ContactPage contactIconClicked() {
		Actions action = new Actions(driver);
		action.moveToElement(homeIcon).pause(1000).moveToElement(contactIcon).click().build().perform();
		//driver.switchTo().window(driver.getWindowHandle());
		return new ContactPage();
	}
	
	public NewContactPage addContactLinkClicked() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(homeIcon).pause(1000).moveToElement(addContactLink).click().build().perform();
		Thread.sleep(1000);
		//driver.switchTo().window(driver.getWindowHandle());
		return new NewContactPage();
	}
	
	
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
}
