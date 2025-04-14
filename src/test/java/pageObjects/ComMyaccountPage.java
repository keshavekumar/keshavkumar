package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ComMyaccountPage extends CombasePage {

    public ComMyaccountPage(WebDriver driver) {
        super(driver);
    }

    // Locator for the "Log Out" button
    @FindBy(xpath="//a[normalize-space()='Log Out']") 
    WebElement btnlogout;
    
    // Method to click the "Log Out" button
    public void clickLogout() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(btnlogout));
            btnlogout.click();
        } catch (Exception e) {
            // Log exception if needed or rethrow it
            System.out.println("Error clicking on Log Out button: " + e.getMessage());
        }
    }

    // Locator for the heading or message on the page
    @FindBy(xpath = "//p[@class='smallText']")
    WebElement msgHeading;

    // Method to check if the "My Account" page exists (element is visible)
    public boolean isMyAccountPageExist() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(msgHeading));
            return msgHeading.isDisplayed();
        } catch (NoSuchElementException e) {
            // Element is not found
            System.out.println("Element not found: " + e.getMessage());
            return false;
        } catch (StaleElementReferenceException e) {
            // Element is no longer attached to the DOM, retrying could help
            System.out.println("Stale Element: " + e.getMessage());
            return false;
        } catch (Exception e) {
            // Any other exceptions
            System.out.println("Unexpected error: " + e.getMessage());
            return false;
        }
    }
}
