package com.solvd.carinademoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id = "login2")
    private ExtendedWebElement loginButton;

    @FindBy(id = "nameofuser")
    private ExtendedWebElement welcomeAdminButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public boolean checkWelcomeAdminButtonIsClickable() {
        return welcomeAdminButton.isClickable();
    }

    public String getWelcomeAdminText() {
        return welcomeAdminButton.getText();
    }

    public void setCookie(String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();
    }
}
