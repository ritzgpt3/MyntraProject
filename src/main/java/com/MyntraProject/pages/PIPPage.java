package com.MyntraProject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.MyntraProject.keywords.Keyword;
import com.MyntraProject.pages.PIPPage;
import com.MyntraProject.waits.WaitFor;

public class PIPPage {
	public PIPPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	@FindBy(css = "div.desktop-query>input[placeholder*='Search for']")
	// @FindBy(css = "div.desktop-query>input[placeholder*='Search for']")
	public WebElement searchComponent;

	public void enterProductToSearch(CharSequence... productName) {
		searchComponent.sendKeys(productName);
	}

	@FindBy(css = "a.desktop-submit>span.myntraweb-sprite")
	public WebElement magnifierIcon;

	public void clickOnMagnifier() {
		magnifierIcon.click();
	}

	@FindBy(css = "h3.product-brand")
	public List<WebElement> productTitles;
	// private By productTitle = By.cssSelector("h3.product-brand");

	public List<String> getProductTitles() {
		Keyword keyword = new Keyword();
		keyword.getTexts(productTitles);
		return keyword.getTexts(productTitles);

	}

	public void verifyProductTitlesContains(String expectedText) {
		List<String> titles = getProductTitles();
		SoftAssert softly = new SoftAssert();
		for (String title : titles) {
			System.out.println("Checking : " + title);
			softly.assertTrue(title.contains(expectedText));

		}
		softly.assertAll();
	}

//2-------------------------------------------------------------------------------------------
	@FindBy(css = "li.product-base:first-child")
	public WebElement FirstProduct;

	public void clickOnProduct() {
		// SearchResultPage resultPage = new SearchResultPage();
		// resultPage.waitForFirstProduct();
		FirstProduct.click();

	}

	@FindBy(css = "div.size-buttons-tipAndBtnContainer:first-child")
	public WebElement clickOnSize;
	private By clickOnTshirtProductWait = By.cssSelector("div.size-buttons-tipAndBtnContainer:first-child");

	public void clickOnSizeOfTshirt() {
		Keyword keyword = new Keyword();
		PIPPage pp = new PIPPage();
		keyword.switchToWindowByTitle(
				"Buy Roadster Women Green Printed Boxy Fit Longline T Shirt  - Tshirts for Women 10968502 | Myntra");
		pp.elementToBeCliackableTshirtSizeWait();
		clickOnSize.click();

	}

	public void elementToBeCliackableTshirtSizeWait() {
		WaitFor wait = new WaitFor();
		WaitFor.waitelementToBeClickable(clickOnTshirtProductWait);
	}

	@FindBy(css = "div.pdp-add-to-bag ")
	public WebElement clickOnAddToCartTshirtProduct;

	public void clickOnAddToCartTshirtProduct() {
		clickOnAddToCartTshirtProduct.click();
	}

	private By clickOnGoToCartTshirtProductWait1 = By
			.cssSelector("div.pdp-action-container>a[href=\"/checkout/cart\"]");

	public void elementToBeCliackableclickOnGoToCartTshirtProduct() {
		WaitFor wait = new WaitFor();
		WaitFor.waitelementToBeClickable(clickOnGoToCartTshirtProductWait1);

	}

	private By clickOnGoToCartTshirtProductWait = By.cssSelector("div.pdp-action-container>a[href=\"/checkout/cart\"]");

	public void elementToBeCliackableclickOnGoToCartTshirtProduct1() {
		WaitFor wait = new WaitFor();
		WaitFor.waitelementToBeClickable(clickOnGoToCartTshirtProductWait);

	}

	@FindBy(css = "div.pdp-action-container>a[href=\"/checkout/cart\"]")
	public WebElement clickOnGoToCartTshirtProduct;

	public void clickOnGoToCartTshirtProduct() {
		PIPPage pp = new PIPPage();
		pp.elementToBeCliackableclickOnGoToCartTshirtProduct1();
		// resultPage.elementToBeCliackableclickOnGoToCartTshirtProduct();
		clickOnGoToCartTshirtProduct.click();
	}

	@FindBy(css = "a.itemContainer-base-itemLink")
	public WebElement productInBag;

	public void verifyShoppingBagContainsMaxBrandTshirt(String expectedText) {
		Keyword keyword = new Keyword();
		String title = keyword.getText(productInBag);
		SoftAssert softly = new SoftAssert();
		softly.assertTrue(title.contains(expectedText), title + "'");
		softly.assertAll();
	}

//3-----------------------------------------------------------------------------------------------------
	@FindBy(css = "input[placeholder=\"Enter pincode\"]")
	public WebElement deliveryOptions;

	public void enterInvalidPinCode() {
		Keyword keyword = new Keyword();
		keyword.switchToWindowByTitle(
				"Buy Roadster Women Green Printed Boxy Fit Longline T Shirt  - Tshirts for Women 10968502 | Myntra");
		PIPPage pp = new PIPPage();
		pp.presentToBeElementdeliveryOptionsWait();
		deliveryOptions.sendKeys("44444444");

	}

	private By deliveryOptionsWait = By.cssSelector("input[placeholder=\"Enter pincode\"]");

	public void presentToBeElementdeliveryOptionsWait() {
		WaitFor wait = new WaitFor();
		WaitFor.waitElementToBePresent(deliveryOptionsWait);
	}

	@FindBy(css = "input[value=\"Check\"]")
	public WebElement check;

	public void clickOnCheck() {
		check.click();
	}

