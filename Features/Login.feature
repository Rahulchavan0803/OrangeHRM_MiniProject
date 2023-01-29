Feature: Login in Guru99V4 Application

  Scenario: Testing Login functionalty with valid Data
    Given User Launch Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User Enters username as "Admin" and Password as "admin123"
    And Click on Login
    Then Page Title should be "OrangeHRM"
    When User click on profile link
    And click on Logout link
    Then close the browser
      