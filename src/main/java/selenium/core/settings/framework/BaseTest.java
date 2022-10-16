package selenium.core.settings.framework;

import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    private static Settings settings = new Settings();

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() {
        BasePage.driver = settings.getDriver();
        BasePage.settings = settings;
        BasePage.driver.get(settings.getBaseUrl());
        BasePage.driver.manage().window().maximize();
        BasePage.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterSuite(alwaysRun = true)
    public static void afterClass() {
        BasePage.driver.quit();
    }
}
