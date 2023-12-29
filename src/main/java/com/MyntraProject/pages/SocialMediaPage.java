package com.MyntraProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MyntraProject.keywords.Keyword;

public class SocialMediaPage {
	public SocialMediaPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	/*
	 * @FindBy(css = "button#avatar-btn") public WebElement youtubeProfileIcon;
	 * public void clickOnProfileIcon(){ youtubeProfileIcon.click(); }
	 */
	/*
	 * @FindBy(css = "div#items a#endpoint yt-formatted-string.title") public
	 * List<WebElement> youtubeTitles; public List<String> getTextOfYoutubeTitles()
	 * { Keyword keyword = new Keyword(); return keyword.getTexts(youtubeTitles); }
	 * //@FindBy(css = "ytd-guide-section-renderer.style-scope:nth-child(6)")
	 * //@FindBy(css = "div#items a#endpoint yt-formatted-string.title") public
	 * List<WebElement> pageTitle; public void verifyIfYoutubePageHasOpened() throws
	 * InterruptedException{ List<String> text = getTextOfYoutubeTitles();
	 * 
	 * //SoftAssert softly = for (String texts : text) {
	 * System.out.println("Texts: "+texts);
	 * //Assert.assertTrue(texts.contains("YouTube"));
	 * 
	 * } //System.out.println("Assert done");
	 * 
	 * 
	 * }
	 */

	public void verifyIfYoutubePageHasOpened() {
		String text = Keyword.getDriver().getCurrentUrl();
		System.out.println("Youtube link of Myntra: " + text);
		Assert.assertTrue(text.contains("youtube"));
	}

	@FindBy(css = "a[href=\"/accounts/login/?next=%2Fmyntra%2F&source=desktop_nav\"]")
	public WebElement instagramLoginButton;

	public void clickOnInstagramLoginButton() {
		// waitFor.waitForElementToBeClickable(instagramLoginButton);
		instagramLoginButton.click();

	}
}
