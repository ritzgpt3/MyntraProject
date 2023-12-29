package com.MyntraProject.pages;

import org.openqa.selenium.WebElement;
//import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MyntraProject.keywords.Keyword;
import com.MyntraProject.waits.WaitFor;

public class HomePage {
	private static final Logger LOG = Logger.getLogger(HomePage.class);
	
	@FindBy(css = "div.desktop-query>input[placeholder*=\"Search for\"]")
	public WebElement searchComponent;

	public HomePage() {

		PageFactory.initElements(Keyword.getDriver(), this);
	}

	public void enterProductToSearch(CharSequence... productName) {

		searchComponent.sendKeys(productName);
	}

	@FindBy(css = "span.sprites-search")
	public WebElement searchMAgnifierComponent;

	public void clickOnSearchMagnifier() {
		searchMAgnifierComponent.click();
	}

	@FindBy(css = "span[data-reactid*=\"856\"]")
	public WebElement profileIcon;

	public void clickOnProfile() {

		profileIcon.click();
	}

	@FindBy(css = "a.desktop-linkButton")
	public WebElement loginOrSignupButton;

	public void clickOnLoginSignupButton() {

		loginOrSignupButton.click();
	}

	@FindBy(css = "input[autocomplete*=new-password]")
	public WebElement mobileNumberTextField;

	public void enterPhoneNumber(CharSequence... phoneNumber) {

		// waitFor wait = new waitFor();
		mobileNumberTextField.sendKeys(phoneNumber);
	}

	@FindBy(css = "div.submitBottomOption")
	public WebElement continueButton;

	public void clickOnContinueButton() {

		continueButton.click();
	}

	@FindBy(css = "div.notifyText")
	private WebElement errorNotifier;

	public void verifyTextName(String expectedText) {
		// waitFor.m1(errorNotifier);
		String text = (errorNotifier).getText();
		//System.out.println(text);
		LOG.info(text);

		Assert.assertEquals(text, expectedText);
	}

	@FindBy(css = "div[data-reactid*=\"874\"]")
	public WebElement giftCardsOption;

	public void clickOnGiftCards() {
		giftCardsOption.click();
	}

	@FindBy(css = "a.desktop-youtube")
	public WebElement youtubeIcon;

	public void clickOnYoutubeIcon() {
		youtubeIcon.click();
	}

	/**
	 * Below methods are for size guide testcase
	 */

	@FindBy(css = "div.desktop-navLink>a[href=\"/shop/men\"]")
	public WebElement menOption;

	public void clickOnMenOption() {
		menOption.click();
	}

	public void scrollWindowForShirts() {
		Keyword.getDriver().executeScript("window.scrollBy(0,1300)");
	}

	@FindBy(css = "img[src=\"https://assets.myntassets.com/w_163,c_limit,fl_progressive,dpr_2.0/assets/images/2023/11/23/603c4c97-d0e5-419e-811d-9e23765976901700725377118-Shop-By-Category_MP_04.jpg\"]")
	public WebElement shirtOption;

	public void clickOnShirts() {
		WaitFor.waitForElementToBeClickable(shirtOption);
		shirtOption.click();
	}

	@FindBy(css = "a[href=\"https://www.instagram.com/myntra\"]")
	public WebElement instagramIcon;

	public void clickOnInstagramIcon() {
		instagramIcon.click();
	}

	@FindBy(css = "div.xw7yly9>span.x1lliihq")
	public WebElement errorMsg;

	public void getErrorMessage() {
		WaitFor.waitForElementToContainText(errorMsg, "Something went wrong");
		if (errorMsg.isDisplayed()) {
			String errorMessage = errorMsg.getText();
			//System.out.println("Error: " + errorMessage);
			LOG.info("Error: " + errorMessage);
		} else {
			//System.out.println("Successfully clicked on insta icon");
			LOG.info("Successfully clicked on insta icon");
		}
	}

	/**
	 * Interactivity of promotional banners
	 */

	@FindBy(css = "img[src=\"https://assets.myntassets.com/w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2023/12/13/44214372-b4b0-4b63-a1b7-7a48406e8ae41702405945272-HP.png\"]")
	public WebElement promoBanner;

	public void clickOnBanner() {
		promoBanner.click();
	}

	/**
	 * Verify If Blog Content Links Are Accessible
	 */

	@FindBy(css = "a[href=\"http://blog.myntra.com/\"]")
	public WebElement blogLink;

	public void clickOnBlog() {
		blogLink.click();
	}
	
}
