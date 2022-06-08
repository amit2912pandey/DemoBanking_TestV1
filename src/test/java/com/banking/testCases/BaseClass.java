package com.banking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig rc = new ReadConfig();
	
	public String baseURL = rc.getApplicationUrl();
	public String userName = rc.getUsername();
	public String password = rc.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	public String ssPathTaken;
	public static ChromeOptions options;
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rc.getChromePath());
			driver = new ChromeDriver();
		}
		else if (br.equals("edge")) 
		{
			System.setProperty("webdriver.edge.driver",rc.getMsEdgePath());
			driver = new EdgeDriver();
		}
		else if (br.equals("firefox")) 
		{
			System.setProperty("webdriver.firefox.driver",rc.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

//	public void captureScreen(WebDriver driver, String tname) throws IOException
//	{
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
////		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
//		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+"_"+timeStamp+".png");
//		FileUtils.copyFile(source, target);
//		System.out.println("Screenshot is taken");
//		
//		ssPathTaken = System.getProperty("user.dir")+"/Screenshots/"+tname+"_"+timeStamp+".png";
//		
//	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(8);
		return generatedString;
	}
	
}
