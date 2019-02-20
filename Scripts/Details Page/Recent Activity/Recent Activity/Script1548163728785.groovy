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
WebUI.sendKeys(findTestObject('Recent Activity/Global Search bar'), 'Walmart or Cabela')

'Performing Search Action'
WebUI.click(findTestObject('Recent Activity/img_Advanced Search_logo'))

'checking first 3 machines'
for (i = 2; i < 5; i++) {
	'Modifying the Xpath to make Generic xpath for Reusability'
    TestObject to2 = findTestObject('Results page/Results_First Machine_Checkbox')
   
	'Updating path with dynamic values'
    to2.findProperty('xpath').setValue((('//*[@id=' + '\'mat-checkbox-') + i) + '\']/label/div')
    
	'Clicking on Dynamic xpath generated'
    WebUI.click(to2)
}

'Clicking on Run Action Dropdown'
WebUI.click(findTestObject('Results page/Run Action Dropdown'))

'Wating to Load elements on UI'
WebUI.delay(50)

'Clicking on Run Script Action'
WebUI.click(findTestObject('Results page/Run Script action'))

'Clicking on Second Checkbox in the Dialog'
WebUI.click(findTestObject('Results page/Results_Script_Checkbox2'))

'Clicking on ViewAll link'
WebUI.click(findTestObject('Results page/Results_Script_Viewall'))

'Waiting to enable Run action after script selection'
WebUI.delay(2)

'Clicking on Run action button'
WebUI.click(findTestObject('Recent Activity/button_Run Script'))

'Closing the dialog'
WebUI.click(findTestObject('Results page/Close Dialog'))

'Waiting to comeback from dialog to results page'
WebUI.delay(2)


for (int j = 1; j < 4; j++) {
	'Modifying the Xpath to make Generic xpath for Reusability'
    TestObject to1 = findTestObject('Results page/Results_First Machine_BA')
    
	'Updating path with dynamic values'
    to1.findProperty('xpath').setValue(('(//div[4]/span)[' + j) + ']')

	'Getting the text and storing it in string'
    String machinedetails = WebUI.getText(to1)
	
	'Extract text before ,'
	String BANO = machinedetails.split('\\,')[0]
	
    'Clicking on Dynamic xpath generated'
    WebUI.click(to1)

	'Getting the text and storing it in string'
    String MachineIndetails = WebUI.getText(findTestObject('Recent Activity/Machine and Model info'))
	
	'Extract text before -'
	String BANOIN = MachineIndetails.split('\\ ')[0]
	
	'Validating BA Number in Results and Details Page'
	if(BANO.equalsIgnoreCase(BANOIN))
	{
	
	'Waiting for Page load'
	WebUI.delay(5)

	'Getting the text and storing it in string'
    String ExecutionStatus = WebUI.getText(findTestObject('Recent Activity/Execution Status updated'))
	
	'Printing the complete Information'
	println('BA Number on Results Page:- '+BANO + '  BA Number in Details Page:- '+BANOIN + '  Status of the Script is:- '+ExecutionStatus )
 
	'Clicking on back button'
    WebUI.click(findTestObject('Recent Activity/span_Back'))
	}
	
	else {
		
		'Printing statement if BA numbers not matching in Results and Details Page'
		println('BA numbers not matching:-BA Number on Results Page:- '+BANO + '  BA Number in Details Page:- '+BANOIN)
	}
}

'closing browser'
WebUI.closeBrowser()

