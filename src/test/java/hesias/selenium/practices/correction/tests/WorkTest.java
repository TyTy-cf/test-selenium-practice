package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.HomePage;
import hesias.selenium.practices.correction.pages.WorkPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Job offer page")
@Severity(SeverityLevel.NORMAL)
public class WorkTest extends  BaseTest {

    @Test
    @Story("As an user, I want to check the job offer")
    public void testResetFilters() {
        new WorkPage(driver)
                .goToJobOfferInput();
    }

}
