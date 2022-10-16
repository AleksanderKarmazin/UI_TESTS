package selenium.core.settings.framework;


import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenManager {

    public void FailedScreenshot(String testMethodName) {
        File srcFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
        String TimeStamp = getDateTime();
        try {
            FileUtil.copyFile(srcFile, new
                    File("src\\test\\resources\\Screens "
                    + TimeStamp + "  " + testMethodName + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat(" dd/MM/yy/HH/mm/ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


}
