package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup_Page extends Basic_Page {

    String name = "Another User";
    String email = "admin@admin.com";
    String password = "12345";
    String confirmPassword = "12345";

    public Signup_Page(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailforSignup() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordforSignup() {
        return driver.findElement(By.id("password"));
    }

    public String getAtributeValueForEmail() {
        return getEmailforSignup().getAttribute("type");
    }

    public String getAtributeValueForPassword() {
        return getPasswordforSignup().getAttribute("type");
    }

    public WebElement getConfirmPasswordforSignup() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public String getAtributeValueForConfirmPassword() {
        return getConfirmPasswordforSignup().getAttribute("type");
    }

    public WebElement getNameForSignup() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getSignMeUpButton() {
        return driver.findElement(By.className("v-btn--is-elevated"));
    }

    public void clickOnSignMeUpButton() {
        getSignMeUpButton().click();
    }

    public void signupWithWrongCredentials() {
        getNameForSignup().sendKeys(name);
        getEmailforSignup().sendKeys(email);
        getPasswordforSignup().sendKeys(password);
        getConfirmPasswordforSignup().sendKeys(confirmPassword);
        clickOnSignMeUpButton();
    }

    public WebElement getPopupMessage() {
        return driver.findElement(By.className("v-snack__wrapper"));
    }

    public void signupSuccessfully() {
        String validNameForSignup = "Nikola Stevanovic";
        String validEmailForSignup = "nikola.stevanovic1@itbootcamp.rs";

        getNameForSignup().sendKeys(validNameForSignup);
        getEmailforSignup().sendKeys(validEmailForSignup);
        getPasswordforSignup().sendKeys(password);
        getConfirmPasswordforSignup().sendKeys(confirmPassword);
        clickOnSignMeUpButton();
    }

}
