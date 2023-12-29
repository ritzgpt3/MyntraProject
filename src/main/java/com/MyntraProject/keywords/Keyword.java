package com.MyntraProject.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.First_Framework.Keywords.Keyword;
import com.MyntraProject.errors.InvalidBrowserError;
import com.MyntraProject.exceptions.InvalidSelectorException;

public class Keyword {
	private static RemoteWebDriver driver = null;

	/**
	 * This method returns the driver instance,Make sure before calling this method
	 * one should call {@code oprnBrowser(String broserName)} method so that it can
	 * initialize driver instance.
	 * 
	 * @return
	 */
	public static RemoteWebDriver getDriver() {
		return driver;

	}

	/**
	 * This will launch specified browser
	 * 
	 * @param broserName
	 */
	public void openBrowser(String broserName) {
		if (broserName.equalsIgnoreCase("chrome")) {
			// driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("---disable-notifications");
			driver = new ChromeDriver(options);
			System.out.println("Opening Chrome browser");
		} else if (broserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Opening Firefox browser");
		} else {
			System.out.println("Invalid broser name");
			throw new InvalidBrowserError(broserName);
		}
	}

	public void openUrl(String url) {
		driver.get(url);
		System.out.println("Launching url");
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quiteAllWindows() {
		driver.quit();
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			return driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			return driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			return driver.findElement(By.partialLinkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			return driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}

	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			return driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			return driver.findElements(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			return driver.findElements(By.partialLinkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			return driver.findElements(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public void clickOn(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public void clickOn(WebElement element) {
		element.click();

	}

	public void getText(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).getText();
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	@Deprecated
	private void enterText(String locatorType, String locatorValue, CharSequence... text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}

	public void enterText(String locator, CharSequence... text) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		enterText(locatorType, locatorValue, text);
	}

	public void hitKey(int keyCode) {
		try {
			Robot robo = new Robot();
			robo.keyPress(keyCode);
			robo.keyRelease(keyCode);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> getTexts(String locatorType, String locatorValue) {
		List<String> texts = new ArrayList<String>();
		List<WebElement> elements = new ArrayList<WebElement>();
		elements = getWebElements(locatorType, locatorValue);
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;

	}

	public List<String> getTexts(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		return getTexts(locatorType, locatorValue);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public List<String> getTexts(List<WebElement> items) {
		List<String> texts = new ArrayList<String>();
		for (WebElement item : items) {
			texts.add(item.getText());
		}
		return texts;
	}

	public static void scrollWindow(int x, int y) {
		driver.executeScript("window.scrollBy(" + x + "," + y + ")");

	}

	public static void dismissOnAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void switchToWindowByTitle(String title) {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public void switchToWindowByGetCurrentUrl(String currentUrl) {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().equals(currentUrl)) {
				break;
			}
		}
	}

	public void hoverOn(WebElement elementToHover) {
		Actions actions = new Actions(Keyword.getDriver());
		actions.moveToElement(elementToHover).build().perform();
		;
	}

	public void handlingWindows() {
		String parent = getDriver().getWindowHandle();
		Set<String> win1 = driver.getWindowHandles();
		win1.remove(parent);

		for (String handles : win1) {
			driver.switchTo().window(handles);
			String title1 = driver.getCurrentUrl();
			System.out.println(title1);
			/*
			 * if(title.contains("second")) {
			 * driver.findElement(By.xpath("//button[text()=\"Click Me\"]")).click(); String
			 * text = driver.findElement(By.xpath("//p[@id=\"demo\"]")).getText();
			 * System.out.println(text); }
			 */

		}
		public void scrollWindow() {
			driver.executeScript("window.scrollBy(0,3700)");
		}


}
