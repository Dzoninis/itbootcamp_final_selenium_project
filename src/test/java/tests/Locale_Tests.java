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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void SetLocaleToEN() {
        nav_page.clickOnLanguagebutton();
        nav_page.clickOnEnglishLanguage();
        Assert.assertEquals(nav_page.getTextFromHeader(),
                "Landing",
                "Text in header should be 'Landing' ");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void SetLocaleToCN() {
        nav_page.clickOnLanguagebutton();
        nav_page.clickOnChineseLanguage();
        Assert.assertEquals(nav_page.getTextFromHeader(),
                "首页",
                "Text in header should be '首页' ");
    }
}
