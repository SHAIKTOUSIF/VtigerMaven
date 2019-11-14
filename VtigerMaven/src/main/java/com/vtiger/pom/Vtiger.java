package com.vtiger.pom;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.vtiger.generic.IAutoConstant;

public class Vtiger implements IAutoConstant{
	
	
	public  Vtiger(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public  void verifyHomePageIsDisplayed(WebDriver driver,long ETO,String title) throws EncryptedDocumentException, InvalidFormatException 
	{	
		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log("HomePage is Displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Home Page is not displayed",true);
			Assert.fail();
		}
	}
	public void verifyLeadsIsDisplay(WebDriver driver, long ETO, String title1) {
		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title1));
			Reporter.log("Leads Page is Displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Leads Page is not displayed",true);
			Assert.fail();
		}
	}
	public void createLeadButtonCheck(WebDriver driver, long ETO, String title) {
		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log(" Create Lead button is working",true);
		}
		catch(Exception e)
		{
			Reporter.log("Create Lead button is not working",true);
			Assert.fail();
		}
	}
	public void cancelButtonCheck(WebDriver driver, long ETO, String title) {
		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log(" Cancel button is working",true);
		}
		catch(Exception e)
		{
			Reporter.log("Cancel button is not working",true);
			Assert.fail();
		}
	}
 	public void createLeadwithMandatoryField(WebDriver driver, long ETO, String title) {
 		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log("Lead information page is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Lead information page is not displayed",true);
			Assert.fail();
		}
 	}
 	public void deleteButtonCheck(WebDriver driver, long ETO, String title) {
 		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log("The Lead is Deleted",true);
		}
		catch(Exception e)
		{
			Reporter.log("The Lead is not Deleted",true);
			Assert.fail();
		}
 	}
 	public void createLeadwithoutMandatoryField(WebDriver driver, long ETO, String title) {
 		title=driver.switchTo().alert().getText();
 		if(title!="Company cannot be empty") {
 			Reporter.log("Leads is not created",true);
 		}
 		else
 			Reporter.log("Lead is crated", true);
 	}
 	public void createLeadwithwrongEmailid(WebDriver driver, long ETO, String title) {
 		title=driver.switchTo().alert().getText();
 		if(title!="Please enter a valid Secondary Email (EMAIL)") {
 			Reporter.log("Leads is not created because of Incorrect email",true);
 		}
 		else
 			Reporter.log("Lead is created", true);
 	}
	public void editLead(WebDriver driver, long ETO, String title) {
 		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log("Lead information page is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Lead information page is not displayed",true);
			Assert.fail();
		}
	}
	public void createLeadWithQuickCreateusingUser(WebDriver driver, long ETO, String title) {
		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log("Lead information page is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Lead information page is not displayed",true);
			Assert.fail();
		}
	}
	public void createLeadWithQuickCreateusingGroup(WebDriver driver, long ETO, String title) {
		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log("Lead information page is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Lead information page is not displayed",true);
			Assert.fail();
		}
	}
}
	


