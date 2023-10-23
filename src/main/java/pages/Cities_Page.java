package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cities_Page extends Basic_Page {

    public Cities_Page(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }

    public void clickOnNewItemButton() {
        getNewItemButton().click();
    }

    public WebElement getDialogeForEditAndCreateCity() {
        return driver.findElement(By.className("dlgNewEditItem"));
    }

    public void waitUntilDialogeForEditAndCreateCityIsVisible() {
        wait.withMessage("Dialoge for new item should be visible");
        wait.until(ExpectedConditions.visibilityOf(getDialogeForEditAndCreateCity()));
    }

    public WebElement getInputForNameOfTheCity() {
        return driver.findElement(By.id("name"));
    }

    public String getAtributeValueForName() {
        return getInputForNameOfTheCity().getAttribute("type");
    }

    public void enterNameOfCity(String cityName) {
        getInputForNameOfTheCity().clear();
        getInputForNameOfTheCity().sendKeys(cityName);
    }

    public WebElement getSaveCityButton() {
        return driver.findElement(By.className("btnSave"));
    }

    public void clickOnSaveCityButton() {
        getSaveCityButton().click();
    }

    public WebElement getPopupMessageForSavedCity() {
        return driver.findElement(By.cssSelector(".success .v-snack__content"));
    }

    public void waitUntilPopMessageForSavedCityIsVisible() {
        wait.withMessage("Pop-up message for saved city should be visible");
        wait.until(ExpectedConditions.visibilityOf(getPopupMessageForSavedCity()));
    }

    public boolean getMessageTextFromPopupForNewCity() {
        return getPopupMessageForSavedCity().getText().contains("Saved successfully");
    }

}
