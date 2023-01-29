package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class AddEmployee {
	WebDriver driver;
	WaitHelper waithelper;
	
	public AddEmployee(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper= new WaitHelper(rdriver);
	}
		
	@FindBy(xpath = "//span[text()='PIM']")
	WebElement clickon_PIM_menu;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clickon_Add;
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement txt_FirstName;
	
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement txt_MiddleName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement txt_LastName;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickon_save;
	
	public void Clickon_PIM_menu()
	{
		waithelper.WaitforElement(clickon_PIM_menu, Duration.ofSeconds(20));
		clickon_PIM_menu.click();
	}
	public void Clickon_Add_button()
	{
		waithelper.WaitforElement(clickon_Add, Duration.ofSeconds(20));
		clickon_Add.click();
	}
	public void setfirstName(String firName)
	{
		waithelper.WaitforElement(txt_FirstName, Duration.ofSeconds(20));
		txt_FirstName.sendKeys(firName);
	}
	public void setmiddleName(String midName)
	{
		waithelper.WaitforElement(txt_MiddleName, Duration.ofSeconds(20));
		txt_MiddleName.sendKeys(midName);
	}
	public void setlastName(String lastName)
	{
		waithelper.WaitforElement(txt_LastName, Duration.ofSeconds(20));
		txt_LastName.sendKeys(lastName);
	}
	public void Clickon_save_bnt()
	{
		waithelper.WaitforElement(clickon_save, Duration.ofSeconds(20));
		clickon_save.click();
	}

}
