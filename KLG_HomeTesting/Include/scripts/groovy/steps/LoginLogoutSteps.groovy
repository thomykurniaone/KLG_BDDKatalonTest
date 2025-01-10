package steps
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginLogoutSteps {

	@And("User go to CURA Healthcare Service page")
	def user_go_to_cura_healthcare_service_page() {
		WebUI.verifyTextPresent("CURA Healthcare Service", false)
		WebUI.verifyTextPresent("We Care About Your Health", false)
		WebUI.verifyElementPresent("//*[@id='btn-make-appointment']", 1)
		WebUI.takeScreenshotAsCheckpoint("User go to Homepage", FailureHandling.STOP_ON_FAILURE)
	}

	@And("User click Make Appointment button")
	def user_click_make_appointment_button() {
		WebUI.verifyElementPresent("//*[@id='btn-make-appointment']", 1)
		WebUI.click(findTestObject("//*[@id='btn-make-appointment']"))
		WebUI.takeScreenshotAsCheckpoint("User click Make Appointment button", FailureHandling.STOP_ON_FAILURE)
	}

	@And("User go to login CURA Healthcare Service page")
	def user_go_to_login_cura_healthcare_service_page() {
		WebUI.verifyTextPresent("Login", false)
		WebUI.verifyTextPresent("Please login to make appointment.", false)
		WebUI.verifyElementPresent("Page_CURA Healthcare Service/input_Username_username", 1)
		WebUI.verifyElementPresent("Page_CURA Healthcare Service/input_Password_password", 1)
		WebUI.verifyElementPresent("Page_CURA Healthcare Service/button_Login", 1)
		WebUI.takeScreenshotAsCheckpoint("User go to Login Page", FailureHandling.STOP_ON_FAILURE)
	}

	@When("User Input valid credential username is (.*) and password is (.*)")
	def user_navigated_to_url(String username, String password) {
		WebUI.setText(findTestObject('Page_CURA Healthcare Service/input_Username_username'), username)
		WebUI.setText(findTestObject('Page_CURA Healthcare Service/input_Password_password'), password)
		WebUI.takeScreenshotAsCheckpoint("User input valid credentials", FailureHandling.STOP_ON_FAILURE)
	}

	@And("User click login button")
	def user_click_login_button() {
		WebUI.verifyElementPresent("Page_CURA Healthcare Service/button_Login", 1)
		WebUI.click(findTestObject("Page_CURA Healthcare Service/button_Login"))
		WebUI.takeScreenshotAsCheckpoint("User click Login button", FailureHandling.STOP_ON_FAILURE)
	}

	@And("User click logout button")
	def user_click_logout_button() {
		WebUI.verifyElementPresent("//*[text()='Logout']", 1)
		WebUI.click(findTestObject("//*[text()='Logout']"))
		WebUI.takeScreenshotAsCheckpoint("User click Login button", FailureHandling.STOP_ON_FAILURE)
	}

	@Then("Verify user successfully login with valid credential")
	def verify_user_successfully_login_with_valid_credential() {
		String currentUrl = WebUI.getUrl()
		WebUI.verifyEqual(currentUrl, 'https://katalon-demo-cura.herokuapp.com/#appointment')
		WebUI.takeScreenshotAsCheckpoint("User Successfully Login with Valid Credential", FailureHandling.STOP_ON_FAILURE)
	}

	@Then("Verify user failed to login and error message showed")
	def Verifyuserfailedtologin() {
		String currentUrl = WebUI.getUrl()
		WebUI.verifyEqual(currentUrl, 'https://katalon-demo-cura.herokuapp.com/profile.php#login')
		WebUI.verifyElementPresent(findTestObject("//*[@class='lead text-danger' and text()='Login failed! Please ensure the username and password are valid.']"),0)
		WebUI.takeScreenshotAsCheckpoint("User failed login with message error", FailureHandling.STOP_ON_FAILURE)
	}

	@Then("Verify user successfully direct to homepage")
	def verify_user_successfully_direct_to_homepage() {
		String currentUrl = WebUI.getUrl()
		WebUI.verifyEqual(currentUrl, 'https://katalon-demo-cura.herokuapp.com/')
		WebUI.takeScreenshotAsCheckpoint("User Successfully user go to Homepage", FailureHandling.STOP_ON_FAILURE)
	}
}