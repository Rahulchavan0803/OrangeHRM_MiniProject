package StepDefinations;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.AddEmployee;
import PageObjects.DeleteEmployee;
import PageObjects.LoginPage;
import PageObjects.SearchEmployee;


public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginPageObj;
	public AddEmployee addEmpObj;
	public SearchEmployee searchEmpObj;
	public DeleteEmployee deleteEmpObj;
	public static Logger logger;
	public Properties configProp_Obj;
	

}
