package hesias.selenium.practices.correction.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssistancePage extends BasePage {

    private final By titleAssistance = By.cssSelector("h1.h2");
    private final By languageSelect = By.cssSelector("div.dropdown.language-selector");
//    private final By languageItems = By.xpath("//a[@role='menuitem']");
    private final String strLanguage = "//span//a[contains(@href, '%s')]";

    public AssistancePage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeaderTitle() {
        return waitUntil(titleAssistance).getText();
    }

    public AssistancePage selectLanguage(String locale) {
        waitClick(languageSelect).click();
        waitClick(By.xpath(String.format(strLanguage, locale))).click();
//        try {
//            List<WebElement> webElementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(languageItems));
//            for(WebElement webElement : webElementList) {
//                if (Objects.requireNonNull(webElement.getAttribute("href")).contains(locale)) {
//                    webElement.click();
//                }
//            }
//        } catch(StaleElementReferenceException ex)
//        {
//            return this;
//        }
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
