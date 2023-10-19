package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup_Page extends Basic_Page {

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

}
