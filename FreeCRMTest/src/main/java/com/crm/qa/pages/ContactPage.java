package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="//div[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//th[text()='Options']")
	WebElement options;
	
	@FindBy(xpath="//th[text()='Name']")
	@CacheLookup 
	WebElement name;
	
	
	
	public boolean nameTextValidated() {
		Actions action = new Actions(driver);
		action.moveToElement(options).pause(1000).build().perform();
		return name.isDisplayed();
	}
	
	public ContactPage() {
		PageFactory.initElements(driver,this);
	}

}
