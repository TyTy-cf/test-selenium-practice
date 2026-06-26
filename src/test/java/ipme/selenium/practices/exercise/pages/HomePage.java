package ipme.selenium.practices.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private final By linkHome = By.cssSelector("a.menu__logo");
	private final By shopDropdown = By.cssSelector("div[hook-test='menuStore']");
	private final By helpDropdown = By.cssSelector("div[hook-test='menuSupport']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage open() {
		goTo(ROOT_URL);
		refuseCookies();
		return this;
	}

	public HomePage changeLanguage(String locale, boolean refuseCookies) {
		goTo(ROOT_URL.replace("fr", locale));
		if (refuseCookies) {
			refuseCookies();
		}
		return this;
	}

	public HomePage openShopDropdown() {
		open();
		moveToElement(shopDropdown);
		return this;
	}

	public HomePage openNeedHelpDropdown() {
		open();
		moveToElement(helpDropdown);
		return this;
	}

	public boolean isDisplayed() {
		try {
			waitUntil(linkHome);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
