package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RetryAnalyzer;

public class Locale_Tests extends Basic_Test {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void SetLocaleToES() {
        nav_page.clickOnLanguagebutton();
        nav_page.clickOnSpanishLanguage();
        Assert.assertEquals(nav_page.getTextFromHeader(),
                "Página de aterrizaje",
                "Text in header should be 'Página de aterrizaje' ");
    }

}
