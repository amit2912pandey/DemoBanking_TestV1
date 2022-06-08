package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rbGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDOB;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinno;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtTelephoneno;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmailid;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
//	//*[@id="dismiss-button"]
	@FindBy(how = How.XPATH, using = "//*[@id=\"dismiss-button\"]")
	@CacheLookup
	WebElement btnAdDismiss;
	
	
	
	public void clickAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void enterCustName(String cName)
	{
		txtCustomerName.sendKeys(cName);
	}
	
	public void custgender(String cgender) 
	{
		rbGender.click();
	}

	public void custdob(String mm,String dd,String yy) 
	{
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
		
	}

	public void custaddress(String caddress) 
	{
		txtAddress.sendKeys(caddress);
	}

	public void custcity(String ccity) 
	{
		txtCity.sendKeys(ccity);
	}

	public void custstate(String cstate) 
	{
		txtState.sendKeys(cstate);
	}

	public void custpinno(String cpinno) 
	{
		txtPinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) 
	{
		txtTelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) 
	{
		txtEmailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) 
	{
		txtPassword.sendKeys(cpassword);
	}

	public void custsubmit() 
	{
		btnSubmit.click();
	}	
	
	public void clickDismissAd()
	{
		btnAdDismiss.click();
	}
	
	
	
}
