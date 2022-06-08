package com.banking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;
import com.banking.utilities.Reporting;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("user name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		
		addCust.clickAddNewCustomer();
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(3000);
//		
		driver.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
				
		Thread.sleep(3000);
		
		logger.info("customer details entered .....");
		addCust.enterCustName("Amit P");
		addCust.custgender("male");
		addCust.custdob("01", "01", "1987");
		Thread.sleep(3000);
		addCust.custaddress("INDIA");
		addCust.custcity("Lucknow");
		addCust.custstate("UP");
		addCust.custpinno("229406");
		addCust.custtelephoneno("9970876159");
		
		String emailId = randomString()+"@email.com";
		addCust.custemailid(emailId);
		
		addCust.custpassword("ABC123abc");
		addCust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		logger.info("Validation started.....");
		if (res == true) 
		{
			logger.info("test case is passed !!!!");
			Assert.assertTrue(true);
//			Reporting.captureScreen(driver, "TC_AddCustomerTest_003");
		} else 
		{
			logger.info("test case is failed !!!!");
			Assert.assertTrue(false);
			Reporting.captureScreen(driver, "TC_AddCustomerTest_003");
		}
		
		
	}
	
	

}
