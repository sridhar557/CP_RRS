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

'Entering Password'
WebUI.sendKeys(findTestObject('Page_Login/Password'), 'j@mIefR0s7')

'Clicking on SignIn Button'
WebUI.click(findTestObject('Page_Login/Sign In button'))

'Clicking on Go To Dashboard button'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard/Go To Dashboard'))


'Placing the cursor in Global Search bar'
WebUI.click(findTestObject('Recent Activity/Global Search bar'))

'Passing the Text in to Global Search Bar'
WebUI.sendKeys(findTestObject('Recent Activity/Global Search bar'), 'T-BA-05275')

'Performing Search Action'
WebUI.sendKeys(findTestObject('Results page/Keyboard Enter_Search-bar'), Keys.chord(Keys.ENTER))

'Clicking on First machine from results list'
WebUI.click(findTestObject('Rev Alert Donut/NA_First Machine'))

'Wating to Load elements on UI'
WebUI.delay(2)

'Selecting the Script'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Script Selection'))

'Executing the Script'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Script Run'))

'Selecting Reports tab'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Reports Tab'))

'Wating to Load elements on UI'
WebUI.delay(1)

'Selecting report for execution'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Report Selection'))

'Executing the Report'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Report Run'))

'Selecting Note tab'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Notes Tab'))

'Wating to Load elements on UI'
WebUI.delay(1)

'Clicking on Create note'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Create Note'))

'Entering Note title'
WebUI.setText(findTestObject('Object Repository/Dashboard/Page_RRS/Note Title'), 'test autamtion note')

'Entering Note Description'
WebUI.setText(findTestObject('Object Repository/Dashboard/Page_RRS/Note Description'), 'test automation description')

'Saving the note'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Save Note'))

'Closing success dialog'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Close Success Dialog'))

'Downloading Recent Asctivity CSV file'
WebUI.click(findTestObject('Object Repository/Dashboard/Page_RRS/Download Recent Activity CSV'))

'Wating to Load elements on UI'
WebUI.delay(2)

'Closing the Browser'
WebUI.closeBrowser()
