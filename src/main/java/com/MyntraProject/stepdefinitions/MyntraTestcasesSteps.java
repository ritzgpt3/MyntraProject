package com.MyntraProject.stepdefinitions;

import org.openqa.selenium.Keys;

import com.MyntraProject.keywords.Keyword;
import com.MyntraProject.pages.BlogsPage;
import com.MyntraProject.pages.FaqPage;
import com.MyntraProject.pages.GiftCardPage;
import com.MyntraProject.pages.HomePage;
import com.MyntraProject.pages.PIPPage;
import com.MyntraProject.pages.ProductPage;
import com.MyntraProject.pages.SearchResultPage;
import com.MyntraProject.pages.SocialMediaPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyntraTestcasesSteps {
	// Scenario1: Verify when user selects particular brand name then all results
	// must appear of that brand.
	@Given("Enter Flats in search component")
	public void enterProduct() {
		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Flats", Keys.ENTER);
	}

	@When("User clicks on a particular brand checkbox")
	public void clickOnBrandCheckbox() {
		SearchResultPage srp = new SearchResultPage();
		srp.clickOnBrandCheckbox();
	}

	@Then("All results populated must be of selected brand")
	public void productResulta() {
		SearchResultPage srp = new SearchResultPage();
		srp.verifyProductBrandNamesContainsNameOfTheSelectedBrand("DressBerry");
	}

	// Scenario2: Verify when user clicks on price range checkbox then populated all
	// results must be in selected price range
	@Given("Search for Sneakers")
	public void searchProduct() {
		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Sneakers", Keys.ENTER);
	}

	@When("User clicks on price range checkbox")
	public void clickOnPriceCheckbox() {
		SearchResultPage srp = new SearchResultPage();
		srp.clickOnPriceCheckbox();
	}

	@Then("All results populated must be in selected price range")
	public void verifyProductsAreInExpectedPRiceRange() {
		SearchResultPage srp = new SearchResultPage();
		srp.verifyProductPricesAreInExpectedRange();
	}

	// Scenario3: Verify when user selects a product then that product should have
	// product details

	@When("User selects a product")
	public void selectAProduct() {
		SearchResultPage srp = new SearchResultPage();
		srp.clickOnAProduct();
	}

	@Then("Product must contain product details")
	public void verifyIfProductHasTheDescription() {
		Keyword keyword = new Keyword();
		keyword.handlingWindows();
		ProductPage pp = new ProductPage();
		pp.getProductTitle();
		pp.verifyIfProductHasTheDescription();
	}

	// Scenario4: Verify when user clicks on giftcard and select an occation then
	// giftcard must appear related to selected occasion
	@Given("Click on profile icon and select giftcard option")
	public void selectGiftcardOption() {
		HomePage onHomepage = new HomePage();
		onHomepage.clickOnProfile();
		onHomepage.clickOnGiftCards();
	}

	@When("User select an occasion")
	public void selectAnOccation() {
		GiftCardPage gcp = new GiftCardPage();
		gcp.clickOnDiwali();
	}

	@Then("Giftcard should appear related to the selected occasion")
	public void verifyNameIsAsPerTheSelectedOccasion() throws InterruptedException {
		Thread.sleep(2000);
		GiftCardPage gcp = new GiftCardPage();
		gcp.verifyDiwaliCard();
	}

	// Scenario5: Verify when user clicks on Youtube icon then it must redirect the
	// page to youtube website.
	@Given("Open myntra site and scroll down")
	public void openSiteAndScrollDown() {
		Keyword keyword = new Keyword();
		keyword.scrollWindow();
	}

	@When("User clicks on youtube icon")
	public void clickOnYoutubeIcon() {
		HomePage homepage = new HomePage();
		homepage.clickOnYoutubeIcon();
	}

	@Then("Verify if it is YouTube website")
	public void verifyIfYoutubehasOpened() {
		SocialMediaPage smp = new SocialMediaPage();
		smp.verifyIfYoutubePageHasOpened();
	}
	// Scenario6: Verify when user clicks on instagram icon then user should be able
	// to interact with instagram Page

	@When("User clicks on instagram icon")
	public void clickOnInstaIcon() {
		HomePage homepage = new HomePage();
		homepage.clickOnInstagramIcon();
	}

	@Then("User should be able to interact with instagram Page")
	public void verifyIfInstagramPageHasOpened() {
		HomePage homepage = new HomePage();
		homepage.getErrorMessage();
		SocialMediaPage smp = new SocialMediaPage();
		smp.clickOnInstagramLoginButton();
	}

	// Scenario7: Verify when users selects a product then that product must have
	// appropriate size guide chart
	@Given("Click on men shirts")
	public void clickOnMenShirts() {
		HomePage homepage = new HomePage();
		homepage.clickOnMenOption();
		homepage.scrollWindowForShirts();
		homepage.clickOnShirts();
	}

	@When("User selects a shirt product")
	public void selectProduct() {
		SearchResultPage srp = new SearchResultPage();
		srp.clickOnProductForSizeGuide();
	}

	@Then("Product must have appropriate size guide chart")
	public void verifyIfProductHasSizeGuideChart() {
		Keyword keyword = new Keyword();
		keyword.handlingWindows();
		ProductPage pp = new ProductPage();
		pp.clickOnSizeChart();
		pp.getSizeInformation();
	}

	// Scenario8: Verify when user checks PhonePe faqs then questions must be
	// relevant to PhonePe
	@Given("Open myntra and scroll to FAQ option")
	public void scrollToFaqSection() {
		Keyword keyword = new Keyword();
		keyword.scrollWindow();
	}

	@When("User checks PhonePe faqs")
	public void clickOnFaq() {
		FaqPage fp = new FaqPage();
		fp.clickOnFaqOption();
	}

	@Then("Questions must be relevant to PhonePe")
	public void verifyIfQuestionsAreRelevant() {
		FaqPage fp = new FaqPage();
		fp.verifyIfQuestionsHasPhonePeWord();
	}

	// Scenario9: Verify when user clicks on promotional banner then it should
	// redirect to product results
	@Given("Open myntra")
	public void openMyntra() {
		HomePage hp = new HomePage();
	}

	@When("User clicks on promotional banner")
	public void clickOnOromotionalBanner() {
		HomePage hp = new HomePage();
		hp.clickOnBanner();
	}

	@Then("It should redirect to product results")
	public void verifyPageHasRedirectedToProductResults() {
		SearchResultPage srp = new SearchResultPage();
		srp.getResultPageTextOfPromoBanner();
	}

	// Scenario10: Verify the functionality of BreadCrumb Navigation

	@Then("All links in breadcrumbs must be interactable")
	public void verifyAllLinksAreInteractable() {
		Keyword keyword = new Keyword();
		keyword.handlingWindows();
		ProductPage pp = new ProductPage();
		pp.clickOnBreadCrumbWomenFootwearLink();
		SearchResultPage srp = new SearchResultPage();
		srp.clickOnBreadCrumbGeneralFootwearLink();
		srp.clickOnBreadCrumbHomeLink();
	}

	// Scenario11: Verify when user cliks on a blog content then it should be
	// interactable
	@Given("Open myntra and select blog option")
	public void clickOnBlogOption() {
		Keyword keyword = new Keyword();
		keyword.scrollWindow();
	}

	@When("User clicks on a blog content")
	public void clickOnABlogContent() {
		HomePage homepage = new HomePage();
		homepage.clickOnBlog();
	}

	@Then("Blog content should be interactable")
	public void VerifyIfBlogContentISInteractable() {
		BlogsPage bp = new BlogsPage();
		bp.scrollBlog();
		bp.clickOnABlogToVerifyItsAccessible();
	}

	// Scenario12: Verify Low To High Price Selection Functionality
	@Given("Open myntra and search for Jordan")
	public void searchForJordan() {
		HomePage onHomepage = new HomePage();
		onHomepage.enterProductToSearch("Jordan", Keys.ENTER);
	}

	@When("User clicks selects low to high price option from dropdown")
	public void selectLowToHighPriceOption() {
		SearchResultPage srp = new SearchResultPage();
		srp.hoverOnRecommendations();
		srp.clickOnLowToHighOption();
	}

	@Then("Populated products should be in order of low to high price range")
	public void verifyProductsAreInLowToHighPriceRange() {
		SearchResultPage srp = new SearchResultPage();
		srp.verifyAllPricesAreInLowToHighOrder();
	}

	// --------------------------------------------------------------------------------------------------------------------------------

	@Given("Enter Levis in Search Component")
	public void enter_levis_in_search_component() {
		PIPPage pp = new PIPPage();
		pp.enterProductToSearch("Levis");
	}

	@When("User clicks on search magnifier")
	public void clickOnMagnifier() {
		PIPPage pp = new PIPPage();
		pp.clickOnMagnifier();

	}

	@Then("All results populated must contain word Levis in it.")
	public void assertResults() {
		PIPPage pp = new PIPPage();
		pp.verifyProductTitlesContains("Levis");
	}

	@Given("Enter Women T-Shirt in Search Component")
	public void enter_t_shirt_in_search_component() {
		PIPPage pp = new PIPPage();
		pp.enterProductToSearch("Women T-shirt");
	}

	@Then("The Result Shopping Bag Contains Tshirt")
	public void the_result_shopping_bag_contains_max_brand_tshirt() {

		PIPPage pp = new PIPPage();
		// resultPage.clickOnMaxBrandTshirt();
		pp.clickOnProduct();

		pp.elementToBeCliackableTshirtSizeWait();
		pp.clickOnSizeOfTshirt();
		pp.clickOnAddToCartTshirtProduct();

		pp.clickOnGoToCartTshirtProduct();
		pp.verifyShoppingBagContainsMaxBrandTshirt("T-shirt");
	}

	@When("User Enters Pincode")
	public void userEntersPincode() {
		PIPPage pp = new PIPPage();
		// SearchResultPage resultPage = new SearchResultPage();
		pp.clickOnMagnifier();
		pp.clickOnProduct();
		pp.enterInvalidPinCode();
	}

	@Then("The Result Display Error Message For Invalid Input.")
	public void the_result_display_error_message_for_invalid_input() {
		PIPPage pp = new PIPPage();
		pp.clickOnCheck();
		pp.verifyDeliveryOptionsDisplayErrorMessageForInvalidInput("Unfortunately we do not ship to your pincode");
	}

	@Given("Enter Watches in Search Field")
	public void enter_watches_in_search_Field() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Watches");
	}

	@When("Click On Watch Product")
	public void click_on_watch_product() {
		PIPPage pp = new PIPPage();
		pp.clickOnMagnifier();
		Keyword keyword = new Keyword();
		keyword.maximizeBrowser();
	}

	@Then("The Result Watch Brand Should Be Fastrack")
	public void the_result_watch_brand_should_be_fastrack() throws InterruptedException {
		PIPPage pp = new PIPPage();
		pp.verifyBrandCheckBox1();
		Thread.sleep(2000);
		pp.verifyProductTitlesContains("Fastrack");
	}

	@When("click Women T-Shirt Product")
	public void click_on_saree_product() {
		PIPPage pp = new PIPPage();
		pp.clickOnMagnifier();
		pp.clickOnProduct();
	}

	@Then("The Result Display Delievery Date and time Message For Valid Input")
	public void the_result_display__message_for_valid_input() {
		PIPPage pp = new PIPPage();
		pp.verifyDeliveryAvailableOnEnteredPincode("Get it by ");

	}

	@Given("Enter Product Name in Search Component")
	public void enter_product_name_in_search_component() {
		PIPPage pp = new PIPPage();
		pp.enterProductToSearch("Saree");
		pp.clickOnMagnifier();
		Keyword keyword = new Keyword();
		keyword.maximizeBrowser();
	}

	@When("Click On selected Product")
	public void click_on_selected_product() {
		PIPPage pp = new PIPPage();
		pp.clickOnProduct();
	}

	@Then("The Result Display selected product added in Shopping Bag")
	public void the_result_display_selected_product_added_in_shopping_bag() {
		PIPPage pp = new PIPPage();
		pp.clickOnAddToCart();
		pp.clickOnShoppingBag();
		pp.verifyShoppingBagContains("Black Floral Linen Blend Banarasi Saree");

	}

	@Given("Select Shopping Bag")
	public void select_shopping_bag() {
		PIPPage pp = new PIPPage();
	}

	@When("Click On shopping Bag")
	public void click_on_shopping_bag() {
		PIPPage pp = new PIPPage();
		pp.clickOnshoppingBag();
	}

	@Then("The Result Display Error Message If Cart Is Empty")
	public void the_result_display_error_message_if_cart_is_empty() {
		PIPPage pp = new PIPPage();
		pp.verifyShoppingBagContains("There is nothing in your bag. Let's add some items.");
	}
}
