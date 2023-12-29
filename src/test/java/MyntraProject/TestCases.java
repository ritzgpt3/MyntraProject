package MyntraProject;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.MyntraProject.keywords.Keyword;
import com.MyntraProject.pages.BlogsPage;
import com.MyntraProject.pages.FaqPage;
import com.MyntraProject.pages.GiftCardPage;
import com.MyntraProject.pages.HomePage;
import com.MyntraProject.pages.ProductPage;
import com.MyntraProject.pages.SearchResultPage;
import com.MyntraProject.pages.SocialMediaPage;

public class TestCases {

	/*
	 * @Test public void m2() { Keyword kw = new Keyword();
	 * 
	 * //kw.clickOn("css", "div.desktop-navLink>a[href*=\"/shop/men\"]");
	 * kw.enterText(Locator.searchComponent, "Levis",Keys.ENTER);
	 * kw.hitKey(KeyEvent.VK_ENTER);
	 * waitFor.numberOfElementsToBeMoreThan(LocatorType.CSS, Locator.PRODUCTtITLE,
	 * 1); List<String> productTitles = kw.getTexts(Locator.PRODUCTtITLE);
	 * 
	 * SoftAssert softly = new SoftAssert(); for (String productTitle :
	 * productTitles) { System.out.println("Checking1: "+productTitle);
	 * softly.assertTrue(productTitles.contains("Levis")); }
	 * 
	 * softly.assertAll(); }
	 * 
	 * @Test public void usingPageObjectModel(){
	 * 
	 * HomePage onHomepage = new HomePage();
	 * onHomepage.enterProductToSearch("Levis", Keys.ENTER); SearchResultPage
	 * resultPage = new SearchResultPage();
	 * resultPage.verifyProductTitlesContains("Levis");
	 * 
	 * }
	 */

	/*
	 * @Test public void verifyErrorNotifierAfterEnteringPhoneNumber() throws
	 * InterruptedException {
	 * 
	 * HomePage homepage = new HomePage(); homepage.clickOnProfile();
	 * homepage.clickOnLoginSignupButton(); homepage.enterPhoneNumber("1111111111");
	 * homepage.clickOnContinueButton();
	 * homepage.verifyTextName("Something went wrong. Please try again later!"); }
	 */
	@Test
	public void verifyIfProductIsGettingAddedToTheCart() {
		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Flats", Keys.ENTER);
		ProductPage pp = new ProductPage();
		pp.clickOnAProduct();
		Keyword keyword = new Keyword();
		keyword.handlingWindows();
		pp.getFlatTitle();
		pp.selectSizeOfTheFlat();
		pp.clickOnAddToCartBtn();
	}

	@Test
	public void verifyTitleOfTheProductIsCorrectInTheCart() {
		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Bella toes", Keys.ENTER);
		ProductPage pp = new ProductPage();
		pp.clickOnAProduct();
		Keyword keyword = new Keyword();
		keyword.handlingWindows();
		pp.getFlatTitle();
		pp.selectSizeOfTheFlat();
		pp.clickOnAddToCartBtn();
		pp.clickOnCartIcon();
		pp.getFlatTitleFromCartAndCompare();
	}

	/**
	 * 
	 * add it to cucumber Passed- done
	 */
	@Test // 1
	public void verifyProductBrandNamesAreAsPerSelectedCheckbox() {

		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Flats", Keys.ENTER);
		SearchResultPage srp = new SearchResultPage();
		srp.clickOnBrandCheckbox();
		srp.verifyProductBrandNamesContainsNameOfTheSelectedBrand("DressBerry");

	}

	/**
	 * add it to cucumber Passed
	 *
	 */
	@Test // 2
	public void verifyPricesOfProductsAreAsPerTheSelectedRange() throws InterruptedException {

		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Sneakers", Keys.ENTER);
		SearchResultPage srp = new SearchResultPage();
		// srp.scrollWindowForSneakers();
		// Thread.sleep(2000);
		srp.clickOnPriceCheckbox();
		srp.verifyProductPricesAreInExpectedRange();
	}

