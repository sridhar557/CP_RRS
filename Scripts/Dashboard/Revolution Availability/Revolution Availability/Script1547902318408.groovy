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

'Entering Password'
WebUI.sendKeys(findTestObject('Page_Login/Password'), 'j@mIefR0s7')

'Clicking on SignIn Button'
WebUI.click(findTestObject('Page_Login/Sign In button'))

'Clicking on Go To Dashboard button'
WebUI.click(findTestObject('Dashboard/Dashboard/Dashboard Page/Dashboard/Go To Dashboard'))

'Getting Availability count from donut'
String Rev_Avail_Count1 = WebUI.getText(findTestObject('Rev_Availability_Chart/Revolution_Avail_Count'))

'Converting String to int'
int Rev_Avail_Count = Integer.parseInt(Rev_Avail_Count1)

'Printing revolution availability count'
println(Rev_Avail_Count)

'getting online status count'
String OnlineCount1 = WebUI.getText(findTestObject('Rev_Availability_Chart/Online Count'))

'converting status to int'
int OnlineCount = Integer.parseInt(OnlineCount1)

'printing online count'
println(OnlineCount)

'getting missing status count'
String MissingCount1 = WebUI.getText(findTestObject('Rev_Availability_Chart/Missing Count'))

'converting string to int'
int MissingCount = Integer.parseInt(MissingCount1)

'printing missing count'
println(MissingCount)

'getting missing status count'
String MutedCount1 = WebUI.getText(findTestObject('Rev_Availability_Chart/Muted Count'))

'converting string to int'
int MutedCount = Integer.parseInt(MutedCount1)

'printing Muted count'
println(MutedCount)

'Get sum of all statuses '
int Total = (OnlineCount + MissingCount) + MutedCount

'printing sum of all statuses'
println('Total of Online+Missing+Muted Alerts are :-' + Total)

'printing alerts count on card'
println('Total Revolution Alerts are :-' + Rev_Avail_Count)

'Validating alert count on card with sum of all statuses'
if (Rev_Avail_Count.equals(Total)) {
    println('Revolutions matching')
} else {
    println('Not Matching')
}

'Getting the percentage of Online status machines'
String Percentagedetails = WebUI.getText(findTestObject('Rev_Availability_Chart/Online_Percentage'))

'Spliting string with %'
String Percentage1 = Percentagedetails.split('\\%')[0]

'Converting String to Int'
int Percentage = Integer.parseInt(Percentage1)

'Printing the Percentage'
println(Percentage)

'Calculating the percentage'
double CalculatePercentage = (OnlineCount / Rev_Avail_Count) * 100

'Printing the percentage'
println(CalculatePercentage)

'Rounding the percentage to nearest integer'
int percentageafterrounding = Math.round(CalculatePercentage)

'Printing percentage after rounding'
println(percentageafterrounding)

'Priniting Online percentage'
println(Percentage)

'Comparing and validating percentages of online statuses'
if (percentageafterrounding == Percentage) {
    println('Percentage calculation is correct')
} else {
    println('Wrong')
}

'Clicking on user profile Icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Profile Icon'))

'Clicking on logout link'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_Logout'))

'Closing the browser'
WebUI.closeBrowser()

