package com.banking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;
import com.banking.utilities.Reporting;

public class TC_LoginDDT_002 extends BaseClass 
{

	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");

		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			System.out.println("Login failed ------");
			Reporting.captureScreen(driver, "TC_LoginDDT_002");
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login Failed !!!!");
		}
		else
		{
//			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
//			Reporting.captureScreen(driver, "TC_LoginDDT_002");
			Assert.assertTrue(true);
			logger.info("login passed !!!!");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}


	public boolean isAlertPresent()
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}


	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/banking/testData/LoginData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "Sheet1");

		int colCount = XLUtils.getCellCount(path, "Sheet1",1);


		String loginData[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) 
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1",i,j);
			}

		}

		return loginData;


	}

}
