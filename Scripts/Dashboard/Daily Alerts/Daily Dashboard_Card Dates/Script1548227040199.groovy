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

'Performing mouse scroll to make elements visible on UI'
WebUI.scrollToPosition(0, 400)

'Clicking on Daily Alerts link in Executive Dashboard page'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Details Link'))

'Get Current Date of the System'
Date date = Calendar.getInstance().getTime()

'Get Date Format'
DateFormat dateFormat = new SimpleDateFormat('yyyy-mm-dd hh:mm:ss')

'Storing Date value in String'
String strDate = dateFormat.format(date)

'Extract text before ,'
String DaySplit = strDate.split('\\-')[2]

'Extract text before space'
String Day = DaySplit.split('\\ ')[0]

'Coverting String value to Int'
int IDay = Integer.parseInt(Day)

'Substrcting one day from current day to validate date on the cards'
int PrevDay = IDay - 1

'Waiting for Page to load data'
WebUI.delay(5)

'Looping for  each cards the date field'
for (int i = 1; i <= 10; i++) {
    TestObject to = findTestObject('Dashboard/Dashboard/Dashboard Page/AVG_No_Hrs_1')

    to.findProperty('xpath').setValue((('(.//*[normalize-space(text()) and normalize-space(.)=' + '\'DAILY DASHBOARD\'])[1]/following::mat-card-subtitle[') + 
        i) + ']')

    String DateOnCard = WebUI.getText(to)
	
'Extract text before ,'
String DaySplited = DateOnCard.split('\\,')[0]
	
'Extract text before space'
String Dayoncard = DaySplited.split('\\ ')[3]
	
'Converting String to Int'	
int IDayonCard = Integer.parseInt(Dayoncard)

'Verifying  day condition'
if (IDayonCard.equals(PrevDay)) {
	
println('Days Matched with Previous day:-  Date displayed on Card is: ' + IDayonCard + '  Date of Previous day is : ' + PrevDay)
            } 
    else if(IDayonCard.equals(IDay)) {
			println('Days Matched with Current day:-  Date displayed on Card is: ' + IDayonCard + '  Date of Previous day is : ' + IDay)
        }
		 else {
			println('Days Not Matched with Previous/Current day:-  Date displayed on Card is: ' + IDayonCard + '  Date of Previous day is : ' + IDay)		
		}
}
'Closing the Browser'
WebUI.closeBrowser()

