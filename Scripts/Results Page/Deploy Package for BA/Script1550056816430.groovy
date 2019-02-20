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

'Placing the cursor in Global Search bar'
WebUI.click(findTestObject('Recent Activity/Global Search bar'))

'Passing the Text in to Global Search Bar'
WebUI.sendKeys(findTestObject('Recent Activity/Global Search bar'), 'T-BA-05275')

'Performing Search Action'
WebUI.sendKeys(findTestObject('Results page/Keyboard Enter_Search-bar'), Keys.chord(Keys.ENTER))

'Wating to Load elements on UI'
WebUI.delay(5)

'Clicking on machine checkbox'
WebUI.click(findTestObject('Results page/FirstChkBox'))

'Clicking on Run Action Dropdown'
WebUI.click(findTestObject('Results page/Run Action Dropdown'))

'Wating to Load elements on UI'
WebUI.delay(2)

'Clicking on Run Script Action'
WebUI.click(findTestObject('Results page/Deploy Package'))

'Wating to Load elements on UI'
WebUI.delay(5)

'Entering the package name to search'
WebUI.setText(findTestObject('Results page/Search Package'), 'TestPackage')

'Selecting the Package'
WebUI.click(findTestObject('Results page/Select Second Radio button'))

'Clicking on Continue button'
WebUI.click(findTestObject('Results page/Select Pkg Continue button'))

'Wating to Load elements on UI'
WebUI.delay(2)

'Clicking on Schedule now radio button'
WebUI.click(findTestObject('Results page/Schedule_Now_Radio'))

'Clicking on Expiry Never radio button'
WebUI.click(findTestObject('Results page/Expiry_Never_Radio'))

'Checking In case error checkbox'
WebUI.click(findTestObject('Results page/In Case of Error Checkbox'))

'Clicking Completion checkbox'
WebUI.click(findTestObject('Results page/Completion_Checkbox'))

'Entering mail id'
WebUI.setText(findTestObject('Results page/Notify Text Field'), 'test@email.com')

'Clicking on Continue'
WebUI.click(findTestObject('Results page/Schedule_Continue_Button'))

'Wating to Load elements on UI'
WebUI.delay(2)

'CLicking on Deploy button'
WebUI.click(findTestObject('Results page/Deploy Button'))

'Closing the dialog'
WebUI.click(findTestObject('Results page/Dialog Close'))

'Closing the browser'
WebUI.closeBrowser()

