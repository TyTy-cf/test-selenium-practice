package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

    private final By refuseCookies = By.cssSelector("button#CybotCookiebotDialogBodyButtonDecline");
    private final By linkHome = By.cssSelector("a.menu__logo");
    private final By searchBtn = By.cssSelector("a[hook-test='menuSearch']");
    private final By searchInput = By.cssSelector("input[hook-test='menuSearchInput']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        goTo(ROOT_URL);
        waitClick(refuseCookies).click();
        return this;
    }

    public SearchResultsPage searchGame(String gameName) {
        open();
        waitClick(searchBtn).click();
        type(searchInput, gameName);
        keyDown(searchInput, Keys.ENTER);


        return new SearchResultsPage(driver);
    }

    public HomePage changeLanguage(String locale) {
        goTo(ROOT_URL.replace("fr",  locale));
        waitClick(refuseCookies).click();
        return this;
    }

    public boolean isDisplayed() {
        try {
            waitUntil(linkHome);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
