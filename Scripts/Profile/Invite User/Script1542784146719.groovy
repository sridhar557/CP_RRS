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

'Entering Username'
WebUI.sendKeys(findTestObject('Page_Login/Username'), 'rrssuperadmin@techolution.com')

'Entering Password'
WebUI.sendKeys(findTestObject('Page_Login/Password'), 'j@mIefR0s7')

'Clicking on SignIn button'
WebUI.click(findTestObject('Page_Login/Sign In button'))

'Clicking on User Profile icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Profile Icon'))

'Clicking on View Profile link'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_View Profile'))

'Clicking on Customer card'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Customers Card'))

'Clicking on invite user button'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Invite User'))

'Clicking on cutomer Admin radio button'
WebUI.doubleClick(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Customer Admin Radio button'))

'Clicking on company Dropdown '
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Company_Dropdown'))

'Selecting option from the dropdown list'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/AREAS USA - FLTP_DD_Option'))

'Clicking on Company input field'
String company = WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/input_Company_mat-input-0'))

'Entering values in company input field'
WebUI.sendKeys(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/input_Company_mat-input-0'), 'xzcrtddsdsgfgfvd@sdfdsfhgfuuj')

'Clicking on RRS button'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Invite to RRS_Button'))

'Closing the confirmation popup'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Popup_Close_Button'))

WebUI.delay(2)

'Clicking on user profile Icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Profile Icon'))

'Clicking on logout link'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_Logout'))

'Closing the browser'
WebUI.closeBrowser()

