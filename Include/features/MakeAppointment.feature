@makeappointment

Feature: Create a Make Appointment

	Background: Pre-Condition User Success Login
		Given User Navigated to url "https://katalon-demo-cura.herokuapp.com/"
    And User go to CURA Healthcare Service page
    And User click Make Appointment button
    And User go to login CURA Healthcare Service page
    And User Input valid credential username is <username> and password is <password>
    And User click login button
    And Verify user successfully login with valid credential

	@createAppointment
	Scenario Outline: User Successfully Create a Make Appointment
		When User choose Fasility "Tokyo CURA Healthcare Center"
		And User click checkbox Apply for hospital readmission
		And User click Healthcare Program "Medicare"
		And User choose Visit Date "15/01/2025"
		And User input Comment "Visit for Healthcare"
		And User click Book Appointment
		Then Validate Appointment Confirmation Book is Successfully
		And User click go to homepage button
		
		Examples: 
      | username | password           |
      | John Doe | ThisIsNotAPassword |