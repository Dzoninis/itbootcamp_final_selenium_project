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

}
