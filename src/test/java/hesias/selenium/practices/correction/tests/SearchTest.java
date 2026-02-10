package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Search bar")
@Severity(SeverityLevel.NORMAL)
public class SearchTest extends BaseTest {

    @Test
    @Story("As an user, I want to search for 'Cyberpunk'")
    public void testSearchCyberpunk() {
        boolean pageResultIsDisplayed = new HomePage(driver)
            .searchGame("Cyberpunk")
            .isDisplayed();

        assertTrue(pageResultIsDisplayed);
    }

    @Test
    @Story("As an user, I want to search for 'Binding of'")
    public void testSearchBindingOf() {
        boolean pageResultIsDisplayed = new HomePage(driver)
                .searchGame("Binding of")
                .isDisplayed();

        assertTrue(pageResultIsDisplayed);
    }

    @Test
    @Story("As an user, I want to search for 'Witcher'")
    public void testFirstResultContainsWitcher() {
        String firstGameTitle = new HomePage(driver)
                .searchGame("Witcher")
                .getFirstGameTitle();

        assertTrue(firstGameTitle.contains("Witcher"));
    }

    @Test
    @Story("As an user, I want to use the filter 'Good Old Games'")
    public void testFilterGoodOldGames() {
        boolean isFilterActive = new HomePage(driver)
                .searchGame("Binding of")
                .isFilterGoodOldGamesActive();

        assertTrue(isFilterActive);
    }

    @Test
    @Story("As an user, I want to reset the filters")
    public void testResetFilters() {
        boolean hasResetFiler = new HomePage(driver)
                .searchGame("Binding of")
                .hasResetFilters();

        assertTrue(hasResetFiler);
    }

}
