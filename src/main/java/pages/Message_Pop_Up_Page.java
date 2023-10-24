package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Message_Pop_Up_Page extends Basic_Page {

    public Message_Pop_Up_Page(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getPopUpMessage() {
        return driver.findElement(By.cssSelector(".v-snack__content>ul>li"));
    }

    public void waitUntilPopUpMessageIsVisible() {
        wait.withMessage("Pop-up message should be visible");
        wait.until(ExpectedConditions.visibilityOf(getPopUpMessage()));
    }

    public String getTextFromPopUpMessage() {
        return getPopUpMessage().getText();
    }

    public WebElement getPopUpMessageForVerifyLogin() {
        return driver.findElement(By.className("v-card__title"));
    }

    public void waitUntilPopUpMessageForSuccesfulLoginIsVisible() {
        wait.withMessage("Pop-up message for account verify should be visible");
        wait.until(ExpectedConditions.visibilityOf(getPopUpMessageForVerifyLogin()));
    }

    public String getTextFromPopUpMessageForSuccesfulLogin() {
        return getPopUpMessageForVerifyLogin().getText();
    }

    public WebElement getCloseButtonForPopupMessage() {
        return driver.findElement(By.cssSelector(".v-card__actions button"));
    }

    public void clickOnCloseButtonForPopupMessage() {
        getCloseButtonForPopupMessage().click();
    }

    public WebElement getPopUpMessageForSuccessfulDeleteCity() {
        return driver.findElement(By.cssSelector(".success .v-snack__content"));
    }

    public void waitUntilPopUpMessageForDeleteCityIsVisible() {
        wait.withMessage("Pop-up message for delete city should be visible ")
                .until(ExpectedConditions.visibilityOf(getPopUpMessageForSuccessfulDeleteCity()));
    }

    public boolean getTextFromPopUpMessageForDeletedCity() {
        return getPopUpMessageForSuccessfulDeleteCity().getText().contains("Deleted successfully");
    }

}
