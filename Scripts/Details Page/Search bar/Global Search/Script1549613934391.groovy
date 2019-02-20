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

for (i = 1; i < 5; i++) {
	
'Placing the cursor in Global Search bar'
WebUI.click(findTestObject('Recent Activity/Global Search bar'))

'Passing the Text in to Global Search Bar'
WebUI.sendKeys(findTestObject('Recent Activity/Global Search bar'), findTestData('Search Bar').getValue(1, +(i)))

'Performing Search Action'
WebUI.sendKeys(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Search Bar Keyboard Enter'), Keys.chord(
            Keys.ENTER))

'Waiting to load Search Results'
WebUI.delay(18)

'Count of search Results'
String Results = WebUI.getText(findTestObject('Dashboard/Total Results Count Updated'))

'Printing the results'
println('Filtered Results for Searched Text:- ' +Results)

'Verifying i value for clear icon action'
if(i>1)
	{

    'Clearing the Search bar' 
	WebUI.click(findTestObject('Dashboard/Search Clear'))
	}
}

'Closing the browser'
WebUI.closeBrowser()
