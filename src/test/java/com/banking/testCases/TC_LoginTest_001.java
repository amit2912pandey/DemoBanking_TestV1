package com.banking.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.Reporting;


public class TC_LoginTest_001 extends BaseClass 
{

	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("URL is Opened");


		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Username is entered");
		
		lp.setPassword(password);
		logger.info("Password is entered");

		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
//			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
//			Reporting.captureScreen(driver, "loginTest");
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
			

		}else 
		{
//			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			Reporting.captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");

		}


	}

}
