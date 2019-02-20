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

'Launching the URL'
WebUI.openBrowser('https://cpdevapi.rrs360.com/login')

'Maximizing the Browser Window'
WebUI.maximizeWindow()

'Clicking on Signin button'
WebUI.click(findTestObject('Page_Login/SignIn'))

'Entering the username'
WebUI.sendKeys(findTestObject('Page_Login/Username'), 'rrssuperadmin@techolution.com')

'Entering Password'
WebUI.sendKeys(findTestObject('Page_Login/Password'), 'j@mIefR0s7')

'Clicking on SignIn Button'
WebUI.click(findTestObject('Page_Login/Sign In button'))

'Clicking on Go To Dashboard button'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard/Go To Dashboard'))

'Clicking on Online Count'
WebUI.click(findTestObject('Rev_Availability_Chart/Online Count'))

'Gettiing first machine details'
String Machinename = WebUI.getText(findTestObject('Rev Alert Donut/NA_First Machine'))

'Printing Machine name from results list'
println(Machinename)

'Clicking on First machine from results list'
WebUI.click(findTestObject('Rev Alert Donut/NA_First Machine'))

'getting machine information from results page'
String Machine = WebUI.getText(findTestObject('Rev Alert Donut/Results page machine name'))

'Printing Machine name'
println(Machine)

if (Machinename.contains(Machine)) {
    println('Machine names matching')
} else {
    println('Machines not matching')
}

'Clicking on back button'
WebUI.click(findTestObject('Rev Alert Donut/Results Page Back Button'))

'Clicking on Main Menu'
WebUI.click(findTestObject('Dashboard/Main Menu Icon'))

'Clicking on Executive Dashboard option'
WebUI.doubleClick(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/a_Executive Dashboard'))


'Clicking on user profile Icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Profile Icon'))

'Clicking on logout link'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_Logout'))

'Closing the browser'
WebUI.closeBrowser()

