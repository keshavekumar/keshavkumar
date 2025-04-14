package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ComhomePage;
import pageObjects.ComMyaccountPage;
import testBase.CombaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
 */

public class TC_003_loginDDT extends CombaseClass
{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String username, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");

		try {

			//Home page
			ComhomePage hp=new ComhomePage(driver);
			hp.setUsername(username);
			hp.setuserpassword(password);

			hp.clicklogin();

			//My Account Page
			ComMyaccountPage macc=new ComMyaccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExist();

			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(true);  // pass
				}
				else
				{
					Assert.assertTrue(false);
				}
			}

			if(exp.equalsIgnoreCase("Invalid"))   // negative data   username and password 
			{
				if(targetPage==true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);    // passs
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("**** Finished TC_003_LoginDDT *****");
	}

}
