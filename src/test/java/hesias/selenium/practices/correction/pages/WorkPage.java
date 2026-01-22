package hesias.selenium.practices.correction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WorkPage extends BasePage {

    private final By inputSearchJobOffer = By.cssSelector("input[ng-model='filter.searchText']");
    private final By jobOffer = By.cssSelector("div.department-job-offers");

    public WorkPage(WebDriver driver) {
        super(driver);
    }

    public WorkPage goToJobOfferInput() {
        goTo(ROOT_URL + "work");
        WebElement we = driver.findElement(inputSearchJobOffer);
        new Actions(driver)
                .scrollToElement(we)
                .perform();
        return this;
    }

    public void searchForJobOffer(String job) {
        goToJobOfferInput();
        type(inputSearchJobOffer, job);
    }

}
