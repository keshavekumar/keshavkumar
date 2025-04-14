package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComMyaccountPage;
import pageObjects.ComhomePage;
import testBase.CombaseClass;

public class TC_01login extends CombaseClass {

    @Test(groups = {"sanity", "master"})
    public void verifyLogin() {
        logger.info("Starting the login test case...");

        try {
            // Step 1: Enter username & password
            ComhomePage hpl = new ComhomePage(driver);
            logger.info("Entering username and password...");

            String username = p.getProperty("username");
            String password = p.getProperty("password");

            if (username == null || password == null) {
                logger.error("Username or password not provided in the properties file.");
                Assert.fail("Username or password not provided in the properties file.");
                return;
            }

            hpl.setUsername(username);
            hpl.setuserpassword(password);

            hpl.clicklogin();

            // Step 2: Verify My Account Page is displayed
            ComMyaccountPage macc = new ComMyaccountPage(driver);

            logger.info("Waiting for My Account page to load...");
            boolean targetPage = macc.isMyAccountPageExist();

            // Enhanced assertion with a more detailed message
            Assert.assertTrue(targetPage, "My Account page should be displayed after successful login.");

            logger.info("Login test case passed!");

        } catch (Exception e) {
            // Provide detailed error message with the exception
            logger.error("Login test case failed due to exception: " + e.getMessage());
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }

        logger.info("Finished the login test case.");
    }
}
