package TestModules.Base;

import Pages.HomePage;
import data.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest implements ITestListener{
    protected static UserModel user;
    protected WebDriver driver;

    protected HomePage homePage;
    private WebDriverWait wait;

    private static Logger logger = LogManager.getLogger();


    /*    @BeforeTest
    public void beforeTest(){
        user = new UserModel();
    }*/
    @BeforeSuite
    public void beforeSuite(ITestContext context){
        logger.info("Starting " + context.getSuite().getName() + "Test Suite...");
    }
    @AfterSuite
    public void afterSuite(ITestContext context){
        logger.info("Ending " + context.getSuite().getName() + "Test Suite...");
    }

    @BeforeClass
    @Parameters({"URL","BrowserType"})
    public void setUp(String url, String browserType, ITestContext context) {
        logger.info("Starting " + context.getCurrentXmlTest().getClass().getName() + "Test Class...");
        if (browserType.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }
        else if (browserType.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(url);
    }
    //@BeforeMethod
    public void goHome(){
        driver.get("https://demo.nopcommerce.com/");
    }
    @BeforeMethod
    public void beforeMethod(ITestResult result){
        logger.info("Starting " + result.getMethod().getMethodName() + "Test Method...");

    }

    @AfterMethod
    public void tearMethod(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getMethod().getMethodName());
            logger.error("Error in " + result.getMethod().getMethodName() + "Test Method...");
        }
        logger.info("Ending " + result.getMethod().getMethodName() + "Test Method...");
    }
    @AfterClass
    public void tearDown(){
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException e) {
                System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
                throw e;
                //System.out.println(e);
            }
        }
    }

    //@Override
    /*public void onTestFailure(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getMethod().getMethodName());
        }
    }*/

    private void captureScreenshot(String methodName) {
        //LocalDateTime currentDateTime = LocalDateTime.now();
        // Define a formatter for YYYY-MM-DD hh:mm format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
        // Format the current date and time to YYYY-MM-DD hh:mm format
        String formattedDateTime = LocalDateTime.now().format(formatter);

        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create a directory if it doesn't exist
            // Update with your desired directory
            String screenshotDirectory = "C:\\Users\\DKRORY\\IdeaProjects\\NopCommerce\\Screenshots";
            Path directoryPath = Path.of(screenshotDirectory);
            Files.createDirectories(directoryPath);

            // Save the screenshot to the specified directory
            Path screenshotPath = directoryPath.resolve(methodName + formattedDateTime + ".png");

            // Use FileOutputStream to write the screenshot bytes
            try (FileOutputStream fos = new FileOutputStream(screenshotPath.toFile())) {
                fos.write(Files.readAllBytes(screenshotFile.toPath()));
            }

            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void timer(long time){
        try {
            // Sleep for 1 second (1000 milliseconds)
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }
    /*@DataProvider
    public Object[][] Authentication() throws Exception{
        String sTestCaseName;
        int iTestCaseRow;
        // Setting up the Test Data Excel file
        ExcelUtils.setExcelFile("C:\\Users\\DKRORY\\IdeaProjects\\NopCommerce\\src\\test\\java\\LoginData.xlsx","Sheet1");
        sTestCaseName = this.toString();
        // From above method we get long test case name including package and class name etc.
        // The below method will refine your test case name, exactly the name use have used
        sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
        // Fetching the Test Case row number from the Test Data Sheet
        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
        Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\DKRORY\\IdeaProjects\\NopCommerce\\src\\test\\java\\LoginData.xlsx","Sheet1",iTestCaseRow);
        return (testObjArray);
    }*/
}

