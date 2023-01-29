package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class LoginPage {
	
WebDriver driver;
	WaitHelper waithelper;
	
	public LoginPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(rdriver);
	}
	@FindBy(name = "username")
	WebElement txtusername;
	
	@FindBy(name = "password")
	WebElement txtpassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement bntLogin;
	
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement clickProfile;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement clickLogout;

	public void setUserName(String usern)
	{
		waithelper.WaitforElement(txtusername, Duration.ofSeconds(20));
		txtusername.sendKeys(usern);
	}
	public void setpassword(String pass)
	{
		waithelper.WaitforElement(txtpassword, Duration.ofSeconds(20));
		txtpassword.sendKeys(pass);
	}
	public void clickLogin()
	{
		waithelper.WaitforElement(bntLogin, Duration.ofSeconds(20));
		bntLogin.click();
	}
	public void clickonProfile()
	{
		waithelper.WaitforElement(clickProfile, Duration.ofSeconds(20));
		clickProfile.click();
	}
	public void clickLogout()
	{
		waithelper.WaitforElement(clickLogout, Duration.ofSeconds(20));
		clickLogout.click();
	}
}
