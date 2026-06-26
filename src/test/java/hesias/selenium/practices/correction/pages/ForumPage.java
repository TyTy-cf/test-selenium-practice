package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForumPage extends BasePage
{
    private final By titleComunity = By.cssSelector("span[class='comunity']");
    private final By wishListDropdown = By.xpath("//span[contains(text(),'Community Wishlist')]");
    private final By wishListHighlightList = By.cssSelector("div[class='highlights_list category']");

    public ForumPage(WebDriver driver) {super(driver);}

    public boolean isDisplayed()
    {
        try {
            waitUntil(titleComunity);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public ForumPage open() {
        goTo(FORUM_URL);
        refuseCookies();
        return this;
    }

    public ForumPage clickWishList()
    {
        waitClick(wishListDropdown).click();
        return this;
    }

    public boolean isWishListOpened()
    {
        try {
            waitUntil(wishListHighlightList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
