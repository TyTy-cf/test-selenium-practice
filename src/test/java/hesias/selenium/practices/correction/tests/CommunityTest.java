package hesias.selenium.practices.correction.tests;

import hesias.selenium.practices.correction.pages.ForumPage;
import hesias.selenium.practices.correction.pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Community")
@Severity(SeverityLevel.NORMAL)
public class CommunityTest extends  BaseTest {

    @Test
    @Story("As an user, I want to access the community menu")
    @Severity(SeverityLevel.NORMAL)
    public void testCommunityMenuIsDisplayed() {
        boolean communityMenuIsDisplayed = new HomePage(driver)
                .open()
                .hoverCommunityMenu()
                .isCommunityMenuDisplayed();

        assertTrue(communityMenuIsDisplayed);
    }


    @Test
    @Story("As an user, I want to access the forum page")
    @Severity(SeverityLevel.NORMAL)
    public void testGoToForumPage()
    {
        boolean forumPageIsDisplayed = new HomePage(driver)
                .open()
                .hoverCommunityMenu()
                .goToForumPage()
                .isDisplayed();

        assertTrue(forumPageIsDisplayed);
    }

    @Test
    @Story("As an user, I want to use forum wishlist dropdown")
    @Severity(SeverityLevel.MINOR)
    public void testWishlistDropdown()
    {
        ForumPage page = new ForumPage(driver).open();
        assertTrue(page.isWishListOpened());

        assertFalse(page.clickWishList().isWishListOpened());

        assertTrue(page.clickWishList().isWishListOpened());
    }
}
