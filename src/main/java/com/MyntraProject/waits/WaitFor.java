package com.MyntraProject.waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.MyntraProject.keywords.Keyword;
import com.MyntraProject.exceptions.InvalidSelectorException;

public class WaitFor {
	private static FluentWait<WebDriver> wait = null;

	static {
		wait = new FluentWait<WebDriver>(Keyword.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(NullPointerException.class);
	}

	public static void numberOfElementsToBeMoreThan(String locatorType, String locatorValue, int count) {
		By element = null;
		if (locatorType.equalsIgnoreCase("id")) {
			element = By.id(locatorValue);
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = By.cssSelector(locatorValue);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			element = By.xpath(locatorValue);
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = By.name(locatorValue);
		} else if (locatorType.equalsIgnoreCase("class")) {
			element = By.className(locatorValue);
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element = By.partialLinkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			element = By.linkText(locatorValue);
		} else {
			throw new InvalidSelectorException(locatorType);
		}

		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(element, count));
	}

	public static void waitForElementToBePresent(By x) {
		wait.until(ExpectedConditions.presenceOfElementLocated(x));
	}

	public static void waitForElementToBeClickable(WebElement x) {
		wait.until(ExpectedConditions.elementToBeClickable(x));
	}

	public static void numberOfElementsToBeMoreThan(By productTitle, int count) {
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan((By) productTitle, count));

	}

	public static void waitForElementToContainText(WebElement errorMsg, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(errorMsg, text));
	}

//-----------------------------------------------------------------------------------------------------

	public static void waitElementToBePresent(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}

	public static void waitelementToBeClickable(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void waitPresenceOfElementLocated(By element) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element));

	}

	public static void stalenessOf(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));

	}
}
