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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/profile");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");
    }
}
