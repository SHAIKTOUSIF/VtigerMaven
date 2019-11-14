package com.vtiger.testpom;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.Excel;
import com.vtiger.pom.Vtiger;



import com.vtiger.pom.LoginPage;;

public class Leads extends  BaseTest{
	@Test
	public static void validLogin() throws EncryptedDocumentException, InvalidFormatException, InterruptedException
	{
	String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
	String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
	String title= Excel.getData(XL_PATH,SHEET_NAME,1,2);
	LoginPage lp = new LoginPage(driver);
	lp.inputUN(un);
	lp.inputPWD(pwd);
	lp.loginClick();
	Vtiger vt = new Vtiger(driver);
	vt.verifyHomePageIsDisplayed(driver, 2, title);
	}
	
	@Test
	public static void LeadButtonCheck() throws Exception {
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		//String title= Excel.getData(XL_PATH,SHEET_NAME,1,2);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		String title1= Excel.getData(XL_PATH,SHEET_NAME,2,2);
		Vtiger vt =new Vtiger(driver);
		vt.verifyLeadsIsDisplay(driver, 3, title1);
	}
	@Test
	public static void CreateLeadButtonCheck() throws InterruptedException
	{
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		//String title= Excel.getData(XL_PATH,SHEET_NAME,1,2);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		Thread.sleep(3000);
		lp.CreateLeadClick();
		String title= Excel.getData(XL_PATH,SHEET_NAME,3,2);
		Vtiger vt =new Vtiger(driver);
		vt.createLeadButtonCheck(driver, 5,title);
	}
	@Test
	public static void CancelLeadsButtonCheck() throws InterruptedException {
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		//String title= Excel.getData(XL_PATH,SHEET_NAME,1,2);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		Thread.sleep(3000);
		lp.CreateLeadClick();
		Thread.sleep(2000);
		lp.CancelButtonClick();
		String title= Excel.getData(XL_PATH,SHEET_NAME,4,2);

		Vtiger vt=new Vtiger(driver);
		vt.cancelButtonCheck(driver, 5, title);
	}
	@Test
	public static void CreateLeadwithMandatoryField() throws InterruptedException {
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		//String title= Excel.getData(XL_PATH,SHEET_NAME,1,2);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		Thread.sleep(3000);
		lp.CreateLeadClick();
//		String ln= Excel.getData(XL_PATH,SHEET_NAME,6,0);
//		String co= Excel.getData(XL_PATH,SHEET_NAME,6,1);
//		lp.lastName(ln);
//		lp.comName(co);
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Tousif");
		driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("TYSS");
		lp.saveButtonClick();
		String title= Excel.getData(XL_PATH,SHEET_NAME,4,2);
		Vtiger vt=new Vtiger(driver);
		vt.createLeadwithMandatoryField(driver, 5, title);
	}
	@Test
	public static void deleteButtonCheck() throws InterruptedException {
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr[@bgcolor=\"white\"][1]/td[1]")).click();
	
		driver.findElement(By.xpath("//td/table[2]/tbody/tr[1]/td/input[@value=\"Delete\"]")).click();
		driver.switchTo().alert().accept();
		String title= Excel.getData(XL_PATH,SHEET_NAME,4,2);
		Vtiger vt=new Vtiger(driver);
		vt.deleteButtonCheck(driver, 5,title);
	}
	@Test
	public static void CreateLeadwithoutMandatoryField() throws InterruptedException {
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		Thread.sleep(3000);
		lp.CreateLeadClick();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Prasanna");
		//driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("TYSS");
		lp.saveButtonClick();
		String title= driver.switchTo().alert().getText();
		Vtiger vt=new Vtiger(driver);
		vt.createLeadwithoutMandatoryField(driver, 5, title);
	}
	@Test
	public static void CreateLeadwithwrongEmailid() throws InterruptedException {
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		Thread.sleep(3000);
		lp.CreateLeadClick();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Basheer");
		driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("Wipro");
		driver.findElement(By.xpath("//input[@name=\"secondaryemail\"]")).sendKeys("bas12gmail.com");
		lp.saveButtonClick();
		String title= driver.switchTo().alert().getText();
		Vtiger vt=new Vtiger(driver);
		vt.createLeadwithwrongEmailid(driver, 5, title);
	}
	@Test
	public static void EditLead() throws Exception {
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		Thread.sleep(3000);
		lp.CreateLeadClick();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Tanveer");
		driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("TCS");
		lp.saveButtonClick();
		driver.findElement(By.xpath("//td[@class=\"dvtTabCache\"]/input[@title=\"Edit [Alt+E]\"]")).click();
		String title= Excel.getData(XL_PATH,SHEET_NAME,4,2);
		Vtiger vt=new Vtiger(driver);
		vt.editLead(driver, 5,title);
	}
	@Test
	public static void CreateLeadWithQuickCreateusingUser() throws Exception {
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		Thread.sleep(2000);
		WebElement quickSEarch = driver.findElement(By.xpath("//select[@onchange=\"QCreate(this);\"]"));
		quickSEarch.click();
		Select s=new Select(quickSEarch);
		s.selectByIndex(10);
		driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("IBM");
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Tahir");
		driver.findElement(By.xpath("//input[@value=\"  Save\"]")).click();
		String title= Excel.getData(XL_PATH,SHEET_NAME,4,2);
		Vtiger vt=new Vtiger(driver);
		vt.createLeadWithQuickCreateusingUser(driver, 5,title);
	}
	@Test
	public static void CreateLeadWithQuickCreateusingGroup() throws InterruptedException {
		String un = Excel.getData(XL_PATH,SHEET_NAME,1,0);
		String pwd = Excel.getData(XL_PATH,SHEET_NAME,1,1);
		LoginPage lp = new LoginPage(driver);
		lp.inputUN(un);
		lp.inputPWD(pwd);
		lp.loginClick();
		Thread.sleep(5000);
		lp.leadClick();
		Thread.sleep(2000);
		WebElement quickSEarch = driver.findElement(By.xpath("//select[@onchange=\"QCreate(this);\"]"));
		quickSEarch.click();
		Select s=new Select(quickSEarch);
		s.selectByIndex(10);
		driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("IBM");
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Pavan");
		driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		driver.findElement(By.xpath("//select[@name=\"assigned_group_id\"]")).click();
		driver.findElement(By.xpath("//select[@name=\"assigned_group_id\"]/option[2]")).click();
		driver.findElement(By.xpath("//input[@value=\"  Save\"]")).click();
		String title= Excel.getData(XL_PATH,SHEET_NAME,4,2);
		Vtiger vt=new Vtiger(driver);
		vt.createLeadWithQuickCreateusingGroup(driver, 5,title);
	}
}
