package com.solvd.carinatest;

import com.solvd.carinademoblaze.pages.HomePage;
import com.solvd.carinademoblaze.pages.LoginPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isPageOpened());

        loginPage.login(R.TESTDATA.get("user_name"), R.TESTDATA.get("password"));

        homePage.checkWelcomeAdminButtonIsClickable();
        homePage.getWelcomeAdminText();
        Assert.assertEquals(homePage.getWelcomeAdminText(), R.TESTDATA.get("user_text"), "UserText is incorrect");
    }

    @Test
    public void authTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't open");
        homePage.setCookie(R.TESTDATA.get("cookie_name"), R.TESTDATA.get("cookie_value"));
        Assert.assertTrue(homePage.checkWelcomeAdminButtonIsClickable(), "CheckWelcomeAdminButton isn't clickable");
        Assert.assertEquals(homePage.getWelcomeAdminText(), "Welcome admin", "Welcome admin text is incorrect");
    }
}
