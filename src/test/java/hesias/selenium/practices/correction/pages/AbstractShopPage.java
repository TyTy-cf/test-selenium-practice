package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AbstractShopPage extends BasePage {

    private final By pageTitle = By.cssSelector("h1[selenium-id='tagPageHeaderTitle']");
    private final By gamesSection  = By.cssSelector("section[selenium-id='tabbedSectionSection']");
    private final By firstGame  = By.cssSelector("product-tile[selenium-id='tabbedSectionProductTile']");
    private final By sectionHeaderTags  = By.cssSelector("section-header[selenium-id='tagsForYouSectionHeader']");
    private final By tagTiles  = By.cssSelector("tag-tile[selenium-id='tagsForYouSectionItem']");
    private final By firstGamesContainer  = By.xpath("//section[@data-sid='47f54391-1325-44f1-aa95-a212bf69f813']//product-tile[@selenium-id='tabbedSectionProductTile']");

    public AbstractShopPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return waitUntil(pageTitle).getText();
    }

    public String getFirstGameTitle() {
        scrollToElement(gamesSection);
        return waitUntil(firstGame).getText();
    }

    public int getGamesCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstGamesContainer)).size();
    }

    public int getTagsCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tagTiles)).size();
    }

    public AbstractShopPage scrollToLikeableTags() {
        scrollToElement(sectionHeaderTags);
        return this;
    }

    public boolean isDisplayed() {
        try {
            return getPageTitle() != null;
        } catch (Exception e) {
            return false;
        }
    }

}
