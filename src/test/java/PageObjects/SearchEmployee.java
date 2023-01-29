package PageObjects;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;
import junit.framework.Assert;

public class SearchEmployee {
	
	WebDriver driver;
	WaitHelper waithelper;
	public static Logger logger;
	String actEmpName;
	
	public SearchEmployee(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper= new WaitHelper(rdriver);
	}
	
	@FindBy(xpath = "//a[text()='Employee List']")
	WebElement EmpList;
	
	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	WebElement EmployeeName;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Searchbutton;
	
	@FindBy(xpath = "(//*[contains(@class,'oxd-table-cell oxd-padding-cell')][3])[1]")
	WebElement tabletxt;
	
	public void EmpList() {
		
		waithelper.WaitforElement(EmpList, Duration.ofSeconds(10));
		EmpList.click();
	}
	public void Employee_Name(String empname)
	{
		waithelper.WaitforElement(EmployeeName, Duration.ofSeconds(10));
		EmployeeName.sendKeys(empname);
		
	}
	public void Click_on_Searchbtn()
	{
		waithelper.WaitforElement(Searchbutton, Duration.ofSeconds(10));
		Searchbutton.click();
	}
	
	public void Validation(String expEmpName) throws InterruptedException
	{	
		Thread.sleep(2000);
		
		waithelper.WaitforElement(tabletxt, Duration.ofSeconds(10));
		
		logger=Logger.getLogger("OrangeHRM_MiniProject");
		PropertyConfigurator.configure("log4j.properties");
		actEmpName = tabletxt.getText();
		
		System.out.println("Actual Emp Name: "+actEmpName);
		
		Thread.sleep(2000);
		Assert.assertEquals(expEmpName, actEmpName);
		Thread.sleep(2000);
		
		
	}
	

}
