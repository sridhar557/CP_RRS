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
import static java.lang.Integer.parseInt as asInteger
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar

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

'Clicking on Signin Button'
WebUI.click(findTestObject('Page_Login/Sign In button'))

'Clicking on Dashboard button'
WebUI.click(findTestObject('Dashboard/Dashboard/Go To Dashboard'))

'Clicking on Filter Icon'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Filter Icon'))

'Clicking on Models Section'
WebUI.click(findTestObject('Dashboard/Models Filter'))

'UnChecking All models option'
WebUI.click(findTestObject('Dashboard/All Models Checkbox'))

'Looping to multiple models for selection'
for (int i = 8; i <= 16; i++) {
 
    TestObject to = findTestObject('Dashboard/Model_4000')

    to.findProperty('xpath').setValue((('(.//*[normalize-space(text()) and normalize-space(.)=' + '\'Models\'])[1]/following::span[') + 
        i) + ']')

    i++

    String modelname = WebUI.getText(to)

    println(modelname)

    WebUI.click(to)
}

'Clicking on Apply button'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Filter_Apply_Button'))

'Performing mouse scroll to make elements visible on UI'
WebUI.scrollToPosition(0, 400)

'Clicking on Dashboard Details link in Executive Dashboard page'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Unit Life and PM Rolling details link'))

'Looping to multiple models for selection'
for (int j = 10; j <= 165; j++) {

    TestObject to = findTestObject('Dashboard/Get text of machine')

    to.findProperty('xpath').setValue((('(.//*[normalize-space(text()) and normalize-space(.)=' + '\'Items Per Page:\'])[1]/following::span[') + 
        j) + ']')

    String machinename = WebUI.getText(to)

    println(machinename)

    j = (j + 30)
}

'Clicking on model count'
WebUI.click(findTestObject('Dashboard/Count of Model'))

'Looping to multiple models for selection'
for (int k = 5; k <= 13; k++) {
   
    TestObject to = findTestObject('Dashboard/List of models')

    to.findProperty('xpath').setValue((('(.//*[normalize-space(text()) and normalize-space(.)=' + '\'Rated At :\'])[30]/following::span[') + 
        k) + ']')

    String Modelnames = WebUI.getText(to)

    println(Modelnames)

    k++
}

'Closing the browser'
WebUI.closeBrowser()


