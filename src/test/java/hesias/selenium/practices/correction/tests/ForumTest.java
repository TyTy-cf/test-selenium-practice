package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.ForumPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ForumTest extends BaseTest {

    @Test
    @Story("As an user, I want to use forum wishlist dropdown")
    @Severity(SeverityLevel.MINOR)
    public void testWishlistDropdown()
    {
        ForumPage page = new ForumPage(driver)
                .open()
                .clickWishList();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertFalse(page.isWishListOpened());
    }

}
