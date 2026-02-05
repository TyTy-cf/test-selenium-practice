package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.HomePage;
import hesias.selenium.practices.correction.pages.OpenWorldPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Shop dropdown")
public class BoutiqueTest extends  BaseTest {

    @Test
    @Story("As the user I want to access the shop dropdown and get to the open world menu")
    @Description("Display the shop dropdown then verify if we can click on the shop item 'open world'")
    @Severity(SeverityLevel.CRITICAL)
    public void testGoToOpenWorld() {
        OpenWorldPage owp = (new HomePage(driver))
                .openShopDropdown()
                .goToOpenWorld();

        assertTrue(owp.isDisplayed());
        assertEquals( "JEUX À MONDE OUVERT", owp.getPageTitle());
    }

    @Test
    @Story("As the user I want to access the shop dropdown and get to the open world menu and check the games")
    @Description("Display the shop dropdown then verify if we can click on the shop item 'open world' then if there is games to click on")
    @Severity(SeverityLevel.NORMAL)
    public void testOpenWorldGamesDisplay() {
        OpenWorldPage owp = (new HomePage(driver))
                .openShopDropdown()
                .goToOpenWorld();

        assertNotNull(owp.getFirstGameTitle());
        assertEquals(8, owp.getGamesCount());
    }

}
