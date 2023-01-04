package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewContactSavedPage extends TestBase{
	
	public NewContactSavedPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement newContactFullNameInputField;
	
	public String getNewContactFullName() {
		return newContactFullNameInputField.getText();
	}

}
