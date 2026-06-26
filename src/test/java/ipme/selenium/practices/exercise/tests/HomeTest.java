package ipme.selenium.practices.exercise.tests;

import ipme.selenium.practices.exercise.pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Home page")
@Severity(SeverityLevel.NORMAL)
public class HomeTest extends BaseTest {

	@Test
	@Story("As an user, I want to access the home page")
	@Severity(SeverityLevel.CRITICAL)
	public void testHomePageIsDisplayed() {
		boolean homeIsDisplayed = new HomePage(driver)
				.open()
				.isDisplayed();

		assertTrue(homeIsDisplayed);
	}

	@Test
	@Story("As a user, I want to see the community dropdown menu")
	@Severity(SeverityLevel.MINOR)
	public void testCommunityDropdownIsVisible() {
		boolean linkBlogIsVisible = new HomePage(driver)
				.openCommunityDropdown()
				.isLinkBlogVisible();

		assertTrue(linkBlogIsVisible);
	}

}
