package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComhomePage;
import pageObjects.ComregisterPage;
import testBase.CombaseClass;

public class TC_01Register  extends CombaseClass {
	
	@Test(groups = {"regression","master"})
	void register()
	{
		
		logger.info("** Staring the case registration  ***");
		logger.info("** Staring the home page ***");
		ComhomePage hp=new ComhomePage(driver);
		hp.clickRegister();
		
		logger.info("** Staring the registration page ***");
		ComregisterPage rp=new ComregisterPage(driver);
		rp.firstName("peter");
		rp.lastName("jhon");
		rp.addressName("street01");
		rp.cityName("delhi");
		rp.stateName("delhi");
		rp.zipcodeNum("110038");
		rp.phoneNum("123654987");
		rp.ssnName("1234");
		rp.usernameName("asdf12346");
		rp.custPass("asdf123");
		rp.confPass("asdf123");
		rp.clickRegister();
		logger.info("** validation of  registration page ***");
		
		String expectedtitle="ParaBank";
		String actualtitle=driver.getTitle();
		
		if(expectedtitle.equals(actualtitle))
		{
			Assert.assertEquals(expectedtitle, actualtitle);
			System.out.println("login test pass");
		}
		else
		{
			System.out.println("login test case is fail");
		}
		logger.info("** end of the  registration page ***");
	}
		
		@Test(priority = 1, enabled =false )
		void register01()
		{
			
			logger.info("** Staring the case registration  ***");
			logger.info("** Staring the home page ***");
			ComhomePage hp=new ComhomePage(driver);
			hp.clickRegister();
			
			logger.info("** Staring the registration page ***");
			ComregisterPage rp=new ComregisterPage(driver);
			rp.firstName("peter");
			rp.lastName("jhon");
			rp.addressName("street01");
			rp.cityName("delhi");
			rp.stateName("delhi");
			rp.zipcodeNum("110038");
			rp.phoneNum("123654987");
			rp.ssnName("1234");
			rp.usernameName("asdf12346");
			rp.custPass("asdf123");
			rp.confPass("asdf123");
			rp.clickRegister();
			logger.info("** validation of  registration page ***");
			
		
		
		String expectedtitle="ParaBank";
		String actualtitle=driver.getTitle();
		
		if(expectedtitle.equals(actualtitle))
		{
			Assert.assertEquals(expectedtitle, actualtitle);
			System.out.println("login test pass");
		}
		else
		{
			System.out.println("login test case is fail");
		}
		logger.info("** end of the  registration page ***");
		
	}

}
