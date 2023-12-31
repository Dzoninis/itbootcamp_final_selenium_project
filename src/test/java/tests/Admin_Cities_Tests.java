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
        cities_page.waitUntilDialogeForEditAndCreateCityIsVisible();
        cities_page.enterNameOfCity(newCityName);
        cities_page.clickOnSaveCityButton();
        cities_page.waitUntilPopMessageForSavedCityIsVisible();
        Assert.assertTrue(cities_page.getMessageTextFromPopupForNewCity(),
                "Message for saving city should be 'Saved successfully' ");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity() {
        String cityName = "Nikola Stevanovic's city Edited";

//        nav_page.clickOnLoginButton();
//        nav_page.visitAdminCitiesPageWithAdminCredentials();
        nav_page.clickOnAdminButton();
        nav_page.clickOnCities();
        nav_page.waitUntilUrlContainsAdminCitiesroute();
        cities_page.searchForOldNameOfCity(cityName);
        cities_page.waitUntilNumberOfRowsOfCitiesInSearchIs(1);
        Assert.assertEquals(cities_page.getTextFromCertainNameCell(),
                cityName, "Text from certain row in Name field should be " + cityName);
    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void deleteCity() {
        String cityName = "Nikola Stevanovic's city Edited";

//        nav_page.clickOnLoginButton();
//        nav_page.visitAdminCitiesPageWithAdminCredentials();
        nav_page.clickOnAdminButton();
        nav_page.clickOnCities();
        nav_page.waitUntilUrlContainsAdminCitiesroute();
        cities_page.searchForOldNameOfCity(cityName);
        cities_page.waitUntilNumberOfRowsOfCitiesInSearchIs(1);
        Assert.assertEquals(cities_page.getTextFromCertainNameCell(),
                cityName, "Text from certain row in Name field should be " + cityName);

        cities_page.clickOnDeleteButtonFromFirstRow(1);
        cities_page.waitUntilMessageForDeleteCityIsVisible();
        cities_page.clickOnConfirmDeleteButtonFromDialoge();
        message_pop_up_page.waitUntilPopUpMessageForDeleteCityIsVisible();
        Assert.assertTrue(message_pop_up_page.getTextFromPopUpMessageForDeletedCity(),
                "Pop-up message should contains text 'Deleted successfully' ");
    }
}