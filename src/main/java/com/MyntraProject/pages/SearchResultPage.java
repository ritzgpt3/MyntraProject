package com.MyntraProject.pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.MyntraProject.keywords.Keyword;
import com.MyntraProject.waits.WaitFor;

public class SearchResultPage {
	private static final Logger LOG = Logger.getLogger(SearchResultPage.class);
	public SearchResultPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	public void scrollWindowForSneakers() {
		Keyword.getDriver().executeScript("window.scrollBy(0,500)");
	}

	@FindBy(css = "ul.brand-list>li:first-child")
	// @FindBy(css = "label.vertical-filters-label>input[value*=\"Anouk\"]")
	public WebElement checkboxComponent;

	public void clickOnBrandCheckbox() {
		// waitFor.waitForElementToBeClickable(checkboxComponents);;
		checkboxComponent.click();
	}

	@FindBy(css = "div.product-productMetaInfo>h3.product-brand")
	public List<WebElement> productBrandNames;
	private By productBrandName = By.cssSelector("div.product-productMetaInfo>h3.product-brand");

	public List<String> getProductBrandNames() {
		WaitFor.numberOfElementsToBeMoreThan(productBrandName, 1);
		Keyword.getDriver().navigate().refresh();
		Keyword keyword = new Keyword();
		return keyword.getTexts(productBrandNames);
	}

	public void verifyProductBrandNamesContainsNameOfTheSelectedBrand(String expectedText) {
		List<String> productBrandNames1 = getProductBrandNames();

		SoftAssert softly = new SoftAssert();
		for (String productBrandName : productBrandNames1) {
			//System.out.println("Checking: " + productBrandName);
			LOG.info("Checking: " + productBrandName);
			softly.assertTrue(productBrandName.contains(expectedText));
		}
		softly.assertAll();
	}

	/**
	 * Below methods are related to the verification of products price whether they
	 * are between selected price range
	 * 
	 * @author pradnyaogale
	 */
	@FindBy(css = "ul.price-list>li:first-child")
	// @FindBy(css = "label.common-customRadio>input[value*=\"women,men women\"]")
	public WebElement productPriceCheckbox;

	public void clickOnPriceCheckbox() {
		// waitFor.waitForElementToBeClickable(productPriceCheckbox);
		productPriceCheckbox.click();
		// System.out.println("Clicking done");
	}

	@FindBy(css = "span.product-discountedPrice")
	public List<WebElement> productPrices;

	private By productPrice = By.cssSelector("span.product-discountedPrice");

	public List<String> getProductPrices() {
		// waitFor.numberOfElementsToBeMoreThan(productPrice, 1);

		Keyword keyword = new Keyword();
		return keyword.getTexts(productPrices);
	}

	public void verifyProductPricesAreInExpectedRange() {
		List<String> productPricesStr = getProductPrices();
		List<String> rs = new ArrayList<>();
		for (String productPriceStr : productPricesStr) {
			String[] parts = productPriceStr.split(" ");
			if (parts.length > 0) {
				String currency = parts[1];
				rs.add(currency);
			}
		}
		String minPrice = "249.0";
		String maxPrice = "6912.0";
		double minPrice1 = Double.parseDouble(minPrice);
		double maxPrice1 = Double.parseDouble(maxPrice);

		List<Double> productPrices = new ArrayList<Double>();
		for (String priceStr : rs) {
			productPrices.add(Double.parseDouble(priceStr));
			// System.out.println(productPrices);
		}
		assertTrue(areAllPricesInRange(productPrices, minPrice1, maxPrice1));
		//System.out.println("All products are in selected price range");
		LOG.info("All products are in selected price range");
	}

	private boolean areAllPricesInRange(List<Double> prices, double min, double max) {
		for (Double price : prices) {
			if (price < min || price > max) {
				return false;
			}
		}
		return true;
	}

	@FindBy(css = "ul.results-base li.product-base:first-child")
	public WebElement productComponent;

	public void clickOnAProduct() {

		productComponent.click();
	}

	/**
	 * Below methods are for size guide testcase
	 */

	// @FindBy(css =
	// "li.product-base>a[href=\"shirts/h%26m/hm-regular-fit-easy-iron-shirt/24697414/buy\"]")
	// @FindBy(css =
	// "https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/24221860/2023/7/27/a481bb6d-b444-46db-a41c-e9d2962957ca1690442692760RegularFitOvershirt1.jpg
	// ")
	/*
	 * public By waitToClickProduct; public void waitToClickProduct() {
	 * //waitFor.waitForElementToBePresentInDom(clickProduct);
	 * waitFor.waitForElementToBePresent(waitToClickProduct); }
	 */

	@FindBy(css = "ul.results-base li.product-base:first-child")
	public WebElement clickProduct;

	public void clickOnProductForSizeGuide() {
		WaitFor.waitForElementToBeClickable(clickProduct);
		clickProduct.click();
	}

	/**
	 * Interactivity of promotional banners
	 */

	@FindBy(css = "h1.title-title")
	public WebElement resultText;

	public void getResultPageTextOfPromoBanner() {
		String text = resultText.getText();
		//System.out.println("You have landed on: " + text);
		LOG.info("You have landed on: " + text);
		
	}

	/**
	 * Checking if BreadCrumb links are interactable
	 */

	@FindBy(css = "a[href=\"/footwear?src=bc\"]")
	public WebElement bCrumbFootwearLink;

	public void clickOnBreadCrumbGeneralFootwearLink() {
		bCrumbFootwearLink.click();
		//System.out.println("You've navigated to *Footwear* link");
		LOG.info("You've navigated to *Footwear* link");
		
	}

	@FindBy(css = "li.breadcrumbs-item:first-child")
	public WebElement bCrumbHomeLink;

	public void clickOnBreadCrumbHomeLink() {
		bCrumbHomeLink.click();
		//System.out.println("You've navigated to *Home* link");
		LOG.info("You've navigated to *Home* link");
	}

	/**
	 * Verify low to high price selection functionality
	 */

	@FindBy(css = "div.sort-sortBy")
	public WebElement hoverElement;

	public void hoverOnRecommendations() {
		Keyword keyword = new Keyword();
		keyword.hoverOn(hoverElement);
	}

	@FindBy(css = "ul.sort-list>li:nth-child(6) input[value=\"price_asc\"]")
	public WebElement lowToHighOption;

	public void clickOnLowToHighOption() {
		List<WebElement> options = hoverElement.findElements(By.cssSelector("li label"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Price: Low to High")) {
				option.click();
			}
		}
	}

	public List<Integer> getAllProductPrices() {
		// Keyword keyword = new Keyword();
		Keyword.getDriver().navigate().refresh();
		List<Integer> prices = new ArrayList<>();
		for (WebElement prodPrice : productPrices) {
			prices.add(Integer.parseInt(prodPrice.getText().split("Rs. ", -1)[1]));
		}
		return prices;
	}

	public void verifyAllPricesAreInLowToHighOrder() {
		List<Integer> price = getAllProductPrices();
		SoftAssert softly = new SoftAssert();
		for (int i = 1; i < price.size(); i++) {
			// softly.assertTrue(price.get(i).compareTo(price.get(i+1)) <= 0,"Prices not in
			// Low to High order.");
			if (price.get(i) < price.get(i - 1)) {
				softly.fail("Product prices are not in low to high order");
				break;
			}
		}
		softly.assertAll();
		//System.out.println("All product prices are not in low to high order");
		LOG.info("All product prices are not in low to high order");
	}
}
