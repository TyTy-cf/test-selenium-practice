package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForumPage extends BasePage
{

    static final String FORUM_URL = "https://www.gog.com/forum";

    private final By titleCommunity = By.cssSelector("span[class='comunity']");
    private final By wishListDropdown = By.xpath("//span[contains(text(),'Community Wishlist')]");
    private final By wishListHighlightList = By.cssSelector("div[class='highlights_list category']");

    public ForumPage(WebDriver driver) {super(driver);}

    public boolean isDisplayed() {
        return isDisplayed(titleCommunity);
    }

    public ForumPage open() {
        goTo(FORUM_URL);
        refuseCookies();
        return this;
    }

    public ForumPage clickWishList() {
        waitClick(wishListDropdown).click();
        return this;
    }

    public boolean isWishListOpened() {
        return isDisplayed(wishListHighlightList);
    }
}