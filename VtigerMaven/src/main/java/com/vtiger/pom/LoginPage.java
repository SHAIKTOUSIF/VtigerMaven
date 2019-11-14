package com.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath ="//input[@name=\"user_name\"]")
	private WebElement un;
	@FindBy(xpath = "//input[@name=\"user_password\"]")
	private WebElement pwd;	
	@FindBy(xpath = "//input[@id=\"submitButton\"]")
	private WebElement loginBtn;	
	@FindBy(xpath ="//tr/td[@class=\"tabUnSelected\"][2]")
	private WebElement leadClk;
	@FindBy(xpath="//img[@alt=\"Create Lead...\"]")
	private WebElement CrtLd;
	@FindBy(xpath = "//tbody/tr[1]/td[@colspan=\"4\"]/div[@align=\"center\"]//input[@class=\"crmbutton small cancel\"]")
	private WebElement cnlbtn;
	@FindBy(xpath = "//tbody/tr[1]/td[@colspan=\"4\"]/div/input[@title=\"Save [Alt+S]\"]")
	private WebElement svbtn;
	@FindBy (xpath = "//input[@name=\\\"lastname\\\"]")
	private WebElement lastName;
	@FindBy (xpath = "//input[@name=\\\"company\\\"]")
	private WebElement cmp;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inputUN(String text)
	{
		un.sendKeys(text);	
	}
	public void inputPWD(String text)
	{
		pwd.sendKeys(text);	
	}
	public void loginClick()
	{
		loginBtn.click();
	}
	public void leadClick()
	{
		leadClk.click();
	}
	public void CreateLeadClick()
	{
		CrtLd.click();
	}
	public void CancelButtonClick() {
		cnlbtn.click();
	}
	public void saveButtonClick() {
		svbtn.click();
	}
	public void lastName(String text) {
		lastName.sendKeys(text);
	}
	public void comName(String text) {
		cmp.sendKeys(text);
	}
}
