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

}
