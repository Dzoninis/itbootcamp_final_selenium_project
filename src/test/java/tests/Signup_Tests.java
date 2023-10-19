package tests;

import org.testng.annotations.Test;
import pages.RetryAnalyzer;

public class Signup_Tests extends Basic_Test {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage() {
        nav_page.clickToSignupButton();
        nav_page.waitForUrlContainsSignup();
    }

}
