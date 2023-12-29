package com.MyntraProject.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MyntraProject.keywords.Keyword;

public class GiftCardPage {
	private static final Logger LOG = Logger.getLogger(GiftCardPage.class);
	public GiftCardPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	@FindBy(css = "div.occasionspicker-occasionsContainer>div:nth-child(6)")
	public WebElement diwaliComponent;

	public void clickOnDiwali() {
		diwaliComponent.click();

	}

	@FindBy(css = "div.occasionspicker-occasionDivSelected ")
	public WebElement resultDiwaliComponent;

	public void verifyDiwaliCard() {
		String text = resultDiwaliComponent.getText();
		//System.out.println(text);
		LOG.info(text);
		Assert.assertTrue(text.contains("Diwali"));
	}
}