	/**
	 * add it to cucumber Passed
	 */
	@Test // 3
	public void VerifyPresenceOfProductDeatilsForASingleProduct() throws InterruptedException {

		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Flats", Keys.ENTER);
		SearchResultPage srp = new SearchResultPage();
		// srp.clickOnBrandCheckbox();
		Thread.sleep(2000);
		srp.clickOnAProduct();
		Keyword keyword = new Keyword();
		keyword.handlingWindows();
		ProductPage pp = new ProductPage();
		pp.getProductTitle();
		pp.verifyIfProductHasTheDescription();
	}

	/**
	 * add it to cucumber Passed
	 */
	@Test // 4
	public void verifyGiftCardAppearanceAsPerSelectedTopic() throws InterruptedException {
		HomePage onHomepage = new HomePage();
		onHomepage.clickOnProfile();
		onHomepage.clickOnGiftCards();
		GiftCardPage gcp = new GiftCardPage();
		gcp.clickOnDiwali();
		Thread.sleep(2000);
		gcp.verifyDiwaliCard();

	}

	/**
	 * add it to cucumber- DONE Passed
	 */

	@Test // 5
	public void verifyIfItsRedirectingToYoutubePageAfterClickingOnYoutubeIcon() {
		Keyword keyword = new Keyword();
		keyword.scrollWindow();
		HomePage homepage = new HomePage();
		homepage.clickOnYoutubeIcon();
		SocialMediaPage smp = new SocialMediaPage();
		smp.verifyIfYoutubePageHasOpened();
	}

	/**
	 * 
	 * Add it to cucumber failing
	 */
	@Test // 6
	public void verifyInstagramPageInteraction() {
		Keyword keyword = new Keyword();
		keyword.scrollWindow();
		HomePage homepage = new HomePage();
		homepage.clickOnInstagramIcon();
		homepage.getErrorMessage();
		// SocialMediaPage smp = new SocialMediaPage();
		// smp.clickOnInstagramLoginButton();
	}

	/**
	 * Size guide test case Passed
	 */
	@Test // 7
	public void verifyIfAProductHasAppropriateSizeGuide() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.clickOnMenOption();
		homepage.scrollWindowForShirts();
		homepage.clickOnShirts();
		SearchResultPage srp = new SearchResultPage();
		Thread.sleep(2000);
		srp.clickOnProductForSizeGuide();
		Keyword keyword = new Keyword();
		keyword.handlingWindows();
		ProductPage pp = new ProductPage();
		pp.clickOnSizeChart();
		pp.getSizeInformation();
	}

	/**
	 * add it to cucumber- DONE Passed
	 */
	@Test // 8
	public void verifyIfFaqHasRelevantPhonpeQuestions() {
		Keyword keyword = new Keyword();
		keyword.scrollWindow();
		FaqPage fp = new FaqPage();
		fp.clickOnFaqOption();
		fp.verifyIfQuestionsHasPhonePeWord();
	}

	/**
	 * Passed
	 */
	@Test // 9
	public void verifyInteractivityOfPromotionalBanners() {
		HomePage hp = new HomePage();
		hp.clickOnBanner();
		SearchResultPage srp = new SearchResultPage();
		srp.getResultPageTextOfPromoBanner();
	}

	/**
	 * Passed
	 */
	@Test // 10
	public void VerifyFunctionalityOfBreadCrumbNavigation() {
		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Flats", Keys.ENTER);
		SearchResultPage srp = new SearchResultPage();
		srp.clickOnAProduct();
		Keyword keyword = new Keyword();
		keyword.handlingWindows();
		ProductPage pp = new ProductPage();
		pp.clickOnBreadCrumbWomenFootwearLink();
		srp.clickOnBreadCrumbGeneralFootwearLink();
		srp.clickOnBreadCrumbHomeLink();
	}

	/**
	 * Passed
	 */
	@Test // 11
	public void verifyIfBlogContentLinksAreAccessible() {
		Keyword keyword = new Keyword();
		keyword.scrollWindow();
		HomePage homepage = new HomePage();
		homepage.clickOnBlog();
		BlogsPage bp = new BlogsPage();
		bp.scrollBlog();
		bp.clickOnABlogToVerifyItsAccessible();
	}

	/**
	 * Passed
	 */
	@Test // 12
	public void verifyLowToHighPriceSelectionFunctionality() {
		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Jordan", Keys.ENTER);
		SearchResultPage srp = new SearchResultPage();
		srp.hoverOnRecommendations();
		srp.clickOnLowToHighOption();
		srp.verifyAllPricesAreInLowToHighOrder();
	}
}
