package ipme.selenium.practices.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllForumsPage extends BasePage {

	private final By generalForumsBlock = By.cssSelector(".module.forums.generals");

	public AllForumsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isDisplayed() {
		try {
			return waitVisible(generalForumsBlock).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
