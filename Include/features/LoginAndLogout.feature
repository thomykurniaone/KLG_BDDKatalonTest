@loginandlogout
Feature: Login and Logout

  Background: 
    Given User Navigated to url "https://katalon-demo-cura.herokuapp.com/"
    And User go to CURA Healthcare Service page
    And User click Make Appointment button
    And User go to login CURA Healthcare Service page

	@validCredentials
  Scenario Outline: Validate Successfully Login with Valid Credentials
    When User Input valid credential username is <username> and password is <password>
    And User click login button
    Then Verify user successfully login with valid credential

    Examples: 
      | username | password           |
      | John Doe | ThisIsNotAPassword |

      
  @invalidCredentials
  Scenario Outline: Validate Successfully Login with Valid Credentials
    When User Input valid credential username is <username> and password is <password>
    And User click login button
    Then Verify user failed to login and error message showed

    Examples: 
      | username | password |
      | Admin		 | admin123 |
  
  @logout
  Scenario Outline: Validate Successfully Login with Valid Credentials
    When User Input valid credential username is <username> and password is <password>
    And User click login button
    And Verify user successfully login with valid credential
    And User click burger button
    Then User click logout button
    And Verify user successfully direct to homepage
    
   Examples: 
      | username | password           |
      | John Doe | ThisIsNotAPassword |