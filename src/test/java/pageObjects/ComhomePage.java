package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComhomePage extends CombasePage {

	public WebDriver driver;
	public ComhomePage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement Registerlink;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@name='Log In']")
	WebElement btnlogin;
	
	
	public void setUsername(String uname)
	{
		txt_username.sendKeys(uname);
	}
	public void setuserpassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	public void clicklogin()
	{
		btnlogin.click();
	}
	public void clickRegister()
	{
		Registerlink.click();
	}
		
	}
	
	
