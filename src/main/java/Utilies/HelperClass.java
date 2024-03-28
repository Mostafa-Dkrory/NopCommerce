/*
package Utilies;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HelperClass {
    private static HelperClass helperClass;
    private static WebDriver driver;
    //private static WebDriver driver = new ChromeDriver();

    private HelperClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void openPage(@NotNull String url) { driver.get(url);}

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (helperClass==null) {helperClass = new HelperClass();}
    }


    public static void tearDown() {
        if(driver!=null) {
            driver.close();
            driver.quit();
        }
        helperClass = null;
    }
}*/
