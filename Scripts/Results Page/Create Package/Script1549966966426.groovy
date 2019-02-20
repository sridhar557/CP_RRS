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

'Clicking on Online Status link'
WebUI.click(findTestObject('Object Repository/Results page/div_Online'))

'Clicking on Run Action Dropdown'
WebUI.click(findTestObject('Object Repository/Results page/span_Run Action arrow_drop_dow'))

'Clicking on Create package link'
WebUI.click(findTestObject('Object Repository/Results page/Create Package'))

'Waiting for Create Package page to load'
WebUI.waitForElementVisible(findTestObject('Results page/CP_Pakg name'), 100)

'Enterring package name'
WebUI.setText(findTestObject('Object Repository/Results page/CP_Pakg name'), 'TestPackageQA')

'Generic xpath for Version fields'
for (i = 1; i < 5; i++) {
	TestObject to2 = findTestObject('Object Repository/Results page/CP_Version')

	to2.findProperty('xpath').setValue((('(//form/div/div/div[2]/div/div[2]/input)[') + i) + ']')

	WebUI.sendKeys(to2, '70')
}

'Entering Description'
WebUI.setText(findTestObject('Object Repository/Results page/CP_Description'), 'Test QA Description')

'Enable Retries toggle'
WebUI.click(findTestObject('Object Repository/Results page/CP_Enable retries'))

'Clicking on Create button'
WebUI.click(findTestObject('Object Repository/Results page/CP_Create'))

'Closing the dialog'
WebUI.click(findTestObject('Object Repository/Results page/CP_successdialog_Close'))

'Closing the browser'
WebUI.closeBrowser()

