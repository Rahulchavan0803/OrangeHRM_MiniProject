package StepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.AddEmployee;
import PageObjects.DeleteEmployee;
import PageObjects.LoginPage;
import PageObjects.SearchEmployee;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Steps extends BaseClass {
	
	boolean status;
	String expEmpName;
	String recordDetails;
	
	@Before
	public void browser_SetUp() throws IOException
	{
		logger = Logger.getLogger("OrangeHRM_MiniProject");		//Added logger
		PropertyConfigurator.configure("log4j.properties");		//Added logger (location of log4j pro.)
		
		configProp_Obj = new Properties();
		FileInputStream configFileInputStream=new FileInputStream("config.properties");
		configProp_Obj.load(configFileInputStream);
		
		String br=configProp_Obj.getProperty("browser");
		
		if(br.equals("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 driver.manage().window().maximize();
		}
			   
	   logger.info("Launching Browser");					//logger
	}


		
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	  
	   loginPageObj=new LoginPage(driver);
	
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		
		logger.info("Opening URL");								
		driver.get(url);
	
	}

	@When("User Enters username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password){
		
		logger.info("Providing login details - UserName and Password");			
		loginPageObj.setUserName(username);
		loginPageObj.setpassword(password);
		
	}

	@When("Click on Login")
	public void click_on_login() {
		
		logger.info("Start Login Process");			
		loginPageObj.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String Title) {
		if(driver.getTitle().equals(Title))
		{
			System.out.println(driver.getTitle()+"Title is pass");
			logger.info("Login TestCase will be Pass");
		}
		else
		{
			System.out.println(driver.getTitle()+"Title is Fails");
			logger.info("Login TestCase will be Pass");
		}
	}

	@When("User click on profile link")
	public void user_click_on_profile_link() {
		
		logger.info("Click on Profile Menu");				
		loginPageObj.clickonProfile();
	}

	@When("click on Logout link")
	public void click_on_logout_link(){
		
		logger.info("Click on Logout button");				
		loginPageObj.clickLogout();
	}

	@Then("close the browser")
	public void close_the_browser() {
		
		logger.info("Close the Browser");					
		driver.close();
	}
	
	
	// Add new Employee Steps//
	
	
	@When("User click on PIM menu function")
	public void user_click_on_pim_menu_function(){
		
		logger.info("Click on PIM Menu button");
		addEmpObj=new AddEmployee(driver);
		addEmpObj.Clickon_PIM_menu();
	
	}
	@When("Click on Add button")
	public void click_on_add_button() {
		
		logger.info("Click on Add button");
		addEmpObj.Clickon_Add_button();
	
	}
	@When("Enter Employee Information {string}{string}{string}")
	public void enter_employee_information(String FirstName, String MiddleName, String LastName) {
		
		logger.info("Adding new Employee ");
		logger.info("Providing Employee Details");
		
		addEmpObj.setfirstName(FirstName);
		addEmpObj.setmiddleName(MiddleName);
		addEmpObj.setlastName(LastName);		
	}
	
	@When("click on Save button")
	public void click_on_save_button() {
	  
		logger.info("Saving Employee Data");
		addEmpObj.Clickon_save_bnt();		
	
	}
	@Then("Employee Added Successfully")
	public void employee_added_successfully() {
		
		
		if(driver.getPageSource().contains("Employee Full Name"))
		{
			System.out.println("Employee Add Successfully");
			logger.info("Employee Added successfully");
		}
		
		else
		{
			System.out.println("Employee Not Add Successfully");
			logger.info("Employee Not Added successfully");
		}
	}
	
	
	//		Search Employee		//
	
	
	@When("clicks on Employee List menu Opn")
	public void clicks_on_employee_list_menu_opn() {
	  
		logger.info("Click on Employee List Menu link");
		searchEmpObj = new SearchEmployee(driver);
		searchEmpObj.EmpList();
		
	}
	
	@When("User should Enter Employee FirstName {string}")
	public void user_should_enter_employee_first_name(String EmployeeName) {
		
		logger.info("Searching Employee by FirstName");
		searchEmpObj.Employee_Name(EmployeeName);
		expEmpName = EmployeeName;
	
	}

	@Then("Click on Search button")
	public void click_on_search_button() {
	    
		logger.info("Click on Search button");
		searchEmpObj.Click_on_Searchbtn();
	
	}

	@Then("it displays results")
	public void it_displays_results() throws InterruptedException{

		searchEmpObj.Validation(expEmpName);
	
	}
	
	
	// 	Delete Employee	//
	
	
	@When("User clicks on checkbox button")
	public void user_clicks_on_checkbox_button() throws InterruptedException {
		
		deleteEmpObj = new DeleteEmployee(driver);
		Thread.sleep(3000);
		deleteEmpObj.select_CheckBox();
		logger.info("Click on Select button ");
	
	}
	@When("clicks on delete button")
	public void clicks_on_delete_button() {
		
    
		deleteEmpObj.delect_Button();
		logger.info("Click on Delete button");
		
	}
	@Then("confirmation pop up will appear")
	public void confirmation_pop_up_will_appear() {
	    
		deleteEmpObj.popUp_Confirmation_window();
		logger.info("Confirmation pop Up");
	
	}
	@Then("record will be deleted")
	public void record_will_be_deleted() throws InterruptedException {
	    
		
		Thread.sleep(6000);		
		status = driver.getPageSource().contains("No Records Found");
	
		try {
			
			Assert.assertTrue(status);
			logger.info(expEmpName+ "successfully got deleted");
			logger.info("Delete Employee test case passed");
		}
		catch (Exception e) {
			
			logger.info("Delete Employee test case failed i.e user still exists in database");
		}
	}
	
}
