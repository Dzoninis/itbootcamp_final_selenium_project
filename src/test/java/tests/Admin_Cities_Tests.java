package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RetryAnalyzer;

public class Admin_Cities_Tests extends Basic_Test {


    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VisitsTheAdminCitiesPageAndListCities() {
        nav_page.clickOnLoginButton();
        nav_page.visitAdminCitiesPageWithAdminCredentials();
        nav_page.clickOnAdminButton();
        nav_page.clickOnCities();
        nav_page.waitUntilUrlContainsAdminCitiesroute();
        Assert.assertEquals(nav_page.getCurrentUrl(), baseUrl + "/admin/cities",
                "Url route does not contain '/admin/cities' ");
    }

}