package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nav_Page extends Basic_Page {

    public Nav_Page(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getLanguageButton() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public void clickOnLanguagebutton() {
        getLanguageButton().click();
    }

    public WebElement getEnglishLanguage() {
        return driver.findElement(By.cssSelector("#list-item-73 > div"));
    }

    public void clickOnEnglishLanguage() {
        getEnglishLanguage().click();
    }

    public boolean isEnglishLanguagePresented() {
        return getEnglishLanguage().isDisplayed();
    }


    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("[href='/login'].btnLogin"));
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public boolean isLoginPresented() {
        return getLoginButton().isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForUrlContainsLogin() {
        wait.withMessage("Current url should contains '/login' ");
        wait.until(ExpectedConditions.urlContains("/login"));
    }

}
