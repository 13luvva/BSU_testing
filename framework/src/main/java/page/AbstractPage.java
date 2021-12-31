package page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	protected WebDriver driver;
	protected final int WAIT_TIMEOUT_SECONDS = 15;

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}

	protected WebElement defaultFindElementByLocator(By locator) {
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions
						.presenceOfElementLocated(locator));
	}

	protected WebElement findElementByLocator(By locator) {
		try {
			return defaultFindElementByLocator(locator);
		} catch (StaleElementReferenceException e) {
			return defaultFindElementByLocator(locator);
		}
	}

	protected WebElement findElementByLocatorAndClick(By locator) {
		try {
			WebElement element = defaultFindElementByLocator(locator);
			element.click();
			return element;
		} catch (StaleElementReferenceException e) {
			WebElement element = defaultFindElementByLocator(locator);
			element.click();
			return element;
		}
	}

	protected String findElementByLocatorAndGetText(By locator) {
		try {
			return findElementByLocator(locator).getText();
		} catch (StaleElementReferenceException e) {
			return findElementByLocator(locator).getText();
		}
	}
}