	@FindBy(css = "p.pincode-error")
	public WebElement deliveryOptionsErrorMessageText;

	public void verifyDeliveryOptionsDisplayErrorMessageForInvalidInput(String expectedText) {
		PIPPage pp = new PIPPage();
		pp.clickOnCheckWait();
		Keyword keyword = new Keyword();
		String title = keyword.getText(deliveryOptionsErrorMessageText);
		SoftAssert softly = new SoftAssert();
		softly.assertTrue(title.contains(expectedText), title + "'");
		softly.assertAll();
	}

	private By checkWait = By.cssSelector("p.pincode-error");

	public void clickOnCheckWait() {
		WaitFor wait = new WaitFor();
		WaitFor.waitElementToBePresent(checkWait);
	}

//4-----------------------------------------------------------------------------------------------------------
	private By brandCheckBox1Wait = By.cssSelector("input[value=\"Fastrack\"]+span.brand-num");

	public void brandCheckBox1Wait() {
		WaitFor wait = new WaitFor();
		WaitFor.waitElementToBePresent(brandCheckBox1Wait);
	}

	@FindBy(css = "input[value=\"Fastrack\"]+span.brand-num")
	public WebElement brandCheckBox1;

	public void verifyBrandCheckBox1() {
		brandCheckBox1.click();
		PIPPage pp = new PIPPage();
		pp.brandCheckBox1Wait();
	}

//5-------------------------------------------------------------------------------------------------------
	@FindBy(css = "h4.pincode-serviceabilityTitle")
	public WebElement deliveryOptionsText;
	PIPPage pp = new PIPPage();

	public void verifyDeliveryAvailableOnEnteredPincode(String expectedText) {
		Keyword keyword = new Keyword();
		keyword.switchToWindowByTitle(
				"Buy Roadster Women Green Printed Boxy Fit Longline T Shirt  - Tshirts for Women 10968502 | Myntra");
		// keyword.switchToWindowByGetCurrentUrl("https://www.myntra.com/sarees/kalini/kalini-ethnic-motif-woven-design-zari-kanjeevaram-saree/22536178/buy");

		pp.enterValidPinCode();
		pp.clickOnCheck();
		String title = keyword.getText(deliveryOptionsText);
		SoftAssert softly = new SoftAssert();
		softly.assertTrue(title.contains(expectedText), title + "'");
		softly.assertAll();
	}

	public void enterValidPinCode() {
		Keyword keyword = new Keyword();
		keyword.switchToWindowByTitle(
				"Buy Roadster Women Green Printed Boxy Fit Longline T Shirt  - Tshirts for Women 10968502 | Myntra");

		pp.presentToBeElementdeliveryOptionsWait();
		deliveryOptions.sendKeys("421302");

	}

//6-------------------------------------------------------------------------------------------------
	@FindBy(css = "a[href=\"/checkout/cart\"]>span.desktop-userTitle")
	public WebElement shoppingBag;

	public void clickOnShoppingBag() {
		// Keyword keyword = new Keyword();
		shoppingBag.click();
	}

	@FindBy(css = "a.itemContainer-base-itemLink")
	public WebElement addedProduct;

	public void verifyShoppingBagContains(String expectedText) {
		Keyword keyword = new Keyword();
		String title = keyword.getText(addedProduct);
		SoftAssert softly = new SoftAssert();
		softly.assertTrue(title.contains(expectedText), title + "'");
		softly.assertAll();
	}

	@FindBy(css = "div.pdp-add-to-bag")

	public WebElement addToCartButton;
	private By waitaddToCartButton = By.cssSelector("div.pdp-add-to-bag");

	public void waitAddToCart() {
		WaitFor wait = new WaitFor();
		WaitFor.waitelementToBeClickable(waitaddToCartButton);
	}

	public void clickOnAddToCart() {
		Keyword keyword = new Keyword();
		keyword.switchToWindowByTitle(
				"Buy Saree Mall Black Floral Linen Blend Banarasi Saree  - Sarees for Women 16287682 | Myntra");
		PIPPage pp = new PIPPage();
		pp.waitAddToCart();
		addToCartButton.click();
	}

//8----------------------------------------------------------------------------------------------------
	@FindBy(css = "a[href=\"/checkout/cart\"]>span[class=\"desktop-userTitle\"]")
	public WebElement shoppingBagIcon;

	public void clickOnshoppingBag() {
		// sKeyword keyword = new Keyword();
		// keyword.clickOn(shoppingBagIcon);
		shoppingBag.click();
	}

	@FindBy(css = "div.emptyCart-base-emptyDesc")
	public WebElement shoppingCartEmptyMessage;

	public void verifyShoppingBagContainsErrorMsg(String expectedText) {
		Keyword keyword = new Keyword();
		// HomePage homepage = new HomePage();
		PIPPage pp = new PIPPage();
		pp.elementToBePresentShoppingCartEmptyMessageWait();
		String title = keyword.getText(shoppingCartEmptyMessage);
		SoftAssert softly = new SoftAssert();
		softly.assertTrue(title.contains(expectedText), title + "'");
		softly.assertAll();
	}

	private By shoppingCartEmptyMessageWait = By.cssSelector("div.emptyCart-base-emptyDesc");

	public void elementToBePresentShoppingCartEmptyMessageWait() {
		WaitFor wait = new WaitFor();
		WaitFor.waitElementToBePresent(shoppingCartEmptyMessageWait);
	}
}
