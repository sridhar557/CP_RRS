import java.util.regex.Matcher as Matcher

import java.util.regex.Pattern as Pattern
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
import org.openqa.selenium.support.Color as Color

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

'Clicking on User Experience Details Link'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/User Experience Details link'))

'Getting the Success Ratio value and Stroring it in String variable'
String SuccessRatio = WebUI.getText(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Success Ratio'))

'Extract text before %'
String Ratio = SuccessRatio.split('\\%')[0]

'Printing the Extracted text without %'
println('success ratio of User experience is '+Ratio)

'Getting the inner HTML code of the element'
def HtmlCode = WebUI.getAttribute(findTestObject('Dashboard/Dashboard/Pie Chart of User Exp'), 'innerHTML')


'Creating the Substring to get Color code'
String colorstring = HtmlCode.substring(260, 267)

'Printing color code'
println(colorstring)

'Coverting String value to Int'
double SRatio = Double.parseDouble(Ratio)

'Verifying and Validating Each color with the success ratio'
	if ((SRatio >= 99.30) && (SRatio <= 99.49)) {
		if (colorstring == '#B3B3B3') {
			println('Color of the Donut is GREY and success ratio is:' + SuccessRatio)
		}
	} 
	
	else if ((SRatio <= 99.29) && (colorstring == '#EA4646')) {
		println('Color of the Donut is Red and success ratio is:' + SuccessRatio)
	} 
	
	else if ((SRatio >= 99.50) && (colorstring == '#0A9729')) {
		println('Color of the Donut is Green and success ratio is:' + SuccessRatio)
	} 
	else {
		println('None of the Colors matched')
	}

'Waiting to page load for 3 seconds'
WebUI.delay(3)

'Performing Click on User Profile icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Profile Icon'))

'Clicking on Logout button'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_Logout'))

'Closing the Browser'
WebUI.closeBrowser()

