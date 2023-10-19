package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RetryAnalyzer;

public class Login_Tests extends Basic_Test {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitTheLoginPage() {
        nav_page.clickOnLanguagebutton();
        nav_page.clickOnEnglishLanguage();
        Assert.assertTrue(nav_page.isEnglishLanguagePresented(), "English language is not presented");

        nav_page.clickOnLoginButton();
        Assert.assertTrue(nav_page.isLoginPresented(), "Login button is not presented");
        Assert.assertEquals(nav_page.getCurrentUrl(), baseUrl + "/login",
                "Url route does not contains '/login' ");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        nav_page.clickOnLoginButton();
        loginPage.getAtributeValueForEmail();
        Assert.assertEquals(loginPage.getAtributeValueForEmail(), "email",
                "Email field doesn't have atribute type value 'email' ");

        loginPage.getAtributeValueForPassword();
        Assert.assertEquals(loginPage.getAtributeValueForPassword(), "password",
                "Password field doesn't have atribute type value 'password' ");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist() {
        nav_page.clickOnLoginButton();
        loginPage.setEmail();
        loginPage.setPassword();
        loginPage.getLoginButton().click();
        message_pop_up_page.waitUntilPopUpMessageIsVisible();
        Assert.assertEquals(message_pop_up_page.getTextFromPopUpMessage(),
                "User does not exists",
                "Message from Pop-up should be 'User does not exists' ");
        Assert.assertEquals(nav_page.getCurrentUrl(),
                baseUrl + "/login",
                "Url route does not contains '/login' ");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";

        nav_page.clickOnLoginButton();
        loginPage.getEmail().sendKeys(email);
        loginPage.setPassword();
        loginPage.getLoginButton().click();
        message_pop_up_page.waitUntilPopUpMessageIsVisible();
        Assert.assertEquals(message_pop_up_page.getTextFromPopUpMessage(),
                "Wrong password",
                "Message from Pop-up should be 'Wrong password' ");
        Assert.assertEquals(nav_page.getCurrentUrl(),
                baseUrl + "/login",
                "Url route does not contains '/login' ");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login() {
        String email = "admin@admin.com";
        String password = "12345";

        nav_page.clickOnLoginButton();
        loginPage.getEmail().sendKeys(email);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginButton().click();
        nav_page.waitForUrlContainsLogin();
    }

}
