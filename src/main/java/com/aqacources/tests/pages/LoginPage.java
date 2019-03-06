package com.aqacources.tests.pages;

import com.aqacources.tests.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marina on 19.02.2019.
 */
public class LoginPage extends AbstractPage {

    // Web Elements
    @FindBy(
            xpath =
                    "//form[@id='login_form']/descendant::div[@class='form-group']/input[@data-validate='isEmail']"
    )
    private WebElement fieldLogin;

    @FindBy(
            xpath =
                    "//form[@id='login_form']/descendant::div[@class='form-group']/span/input[@type='password']"
    )
    private WebElement fieldPassword;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement submitButton;

    /**
     * Constructor
     *
     * @param testClass
     */
    public LoginPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Enter login and password and click to Submit Button
     *
     * @return new instance of MyAccountPage
     */
    public MyAccoutPage signIn(String login, String password) {
        fieldLogin.sendKeys(login);
        fieldPassword.sendKeys(password);
        submitButton.click();
        return new MyAccoutPage(testClass);
    }
}
