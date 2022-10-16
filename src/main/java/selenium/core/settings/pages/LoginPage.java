package selenium.core.settings.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import selenium.core.settings.framework.*;
import selenium.core.settings.models.user.User;

public class LoginPage extends BasePage {

    @FindBy(id = LOGIN_TEXT_FIELD_ID)
    WebElement loginTextField;
    @FindBy(id = PASSWORD_TEXT_FIELD_ID)
    WebElement passwordTextField;
    @FindBy(id = LOGIN_BUTTON_ID)
    WebElement loginButton;
    @FindBy(xpath = AUTH_BUTTON_XPATH)
    WebElement authButton;

    public HomePage loginAs(User user) throws InterruptedException {
        authButton.click();
        loginTextField.click();
        loginTextField.clear();
        loginTextField.sendKeys(user.getLogin());
        loginButton.click();
        passwordTextField.click();
        passwordTextField.clear();
        passwordTextField.sendKeys(user.getPassword());
        loginButton.click();
        Thread.sleep(3000);
        return initPage(HomePage.class);
    }


    public static final String AUTH_BUTTON_XPATH = "//*[@class=\"zen-ui-button-text__text\"][contains(text(), \"Войти\")]";
    public static final String LOGIN_TEXT_FIELD_ID = "passp-field-login";
    public static final String PASSWORD_TEXT_FIELD_ID = "passp-field-passwd";
    public static final String LOGIN_BUTTON_ID = "passp:sign-in";

    public static Boolean auth = Boolean.valueOf(Settings.auth);

}
