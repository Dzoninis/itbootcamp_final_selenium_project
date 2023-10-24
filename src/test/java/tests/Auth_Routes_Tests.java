package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RetryAnalyzer;

public class Auth_Routes_Tests extends Basic_Test {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");
    }

}
