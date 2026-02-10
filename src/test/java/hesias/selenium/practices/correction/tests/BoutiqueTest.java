package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.HomePage;
import hesias.selenium.practices.correction.pages.OpenWorldPage;
import hesias.selenium.practices.correction.pages.StrategyPage;
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

    @Test
    @Story("As the user I want to go to the strategy page")
    @Description("Verify that the user can go to the strategy page")
    @Severity(SeverityLevel.NORMAL)
    public void testGoToStrategy() {
        StrategyPage sp = (new HomePage(driver))
                .openShopDropdown()
                .goToStrategy();

        assertTrue(sp.isDisplayed());
        assertEquals(("Jeux de Stratégie").toUpperCase(), sp.getPageTitle());
    }

    @Test
    @Story("As the user I want to change the epoch filter inside strategy games")
    @Description("Verify that the user can change the epoch filter to 2010 inside strategy games")
    @Severity(SeverityLevel.NORMAL)
    public void testFilterBy2010Epoch() {
        StrategyPage sp = (new HomePage(driver))
                .openShopDropdown()
                .goToStrategy()
                .selectEpoch("2010");

        assertTrue(sp.isFilterEpochActive("2010"));
        assertNotNull(sp.getFirstGameTitle());
    }

    @Test
    @Story("As the user I want to change the epoch filter inside strategy games")
    @Description("Verify that the user can change the epoch filter to 2010 then to 90 inside strategy games")
    @Severity(SeverityLevel.NORMAL)
    public void testFilterBy90Epoch() {
        StrategyPage sp = (new HomePage(driver))
                .openShopDropdown()
                .goToStrategy()
                .selectEpoch("2010")
                .selectEpoch("90");

        assertTrue(sp.isFilterEpochActive("90"));
        assertNotNull(sp.getFirstGameTitle());
    }

    @Test
    @Story("As the user I want to scroll to the available games")
    @Description("Verify that the user can change the epoch filter to 90 then scroll to the displayed games")
    @Severity(SeverityLevel.NORMAL)
    public void testScrollToDisplayGames() {
        String pht = (new HomePage(driver))
                .openShopDropdown()
                .goToStrategy()
                .selectEpoch("90")
                .getPageHeaderTitle();

        assertEquals("Affichage de 2822 jeux", pht);
    }

    @Test
    @Story("As the user I want to scroll to the likeable tags")
    @Description("Verify that the user can scroll to the likeable tags")
    @Severity(SeverityLevel.NORMAL)
    public void testScrollToLikableTags() {
        StrategyPage sp = (StrategyPage) (new HomePage(driver))
                .openShopDropdown()
                .goToStrategy()
                .scrollToLikeableTags();

        assertEquals(5, sp.getTagsCount());
    }

}
