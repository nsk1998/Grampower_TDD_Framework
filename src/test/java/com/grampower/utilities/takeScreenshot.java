package com.grampower.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.grampower.testcases.BaseClass;

public class takeScreenshot {
	
    public void captureScreenshot(WebDriver driver, String testName) throws IOException {
        // Step 1: Convert the WebDriver object to the TakesScreenshot interface
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Step 2: Call getScreenshotAs method to create an image file
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        // Define the destination path for saving the screenshot
        String destinationPath = "C:/Users/Lenovo/Desktop/Grampower_DataDrivenFramework/Grampower_DataDrivenFramework.zip_expanded/Grampower_DataDrivenFramework/Screenshots/";

        // Create the `dest` file using the destination path and testName
        File dest = new File(destinationPath + testName + ".png");

        // Step 3: Copy the image file to the destination
        FileUtils.copyFile(src, dest);
    }
}

