package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForumPage extends BasePage {

    private final By linkHome = By.cssSelector("a.menu__logo");

    public ForumPage(WebDriver driver) {
        super(driver);
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
