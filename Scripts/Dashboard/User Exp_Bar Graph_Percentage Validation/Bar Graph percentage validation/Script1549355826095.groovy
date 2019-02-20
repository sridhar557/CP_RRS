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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.support.Color as Color

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


'Clicking on User experience details link in Executive Dashboard page'
String company = WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard Page/User Experience Details link'))


/*'clicking on first bar graph'
for (i = 0; i < 10; i++) {
    TestObject to2 = findTestObject('User Experirence/Bar graph 1')

    to2.findProperty('xpath').setValue((('//*[@id=' + '\'bar') + i) + '\']')

    WebUI.click(to2)
	
    'getting success ratio of first bar graph'
    String Bar1Ratio = WebUI.getText(findTestObject('User Experirence/Bar 1 success ratio'))

    'Printing the Ratio'
    println(Bar1Ratio)

    if (Bar1Ratio.equals('99.97%')) {
        println('found the bar with percentage 98.80%')

        break
    }
}*/

'Getting Pagination text from User Experience details page'
String Pagination = WebUI.getText(findTestObject('User Experirence/Pagination details'))

println(Pagination)

'Extract text before %'
String totalpages = Pagination.split('\\ ')[3]

println('string totalpages'+totalpages)

'Converting String to Int'
Integer pagescount = Integer.parseInt(totalpages)

println('int pagescount'+pagescount)

for (j = 0; j <= pagescount; j++) {
	
	'clicking on first bar graph'
	for (i = 0; i < 15; i++) {
		TestObject to2 = findTestObject('User Experirence/Bar graph 1')
	
		to2.findProperty('xpath').setValue((('//*[@id=' + '\'bar') + i) + '\']')
	
		WebUI.click(to2)
		
		'getting success ratio of first bar graph'
		String Bar1Ratio = WebUI.getText(findTestObject('User Experirence/Bar 1 success ratio'))
	
		'Printing the Ratio'
		println(Bar1Ratio)
	
		if (Bar1Ratio.equals('99.97%')) {
        println('found the bar with percentage 99.97%')

        break
    }
	}
	
	WebUI.click(findTestObject('User Experirence/Page Forward link'))
	println(j)
	'Waiting to page load for 3 seconds'
	WebUI.delay(2)

}


'Waiting to page load for 3 seconds'
WebUI.delay(3)

'Performing Click on User Profile icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Profile Icon'))

'Clicking on Logout button'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_Logout'))

'Closing the Browser'
WebUI.closeBrowser()

