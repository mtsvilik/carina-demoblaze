package com.solvd.carinademoblaze.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "loginusername")
    private ExtendedWebElement userNameField;

    @FindBy(id = "loginpassword")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@class='btn btn-primary'][contains(text(), 'Log in')]")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(userNameField);
    }

    public void typeUserName(String userName) {
        userNameField.type(userName);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String userName, String password) {
        typeUserName(userName);
        typePassword(password);
        clickLoginButton();
    }
}
