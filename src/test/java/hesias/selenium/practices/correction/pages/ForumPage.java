package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ForumPage extends BasePage {

    private final By communityTitle = By.cssSelector("span.comunity");
    private final By forumTitle = By.cssSelector("div.module_in > h2");

    public ForumPage(WebDriver driver) {
        super(driver);
    }

    public ForumPage goToForum() {
        goTo(ROOT_URL + "forum");
        WebElement we = driver.findElement(communityTitle);
        new Actions(driver)
                .scrollToElement(we)
                .perform();
        return this;
    }

    public String getForumTitle() {
        return waitUntil(forumTitle).getText();
    }
}
