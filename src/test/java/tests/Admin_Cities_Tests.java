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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreate_EditNewCity() {
//        nav_page.clickOnLoginButton();
//        nav_page.visitAdminCitiesPageWithAdminCredentials();
        nav_page.clickOnAdminButton();
        nav_page.clickOnCities();
        nav_page.waitUntilUrlContainsAdminCitiesroute();
        cities_page.clickOnNewItemButton();
        cities_page.waitUntilDialogeForEditAndCreateCityIsVisible();
        Assert.assertEquals(cities_page.getAtributeValueForName(), "text",
                "Name input field should have atribute value 'text'");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity() {
        String nameOfCity = "Nikola Stevanovic's city";

//        nav_page.clickOnLoginButton();
//        nav_page.visitAdminCitiesPageWithAdminCredentials();
        nav_page.clickOnAdminButton();
        nav_page.clickOnCities();
        nav_page.waitUntilUrlContainsAdminCitiesroute();
        cities_page.clickOnNewItemButton();
        cities_page.waitUntilDialogeForEditAndCreateCityIsVisible();

        cities_page.enterNameOfCity(nameOfCity);
        cities_page.clickOnSaveCityButton();
        cities_page.waitUntilPopMessageForSavedCityIsVisible();
        Assert.assertTrue(cities_page.getMessageTextFromPopupForNewCity(),
                "Message for saving new city should be 'Saved successfully' ");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity() {
        String oldCityName = "Nikola Stevanovic's city";
        String newCityName = "Nikola Stevanovic's city Edited";

//        nav_page.clickOnLoginButton();
//        nav_page.visitAdminCitiesPageWithAdminCredentials();
        nav_page.clickOnAdminButton();
        nav_page.clickOnCities();
        nav_page.waitUntilUrlContainsAdminCitiesroute();
        cities_page.searchForOldNameOfCity(oldCityName);

        cities_page.waitUntilNumberOfRowsOfCitiesInSearchIs(1);
        cities_page.clickOnEditButtonFromRow();
        cities_page.enterNameOfCity(newCityName);
        cities_page.clickOnSaveCityButton();
        cities_page.waitUntilPopMessageForSavedCityIsVisible();
        Assert.assertTrue(cities_page.getMessageTextFromPopupForNewCity(),
                "Message for saving city should be 'Saved successfully' ");
    }

}