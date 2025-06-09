package sania.pages;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String name) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "screenshots/" + name + "_" + timestamp + ".png";

        try {
            File dest = new File(fileName);
            FileUtils.copyFile(src, dest);
            System.out.println(" Screenshot saved at: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println(" Failed to save screenshot: " + e.getMessage());
        }
    }
}

