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

'Clicking on Signin button'
WebUI.click(findTestObject('Page_Login/Sign In button'))

'Clicking on Go To dashboard button'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard/Go To Dashboard'))

'Clicking On Filter Icon'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Filter Icon'))

'Clicking on Customers section'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Customers Filter'))

'Unchecking All Customers option'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/All Customers Checkbox'))

try {
	String Cust = '" UNITED SUPERMARKETS "'
	Cust1=Cust.toUpperCase();
	TestObject to2 = findTestObject('Dashboard/Customer Specific')

	to2.findProperty('xpath').setValue(('//span[text()= ' + Cust1) + ']')

	WebUI.focus(to2)

	WebUI.click(to2)
}
catch (Exception e) {
	println('Exception Caught')
}



/*
'Performing Mouser scroll to find the element on the UI'
WebUI.scrollToElement(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/UNITED SUPERMARKETS_Checkbox'), 
    800)

'Checking the Customers check box'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/UNITED SUPERMARKETS_Checkbox'))
*/
'Clicking on Apply button'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Filter_Apply_Button'))

'Finding the Unit Life section\'s information from the Executive dashbard page'
TestObject UnitlifeDB = findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Unit Life  Dashboard display')

'Get information of all Unit Life information from Executive dashboard page'
String unitlifeDBText = WebUI.getText(UnitlifeDB)

'Clicking on Unit Life details link'
String company = WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Unit Life and PM Rolling details link'))

'Looping through each machine\'s information and validating same with dahboard data'
for (i = 1; i <= 3; i++) {
    TestObject to = findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Customer Address of Machine')

    to.findProperty('xpath').setValue((('(.//*[normalize-space(text()) and normalize-space(.)=' + '\'Install Date\'])[') + 
        i) + ']/preceding::span[3]')

    String GetText = WebUI.getText(to)

    if ((GetText.contains('MARKET STREET') || 'UNITED SUPERMARKET') || 'AMIGO\'S') {
        WebUI.click(to)

        TestObject MachineDetails = findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Complete machine Details')

        MachineDetails.findProperty('xpath').setValue('(.//*[normalize-space(text()) and normalize-space(.)=' + '\'Rated At :\'])[1]/following::span[2]')

        println(GetText)

        String GetMachineText = WebUI.getText(MachineDetails)

        // println(GetMachineText)
        WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Complete Machine Details_Back'))

        if (GetText.contains(unitlifeDBText)) {
            CustomKeywords.'userdefinedkeywords.WriteExcel.demoKey'(GetText)

            println('Dashboard Data Matches with Page Data')
        } else {
            println('Dashboard Data doesnt match with page data')
        }
    } else {
        println('Failed to find the match')

        WebUI.closeBrowser()
    }
}


'Clicking on User Profile Icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Profile Icon'))

'Clicking on logout link'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_Logout'))

'Closing the browser'
WebUI.closeBrowser()

