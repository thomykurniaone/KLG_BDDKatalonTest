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



class MakeAppointment {
	@When("User choose Fasility (.*)")
	def user_choose_fasility(String fasilityName) {
		WebUI.click(findTestObject("//select[@id='combo_facility']"))
		
		if (fasilityName.equalsIgnoreCase("Tokyo CURA Healthcare Center")) {
			WebUI.click(findTestObject("//*[@id='combo_facility']//following-sibling::*[text()='Tokyo CURA Healthcare Center']"))
		} else if (fasilityName.equalsIgnoreCase("Hongkong CURA Healthcare Center")) {
			WebUI.click(findTestObject("//*[@id='combo_facility']//following-sibling::*[text()='Hongkong CURA Healthcare Center']"))
		} else if (fasilityName.equalsIgnoreCase("Seoul CURA Healthcare Center")) {
			WebUI.click(findTestObject("//*[@id='combo_facility']//following-sibling::*[text()='Seoul CURA Healthcare Center']"))
		}
		
		WebUI.takeScreenshotAsCheckpoint("User choose fasility", FailureHandling.STOP_ON_FAILURE)
	}
	
	@And("User click checkbox Apply for hospital readmission")
	def user_click_checkbox_apply_for_hospital_readmission() {
		WebUI.click(findTestObject("//*[@id='chk_hospotal_readmission']"))
		
		WebUI.takeScreenshotAsCheckpoint("User click checkbox Apply for hospital readmission", FailureHandling.STOP_ON_FAILURE)
	}
	
	@And("User click Healthcare Program (.*)")
	def user_click_healthcare_program(String healthcareProgram) {
		if (healthcareProgram.equalsIgnoreCase("Medicare")) {
			WebUI.click(findTestObject("//*[normalize-space()='Medicare']"))
		} else if (healthcareProgram.equalsIgnoreCase("Medicaid")) {
			WebUI.click(findTestObject("//*[normalize-space()='Medicaid']"))
		} else if (healthcareProgram.equalsIgnoreCase("None")) {
			WebUI.click(findTestObject("//*[normalize-space()='None']"))
		}
		
		WebUI.takeScreenshotAsCheckpoint("User click Healthcare Program", FailureHandling.STOP_ON_FAILURE)
	}
	
	@And("User choose Visit Date (.*)")
	def user_choose_visit_date(String visitDate) {
		WebUI.setText("//input[@id='txt_visit_date']", visitDate)T
		
		WebUI.takeScreenshotAsCheckpoint("User choose Visit Date", FailureHandling.STOP_ON_FAILURE)
	}
	
	@And("User input Comment (.*)")
	def user_input_comment(String commentar) {
		WebUI.setText("//textarea[@id='txt_comment']", commentar)T
		
		WebUI.takeScreenshotAsCheckpoint("User input Comment", FailureHandling.STOP_ON_FAILURE)
	}
	
	@And("User click Book Appointment")
	def user_click_book_appointment() {
		WebUI.click(findTestObject("//button[@id='btn-book-appointment']"))
		
		WebUI.takeScreenshotAsCheckpoint("User click Book Appointment", FailureHandling.STOP_ON_FAILURE)
	}
	
	@Then("Validate Appointment Confirmation Book is Successfully")
	def validate_appointment_confirmation_book_is_successfully() {
		String currentUrl = WebUI.getUrl()
		WebUI.verifyEqual(currentUrl, 'https://katalon-demo-cura.herokuapp.com/appointment.php#summary')
		
		WebUI.takeScreenshotAsCheckpoint("Validate Appointment Confirmation Book is Successfully", FailureHandling.STOP_ON_FAILURE)
	}
	
	@And("User click go to homepage button")
	def user_click_go_to_homepage_button() {
		WebUI.click(findTestObject("//a[normalize-space()='Go to Homepage']"))
		
		WebUI.takeScreenshotAsCheckpoint("User click go to homepage button", FailureHandling.STOP_ON_FAILURE)
	}
}