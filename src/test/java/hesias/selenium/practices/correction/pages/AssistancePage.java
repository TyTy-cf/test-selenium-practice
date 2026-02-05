package hesias.selenium.practices.correction.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssistancePage extends BasePage {

    private final By titleAssistance = By.cssSelector("h1.h2");
    private final By languageSelect = By.cssSelector("span.dropdown-menu");
    private String languageItem = "//a[contains(@href, '%s')]";

    public AssistancePage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeaderTitle() {
        return waitUntil(titleAssistance).getText();
    }

    public AssistancePage selectLanguage(String locale) {
        waitClick(languageSelect).click();
        waitClick(By.xpath(String.format(languageItem, locale))).click();
        return this;
    }

    public boolean isDisplayed() {
        try {
            waitUntil(titleAssistance);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
