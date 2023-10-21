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

    public void waitForUrlContainsHome() {
        wait.withMessage("Current url should contains '/home' ");
        wait.until(ExpectedConditions.urlContains("/home"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.className("btnLogout"));
    }

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }

    public void waitForLogoutButtonToBeVisible() {
        wait.withMessage("Logout button should be visible");
        wait.until(ExpectedConditions.visibilityOf(getLogoutButton()));
    }

    public WebElement getSignupButton() {
        return driver.findElement(By.cssSelector("[href='/signup'].btnLogin"));
    }

    public void clickToSignupButton() {
        getSignupButton().click();
    }

    public void waitForUrlContainsSignup() {
        wait.withMessage("Current url should contains '/signup' ");
        wait.until(ExpectedConditions.urlContains("/signup"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.className("btnAdmin"));
    }

    public void clickOnAdminButton() {
        getAdminButton().click();
    }

    public WebElement getCitiesFromAdminMenu() {
        return driver.findElement(By.className("v-list-item__title"));
    }

    public void clickOnCities() {
        getCitiesFromAdminMenu().click();
    }

    public void waitUntilUrlContainsAdminCitiesroute() {
        wait.withMessage("Current url should contains '/admin/cities' ");
        wait.until(ExpectedConditions.urlContains("/admin/cities"));
    }

    public WebElement getEmailForLogin() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordForLogin() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButtonToGoOnAdminCitesPage() {
        return driver.findElement(By.className("v-btn--is-elevated"));
    }

    public void clickOnLoginButtonForAdminCitiesPage() {
        getLoginButtonToGoOnAdminCitesPage().click();
    }

    public void visitAdminCitiesPageWithAdminCredentials() {
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";

        getEmailForLogin().sendKeys(adminEmail);
        getPasswordForLogin().sendKeys(adminPassword);
        clickOnLoginButtonForAdminCitiesPage();
    }

}
