package selenium.core.settings.framework;


import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Utils {

    private static WebDriver driver = BasePage.driver;

    public static void waitForElementPresent(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void forceCleanInput(WebElement element) {
        String inputText = element.getAttribute("value");
        if( inputText != null ) {
            for(int i=0; i<inputText.length();i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        }
    }


    public static <string> String crateId() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return  uuidAsString.substring(0,6);
    }



    public static boolean isElementPresent(String xpath) {
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public static boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public static String getText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public static void openNewTab(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public static void switchTab(int tabNum) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNum));
    }

    public static void scrollDown() {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static <string> void selectByVisibleText(string locator, string searchText) {
        new Select((WebElement) locator).selectByVisibleText((String) searchText);
    }

    public static <string> String getNumberFromJson(string json, string key) {
        JSONObject obj = new JSONObject(json);
        String numberFromJson = String.valueOf(obj.getNumber((String) key));
        return  numberFromJson;
    }

    public static <string> String getStringFromJson(string json, string key) {
        JSONObject obj = new JSONObject(json);
        String stringFromJson = String.valueOf(obj.getString((String) key));
        return  stringFromJson;
    }



    public static String closeAlertAndGetItsText() {
        boolean acceptNextAlert = true;
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public static <string> String getStringResultAfterExecutionOfJavaScript(String scriptOfJS) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String stringResult = String.valueOf(
                js.executeScript(scriptOfJS));
        return  stringResult;
    }








}

