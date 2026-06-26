package ipme.selenium.practices.exercise.tests;

import ipme.selenium.practices.exercise.pages.AllForumsPage;
import ipme.selenium.practices.exercise.pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Forum page")
@Severity(SeverityLevel.NORMAL)
public class AllForumsTest extends BaseTest {

	@Test
	@Story("As an user, I want to access the forums page")
	public void testForumsPageIsDisplayed() {
		assertTrue(new AllForumsPage(driver)
				.open()
				.isDisplayed());
	}

	@Test
	@Story("As an user, I want to toggle the community wishlist collapse")
	public void testCommunityCollapseIsWorking() {
		assertTrue(new AllForumsPage(driver)
				.open()
				.isCommunityCollapseWokring());
	}
}
