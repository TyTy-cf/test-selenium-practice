package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StrategyPage extends AbstractShopPage {

    private final By forYouSelection = By.cssSelector("section-header[selenium-id='tagsForYouSectionHeader']");
    private final String epochFilter = "//div[@selenium-id='tabbedSectionHeaderTab'][contains(text(), ' %s ')]";
    private final By displayGames = By.cssSelector("h1[selenium-id='pageHeader']");

    public StrategyPage(WebDriver driver) {
        super(driver);
    }

    public StrategyPage selectEpoch(String epoch) {
        scrollToElement(forYouSelection);
        waitClick(By.xpath(String.format(epochFilter, epoch)));
        return this;
    }

    public boolean isFilterEpochActive(String epoch) {
        scrollToElement(forYouSelection);
        WebElement we = waitClick(By.xpath(String.format(epochFilter, epoch)));
        we.click();
        String classCss = we.getAttribute("class");
        if (classCss == null) return false;
        return classCss.contains("tabbed-section-header__tab--active");
    }

    public String getPageHeaderTitle() {
        scrollToElement(displayGames);
        return getText(displayGames);
    }

}
