import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Launching the URL'
WebUI.openBrowser('https://cpdevapi.rrs360.com/login')

'Maximizing the Browser Window'
WebUI.maximizeWindow()

'Clicking on Signin button'
WebUI.click(findTestObject('Page_Login/SignIn'))

'Entering the username'
WebUI.sendKeys(findTestObject('Page_Login/Username'), 'rrssuperadmin@techolution.com')

'Entering the password'
WebUI.sendKeys(findTestObject('Page_Login/Password'), 'j@mIefR0s7')

'Clicking on SignIn Button'
WebUI.click(findTestObject('Page_Login/Sign In button'))

'Clicking on Go To Dashboard button'
WebUI.click(findTestObject('Dashboard/Dashboard/Go To Dashboard'))

'Clicking on Main Menu link'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Main Menu'), FailureHandling.STOP_ON_FAILURE)

'Delay to page load'
WebUI.delay(3)

'Performing mouse scroll to make customer element visible on UI'
WebUI.scrollToElement(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/a_Profile'), 0)

'Clicking on Profile menu option'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/a_Profile'))

'Delay to page load'
WebUI.delay(3)

'Clicking on Save permissions button'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Save Permissions'))

'Clicking Yes in the confirmation popup'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Confirm Yes'))

'Clicking on Close icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Confirm_Close'))

'Clicking on Close icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Confirm_Close'))

'Clicking on Close icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Confirm_Close'))

'Clicking on user profile Icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Profile Icon'))

'Clicking on logout link'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_Logout'))

'Closing the browser'
WebUI.closeBrowser()