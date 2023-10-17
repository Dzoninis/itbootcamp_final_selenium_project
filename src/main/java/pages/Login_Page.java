package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page extends Basic_Page {

    public Login_Page(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("v-btn--is-elevated"));
    }

    public String getAtributeValueForEmail() {
        return getEmail().getAttribute("type");
    }

    public String getAtributeValueForPassword() {
        return getPassword().getAttribute("type");
    }

}
