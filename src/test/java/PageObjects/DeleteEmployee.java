package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class DeleteEmployee {
	
	WebDriver driver;
	String popupWindow;
	WaitHelper waithelper;
	String record;
	
	public DeleteEmployee(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waithelper = new WaitHelper(driver);
		
		
	}
	@FindBy(xpath = "(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]")
	WebElement selectCheckbox;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
	WebElement deletebnt;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	WebElement popupConfir_Ok_bnt;
	
	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span'])[1]")
	WebElement record_deleted;
	
	public void select_CheckBox() 
	{
		//waithelper.WaitforElement(selectCheckbox, Duration.ofSeconds(20));
		selectCheckbox.click();
	}
	public void delect_Button()
	{
		waithelper.WaitforElement(deletebnt, Duration.ofSeconds(20));
		deletebnt.click();
	}
	public void popUp_Confirmation_window()
	{
		waithelper.WaitforElement(popupConfir_Ok_bnt, Duration.ofSeconds(20));
		popupWindow = driver.getWindowHandle();
		driver.switchTo().window(popupWindow);
		popupConfir_Ok_bnt.click();
	}
	public String record_Deleted()
	{
		record = record_deleted.getText();
		return record;
	}
}
