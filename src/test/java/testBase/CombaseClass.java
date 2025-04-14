package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CombaseClass {
    public Logger logger;
    public static WebDriver driver;
    public Properties p;

    @BeforeClass(groups = {"sanity", "regression", "master"})
    public void setup() throws IOException {
        logger = LogManager.getLogger(this.getClass()); // Log4j setup
        
        // Loading properties file
        FileReader file = new FileReader(".//src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        // Setting up WebDriver and navigating to the application URL
        driver = new ChromeDriver();
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        logger.info("Setup completed, browser launched and navigated to " + p.getProperty("appURL"));
    }

    @AfterClass(groups = {"sanity", "regression", "master"})
    public void teardown() {
        // Close the browser and quit the WebDriver
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed and WebDriver quit.");
        }
    }

    public String captureScreen(String tname) throws IOException {
        // Generate timestamp for the screenshot file name
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Capture screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Create the target path for the screenshot
        String targetDir = System.getProperty("user.dir") + "\\screenshots\\";
        File targetDirFile = new File(targetDir);

        // Ensure the target directory exists
        if (!targetDirFile.exists()) {
            targetDirFile.mkdirs();
            logger.info("Screenshots directory created at: " + targetDir);
        }

        // Define the target file path
        String targetFilePath = targetDir + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        // Copy the screenshot to the target path
        Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        logger.info("Screenshot captured and saved to: " + targetFilePath);

        // Return the path of the saved screenshot
        return targetFilePath;
    }
}
