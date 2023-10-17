package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Tests extends Basic_Test {

    @Test(priority = 1)
    public void visitTheLoginPage() {
        nav_page.clickOnLanguagebutton();
        nav_page.clickOnEnglishLanguage();
        Assert.assertTrue(nav_page.isEnglishLanguagePresented(), "English language is not presented");

        nav_page.clickOnLoginButton();
        Assert.assertTrue(nav_page.isLoginPresented(), "Login button is not presented");
        Assert.assertEquals(nav_page.getCurrentUrl(), baseUrl + "/login",
                "Url route does not contains '/login' ");
    }


}
