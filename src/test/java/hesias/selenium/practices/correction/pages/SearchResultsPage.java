package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private final By titlePageHeader = By.cssSelector("h1[selenium-id='pageHeader']");
    private final By firstGameTitle = By.xpath("//product-title[@selenium-id='productTitle'][1]//span");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstGameTitle() {
        return driver.findElement(firstGameTitle).getText();
    }

    public boolean isDisplayed() {
        try {
            waitUntil(titlePageHeader);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
