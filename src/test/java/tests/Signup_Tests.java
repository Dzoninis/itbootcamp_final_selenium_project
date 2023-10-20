package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RetryAnalyzer;

public class Signup_Tests extends Basic_Test {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage() {
        nav_page.clickToSignupButton();
        nav_page.waitForUrlContainsSignup();
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        nav_page.clickToSignupButton();

        signup_page.getAtributeValueForEmail();
        Assert.assertEquals(signup_page.getAtributeValueForEmail(), "email",
                "Email field doesn't have atribute type value 'email' ");

        signup_page.getAtributeValueForPassword();
        Assert.assertEquals(signup_page.getAtributeValueForPassword(), "password",
                "Password field doesn't have atribute type value 'password' ");

        signup_page.getAtributeValueForConfirmPassword();
        Assert.assertEquals(signup_page.getAtributeValueForConfirmPassword(), "password",
                "Password field doesn't have atribute type value 'confirmPassword' ");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists() {
        nav_page.clickToSignupButton();
        nav_page.waitForUrlContainsSignup();
        signup_page.signupWithWrongCredentials();
        message_pop_up_page.waitUntilPopUpMessageIsVisible();

        Assert.assertEquals(message_pop_up_page.getTextFromPopUpMessage(),
                "E-mail already exists",
                "Error message should be 'E-mail already exists");
        nav_page.waitForUrlContainsSignup();
    }

}
