Feature: Scenarios related to Employee

	Background: Background steps
		Given User Launch Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User Enters username as "Admin" and Password as "admin123"
    And Click on Login
		

	@AddEmployee
  Scenario Outline: Add a new Employee
    When User click on PIM menu function
    And Click on Add button
    When Enter Employee Information <FirstName><MiddleName><LastName>
    And click on Save button
    Then Employee Added Successfully
    Then close the browser
    
   
   Examples:
	|FirstName|MiddleName	|LastName	|
	|"Rahul"	|"Gorakhnath"	|"Chavan"	|


	@SearchEmployee
	Scenario Outline: Search Employee by Using FirstName
		When User click on PIM menu function
		And clicks on Employee List menu Opn
		And User should Enter Employee FirstName <EmployeeName>
		Then Click on Search button
		Then it displays results
    Then close the browser
		
		Examples:
	|EmployeeName|
	|"Fiona" |
		
	
	
	@DeleteEmployee
	Scenario Outline: Delete Employee by Using FirstName
		When User click on PIM menu function
		And clicks on Employee List menu Opn
		And User should Enter Employee FirstName <EmployeeName>
		Then Click on Search button
		Then it displays results
		When User clicks on checkbox button
    And clicks on delete button
    Then confirmation pop up will appear
    And record will be deleted
    Then close the browser
    
 		Examples:
	|EmployeeName|
	|"David" |
	
		
  
	
		
		
		
				