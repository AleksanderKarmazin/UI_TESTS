package sasha.is.the.best.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.core.settings.framework.BaseTest;
import selenium.core.settings.framework.TestStatusListener;
import selenium.core.settings.models.file.FileData;
import selenium.core.settings.models.folder.FolderData;
import selenium.core.settings.models.user.User;
import selenium.core.settings.pages.BasicPage;
import selenium.core.settings.pages.DiskPage;
import selenium.core.settings.pages.HeaderPage;
import selenium.core.settings.pages.LoginPage;


import java.util.ArrayList;


import static selenium.core.settings.framework.BasePage.driver;
import static selenium.core.settings.framework.BasePage.initPage;
import static selenium.core.settings.models.file.FileBuilder.yandexFile;
import static selenium.core.settings.models.folder.FolderBuilder.yandexFolder;
import static selenium.core.settings.models.user.UserBuilder.*;

@Listeners(TestStatusListener.class)
public class LoginTest extends BaseTest {


    private LoginPage loginPage;
    private BasicPage basicPage;
    private HeaderPage headerPage;
    private DiskPage diskPage;
    private User user;
    private FolderData folder;
    private FileData file;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        headerPage = initPage(HeaderPage.class);
        diskPage = initPage(DiskPage.class);
        user = yandexUser();
        folder = yandexFolder();
        file = yandexFile();
    }


    @Test
    public void yandexTest() throws InterruptedException {
        loginPage.loginAs(user);
        diskPage.goToDiskPage();
        diskPage.createFolder(folder);
        diskPage.openFolder(folder);
        diskPage.createFile(file);
        diskPage.closeSecondTabAndSwitchToFirstTab();
        diskPage.assertFileWasCreated(file);
    }
}