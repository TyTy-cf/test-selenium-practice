package ipme.selenium.practices.exercise.tests;

import hesias.selenium.practices.correction.pages.HomePage;
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

}
