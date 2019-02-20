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

'Get Alert status count'
String AlertCount = WebUI.getText(findTestObject('Rev Alert Donut/Rev_Alert_Count'))

'Spliting the string before letter R'
String Alerts1 = AlertCount.split('\\R')[0]

'Covert String to Int'
int Alerts = Integer.parseInt(Alerts1)

'Printing Alerts'
println(Alerts)

'Get Need Attention alert count'
String NeedAttension1 = WebUI.getText(findTestObject('Rev Alert Donut/NA_count'))

'Covert String to Int'
int NeedAttension = Integer.parseInt(NeedAttension1)

'Getting alert count'
String ProblemDetected1 = WebUI.getText(findTestObject('Rev Alert Donut/PD_Count'))

'Covert String to Int'
int ProblemDetected = Integer.parseInt(ProblemDetected1)


'Getting alert count'
String Degrade1 = WebUI.getText(findTestObject('Rev Alert Donut/De_Count'))

'Covert String to Int'
int Degrade = Integer.parseInt(Degrade1)


'Getting alert count'
String ProbNotified1 = WebUI.getText(findTestObject('Rev Alert Donut/PN_Count'))

'Covert String to Int'
int ProbNotified = Integer.parseInt(ProbNotified1)


'Getting alert count'
String NotConnect1 = WebUI.getText(findTestObject('Rev Alert Donut/NC_Count'))

'Covert String to Int'
int NotConnect = Integer.parseInt(NotConnect1)


'Getting alert count'
String GoodOdo1 = WebUI.getText(findTestObject('Rev Alert Donut/GD_OD_Count'))

'Covert String to Int'
int GoodOdo = Integer.parseInt(GoodOdo1)


'Getting alert count'
String Good1 = WebUI.getText(findTestObject('Rev Alert Donut/GD_COunt'))

'Covert String to Int'
int Good = Integer.parseInt(Good1)


'Getting the sum of all alerts'
int All = (((((NeedAttension + ProblemDetected) + Good) + GoodOdo) + NotConnect) + ProbNotified) + Degrade


'printing the value'
println(NeedAttension)

'printing the value'
println(ProblemDetected)

'printing the value'
println(Degrade)

'printing the value'
println(ProbNotified)

'printing the value'
println(NotConnect)

'printing the value'
println(GoodOdo)

'printing the value'
println(Good)


'Printing sum of alerts'
println('Sum of 7 alerts are:- ' + All)

'Printing alert count on donut card'
println('Total alerts count displayed on Donut are :- ' + Alerts)

'Validating sum of alerts count with alert count on donut card'
if (Alerts.equals(All)) {
    println('Count matches')
} else {
    println('Not matching')
}

'Clicking on user profile Icon'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Profile Icon'))

'Clicking on logout link'
WebUI.click(findTestObject('Profile/Profile Page/Profile Page/Page_RRS/Page_RRS/button_Logout'))

'Closing the browser'
WebUI.closeBrowser()

