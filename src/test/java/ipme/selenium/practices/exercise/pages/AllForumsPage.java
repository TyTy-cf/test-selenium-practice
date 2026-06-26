package ipme.selenium.practices.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllForumsPage extends BasePage {
	private final String ROOT_URL = "https://www.gog.com/forum";

	private final By generalForumsBlock = By.cssSelector(".module.forums.generals");

	private final By wishlistForumTitle = By.cssSelector(".wishlist_highlights h2");
	private final By wishlistForumContent = By.cssSelector(".highlights_list.category");

	public AllForumsPage(WebDriver driver) {
		super(driver);
	}

	public AllForumsPage open() {
		goTo(ROOT_URL);
		refuseCookies();
		return this;
	}

	public boolean isDisplayed() {
		try {
			return waitVisible(generalForumsBlock).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isTitleCollapsingContent(By title, By content) throws InterruptedException {
		WebElement titleElement = waitClick(title);

		titleElement.click();

		return contentElement.isDisplayed();
	}

	public boolean isCommunityCollapseWokring() {
		try {
			return isTitleCollapsingContent(wishlistForumTitle, wishlistForumContent);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
}
