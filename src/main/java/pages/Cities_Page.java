package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
        getInputForNameOfTheCity().sendKeys(Keys.CONTROL + "a");
        getInputForNameOfTheCity().sendKeys(Keys.DELETE);
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

    public WebElement getSearchButton() {
        return driver.findElement(By.id("search"));
    }

    public void clickOnSearchButton() {
        getSearchButton().click();
    }

    public void searchForOldNameOfCity(String nameOfCity) {
        getSearchButton().clear();
        getSearchButton().sendKeys(nameOfCity);
    }

    public void waitUntilNumberOfRowsOfCitiesInSearchIs(int numberOfRows) {
        wait.withMessage("Number of rows in search should be" + numberOfRows);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody tr"), numberOfRows));
    }

    public List<WebElement> getListOfEditButtons() {
        return driver.findElements(By.cssSelector(".v-data-table__wrapper #edi"));
    }

    public WebElement getEditButtonFromRow() {
        return driver.findElement(By.className("mdi-pencil"));
    }

    public void clickOnEditButtonFromRow() {
        getEditButtonFromRow().click();
    }

    public WebElement getCellFromCertainRow() {
        return driver.findElement(By.cssSelector("tbody > tr > td:nth-child(2)"));
    }

    public String getTextFromCertainNameCell() {
        return getCellFromCertainRow().getText();
    }

    public List<WebElement> getDeleteCitiesButtons() {
        return driver.findElements(By.cssSelector(".v-data-table__wrapper tbody tr td #delete"));
    }

    public WebElement getDeleteButtonFromFirstRow(int rowNumber) {
        return getDeleteCitiesButtons().get(rowNumber - 1);
    }

    public void clickOnDeleteButtonFromFirstRow(int rowNumber) {
        getDeleteButtonFromFirstRow(rowNumber).click();
    }

    public WebElement getDialogeForDeleteCity() {
        return driver.findElement(By.className("rounded-0"));
    }

    public void waitUntilMessageForDeleteCityIsVisible() {
        wait.withMessage("Dialoge for delete city should be visible");
        wait.until(ExpectedConditions.visibilityOf(getDialogeForDeleteCity()));
    }

    public WebElement getConfirmDeleteButtonFromDialoge() {
        return driver.findElement(By.cssSelector(".v-dialog__content--active button.text--lighten3"));
    }

    public void clickOnConfirmDeleteButtonFromDialoge() {
        getConfirmDeleteButtonFromDialoge().click();
    }

}
