package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Home page")
@Severity(SeverityLevel.NORMAL)
public class HomeTest extends  BaseTest {

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
    @Story("As an user, I want to change the website to english")
    public void testHomePageChangeLanguageToEn() {
        boolean homeIsDisplayed = new HomePage(driver)
                .changeLanguage("en")
                .isDisplayed();

        assertTrue(homeIsDisplayed);
    }

    @Test
    @Story("As an user, I want to use the slider to the left")
    public void testSliderLeft() {
        boolean lastElementIsActive = new HomePage(driver)
                .open()
                .clickSliderLeftArrow();

        assertTrue(lastElementIsActive);
    }

    @Test
    @Story("As an user, I want to click on the first game in swiper")
    public void testClickFirstGameInSwiper() {
        boolean isOnGamePage = new HomePage(driver)
                .open()
                .clickFirstItemSlider()
                .isDisplayed();

        assertTrue(isOnGamePage);
    }

}
