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

'Entering username'
WebUI.sendKeys(findTestObject('Page_Login/Username'), 'rrssuperadmin@techolution.com')

'Entering Password'
WebUI.sendKeys(findTestObject('Page_Login/Password'), 'j@mIefR0s7')

'Clicking on SignIn button'
WebUI.click(findTestObject('Page_Login/Sign In button'))

'Clicking on Go to dasboard button'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard/Go To Dashboard'))

'Clicking on Filter icon'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Filter Icon'))

'Clicking on Customer filter section'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Customers Filter'))

'Unchecking All Customers checkbox'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/All Customers Checkbox'))




try {
	/*
String dynamicId = ' CABELA'S INC. '
String xpath = '//span[text()="' + dynamicId + '"]'
TestObject to1 = new TestObject("Dashboard/Customer Specific_new")
to1.addProperty("xpath", ConditionType.EQUALS, xpath)
*/
	String Cust = '" CABELA\'S INC. "'
	Cust1=Cust.toUpperCase();

	//Cust.CASE_INSENSITIVE_ORDER
	TestObject to2 = findTestObject('Dashboard/Customer Specific')

	to2.findProperty('xpath').setValue(('//span[text()= ' + Cust1) + ']')

	WebUI.focus(to2)

	WebUI.click(to2 //WebUI.focus(findTestObject('Dashboard/Customer Specific'))
		) //WebUI.click(findTestObject('Dashboard/Customer Specific'))
}
catch (Exception e) {
	println('Exception Caught')
}

/*
'Performing Mouse scroll to find the element on UI'
WebUI.scrollToElement(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/CABELAS INC_Checkbox'), 800)

'Clicking on the Customers Checkbox option'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/CABELAS INC_Checkbox'))
*/
'Clicking on Apply button'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Filter_Apply_Button'))

'Finding the Unit Life section in Dashbord'
TestObject UnitlifeDB = findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Unit Life  Dashboard display')

'Extracting the unit llife information'
String unitlifeDBText = WebUI.getText(UnitlifeDB)

'Clicking on Unit Life Details link'
String company = WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Unit Life and PM Rolling details link'))

'Looping to each machine details and getting its information '
for (i = 1; i <= 3; i++) {
    TestObject to = findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Customer Address of Machine')

    to.findProperty('xpath').setValue((('(.//*[normalize-space(text()) and normalize-space(.)=' + '\'Install Date\'])[') + 
        i) + ']/preceding::span[3]')

    String GetText = WebUI.getText(to)

    if (GetText.contains('CABELA')) {
        WebUI.click(to)

        TestObject MachineDetails = findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Complete machine Details')

        MachineDetails.findProperty('xpath').setValue('(.//*[normalize-space(text()) and normalize-space(.)=' + '\'Rated At :\'])[1]/following::span[2]')

        println(GetText)

        String GetMachineText = WebUI.getText(MachineDetails)

        // println(GetMachineText)
        WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/Complete Machine Details_Back'))

        if (GetText.contains(unitlifeDBText)) {
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

'Clicking on LogOut button'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_Logout'))

'Closing the Browser'
WebUI.closeBrowser()

