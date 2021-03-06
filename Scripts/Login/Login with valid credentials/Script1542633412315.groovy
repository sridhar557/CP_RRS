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


CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

'Launching the URL'
WebUI.openBrowser('https://cpdevapi.rrs360.com/login')

'Maximizing the Browser Window'
WebUI.maximizeWindow()

'Clicking on Signin button'
WebUI.click(findTestObject('Page_Login/SignIn'))

'Highlight Username Field'
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.on'(findTestObject('Page_Login/Username'))

'Entering valid username'
WebUI.sendKeys(findTestObject('Page_Login/Username'), 'rrssuperadmin@techolution.com')

'Highlight Password Field'
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.on'(findTestObject('Page_Login/Password'))


'Entering valid password'
WebUI.sendKeys(findTestObject('Page_Login/Password'), 'j@mIefR0s7')

'Highlight Signin button'
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.on'(findTestObject('Page_Login/Sign In button'))

'Clicking on SignIn Button'
WebUI.click(findTestObject('Page_Login/Sign In button'))

'Closing the browser'
WebUI.closeBrowser()