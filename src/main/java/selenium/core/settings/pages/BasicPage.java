package selenium.core.settings.pages;


import org.openqa.selenium.By;
import selenium.core.settings.framework.BasePage;


import static selenium.core.settings.framework.Utils.isElementPresent;

public class BasicPage extends BasePage {

    public final static By logoutBy = By.xpath("//a[contains(text(), 'Logout')]");
    public final static By flash = By.xpath("//p[@class='flash']");

    public LoginPage forceLogout() {
        driver.get(settings.getBaseUrl());
        if (isElementPresent(logoutBy)) {
            driver.findElement(logoutBy).click();
        }
        return initPage(LoginPage.class);
    }

    public String getFlashMessage() {
        if (isElementPresent(flash)) {
            return driver.findElement(flash).getText();
        }
        return null;
    }
}
