package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.AssistancePage;
import hesias.selenium.practices.correction.pages.HomePage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Assistance page")
public class AssistanceTest extends BaseTest {

    @Test
    public void testGoToAssistancePage() {
        AssistancePage assistancePage = (new HomePage(driver))
                .openNeedHelpDropdown()
                .goToTechnicalIssueOnAGame();

        assertTrue(assistancePage.isDisplayed());
    }

    @Test
    public void testChangeLanguage() {
        AssistancePage assistancePage = (new HomePage(driver))
                .openNeedHelpDropdown()
                .goToTechnicalIssueOnAGame()
                .selectLanguage("pl");

        assertTrue(assistancePage.isDisplayed());
        assertEquals("Problemy techniczne z grami", assistancePage.getPageHeaderTitle());
    }

}
