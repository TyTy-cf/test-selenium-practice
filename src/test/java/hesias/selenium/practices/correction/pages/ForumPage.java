package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForumPage extends BasePage
{
    private final By titleComunity = By.cssSelector("span[class='comunity']");

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
}
