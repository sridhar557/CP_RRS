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

'Clicking on pull button'
WebUI.click(findTestObject('Object Repository/Recent Activity/Pull From button'))

'Entering Path of machine to Pull from'
WebUI.setText(findTestObject('Object Repository/Recent Activity/Path for Pull from'), 'C:/')

'Clicking Pull button'
WebUI.click(findTestObject('Object Repository/Recent Activity/Pull button'))

'Clicking on push to button'
WebUI.click(findTestObject('Object Repository/Recent Activity/Push To Button'))

'Clicking on browse button'
WebUI.click(findTestObject('Object Repository/Recent Activity/Browser button'))

CustomKeywords.'userdefinedkeywords.fileupload.dd'()

//dd()

//WebUI.setText(findTestObject('Object Repository/Recent Activity/Browser button'), 'C:\\\\Users\\\\TECHOLUTION\\\\Desktop\\\\RRS Issues Screenshots\\\\Katalon.txt')
WebUI.delay(5)

'Entering path for machine to Push'
WebUI.setText(findTestObject('Object Repository/Recent Activity/Path for Push to'), 'C:/')

WebUI.delay(5)

'Clicking on Push button'
WebUI.click(findTestObject('Object Repository/Recent Activity/Push button'))

WebUI.delay(5)

'Closing the browser'
WebUI.closeBrowser()

def dd() {
    Runtime rt = Runtime.getRuntime()

    Process p = rt.exec('C:\\Users\\TECHOLUTION\\Desktop\\Autoit\\FileUpload1.exe')
}

