package selenium.core.settings.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import selenium.core.settings.framework.BasePage;
import selenium.core.settings.models.file.FileData;
import selenium.core.settings.models.folder.FolderData;


import java.util.ArrayList;

import static selenium.core.settings.framework.Utils.*;

public class DiskPage extends BasePage {


    @FindBy(xpath = CREATE_ENTITY_BUTTON_XPATH)
    WebElement createEntityButton;
    @FindBy(xpath = CREATE_FOLDER_ICON_XPATH)
    WebElement createFolderIcon;
    @FindBy(xpath = CREATE_FILE_ICON_XPATH)
    WebElement createFileIcon;
    @FindBy(xpath = ENTITY_INPUT_TEXT_FIELD_XPATH)
    WebElement entityInputField;
    @FindBy(xpath = SUBMIT_CREATION_BUTTON_XPATH)
    WebElement submitCreationButton;
    @FindBy(xpath = SUBMIT_CREATION_FOR_FILE_BUTTON_XPATH)
    WebElement submitCreationForFileButton;

    public HomePage goToDiskPage() throws InterruptedException {
        driver.get("https://disk.yandex.ru/client/disk");
        Thread.sleep(3000);
        return initPage(HomePage.class);
    }

    public HomePage createFolder(FolderData folder)  {
        createEntityButton.click();
        createFolderIcon.click();
        waitForElementPresent(entityInputField);
        forceCleanInput(entityInputField);
        entityInputField.sendKeys(folder.getFolderName());
        submitCreationButton.click();
        return initPage(HomePage.class);
    }

    public HomePage createFile(FileData file)  {
        createEntityButton.click();
        createFileIcon.click();
        waitForElementPresent(entityInputField);
        forceCleanInput(entityInputField);
        entityInputField.sendKeys(file.getFileName());
        submitCreationForFileButton.click();
        return initPage(HomePage.class);
    }

    public HomePage closeSecondTabAndSwitchToFirstTab()  {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        return initPage(HomePage.class);
    }

    public HomePage openFolder(FolderData folder) throws InterruptedException {
        Actions action = new Actions(driver);
        String locator = "//*[@class=\"listing-item__title listing-item__title_overflow_clamp\"]/span[contains(text(),\"" + folder.getFolderName() + "\")]";
        WebElement elementFolder = driver.findElement(By.xpath(locator));
        action.doubleClick(elementFolder).perform();
        Thread.sleep(3000);
        return initPage(HomePage.class);
    }

    public HomePage assertFileWasCreated(FileData file) throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(1,
                driver.findElements(
                        By.xpath("//*[@class=\"clamped-text\"][contains(text(),\"" + file.getFileName() + "\")]"))
                            .size());
        return initPage(HomePage.class);
    }


//    Folder  locators
    public static final String CREATE_ENTITY_BUTTON_XPATH = "//span[2]/button";
    public static final String CREATE_FILE_ICON_XPATH = "//button[2]/span";
    public static final String ENTITY_INPUT_TEXT_FIELD_XPATH = "//form/span/input";
    public static final String SUBMIT_CREATION_BUTTON_XPATH = "//div/div[2]/button";

//    File locators
    public static final String CREATE_FOLDER_ICON_XPATH = "//div[3]/div/button/span";
    public static final String SUBMIT_CREATION_FOR_FILE_BUTTON_XPATH = "//*[@class=\"Button2 Button2_view_action Button2_size_m confirmation-dialog__button confirmation-dialog__button_submit \"]";


}
