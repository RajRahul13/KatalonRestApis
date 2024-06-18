import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testcase.TestCase as TestCase

import com.kms.katalon.core.testdata. TestData as TestData

import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon. core.model.FailureHandling as FailureHandling

import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.RequestObject as Requestobject

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty

import internal.GlobalVariable as GlobalVariable

import groovy.json.JsonBuilder as JsonBuilder
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration


RunConfiguration.setDriverPreferencesProperty( 'Remote', 'name', GlobalVariable.sTestCaseName)

CustomKeywords.'frameworkFunctions.Auth.AuthGenerate'() //check setup in GET_AuthToken -> HttpHeader

String testcasename=RunConfiguration.getExecutionSource().toString().substring(RunConfiguration.getExecutionSource().toString().lastIndexOf("\\")+1)
testcasename = testcasename.substring(0, testcasename.length()-3)
GlobalVariable.sTestCaseName=testcasename
println(GlobalVariable.sTestCaseName)

//def FilePath = RunConfiguration.getProjectDir () + "/Responses"
//GlobalVariable.sJSONResultPath=FilePath
//printin(GlobalVariable.sJSONResultPath)

String path = CustomKeywords.'frameworkFunctions.UtilityLib.CreateFolder_UF'()
println(path)

KeywordUtil log = new KeywordUtil() //for logging to console

def endPoint = GlobalVariable.EndPoint
def resourceGET = resourceGET //Defined in Variables
def actualStatusCode
def expectedStatusCode="200"
def responseFilePath = GlobalVariable.sJSONResultPath
def testCaseName = GlobalVariable.sTestCaseName

try {
	def requestObjectGET = ((findTestObject('Object Repository/httpRequest/GET')) as RequestObject)
	
	//Constructing URL
	String fullRequestUrlGET= endPoint + resourceGET
	log.logInfo("fullRequestUrIGET : "+fullRequestUrlGET)
	
	//Setting Request URL
	requestObjectGET.setRestUrl(fullRequestUrlGET)

	//Sending Request
	def fullResponseGET = WS.sendRequest(requestObjectGET)
	log.logInfo("fullResponseGET :"+fullResponseGET)

	//getting Response in String
	def textResponseGET = fullResponseGET.getResponseText()
	log.logInfo("textResponseGET :"+textResponseGET)

	actualStatusCode = fullResponseGET.getStatusCode().toString()
	log.logInfo("actualStatusCode :"+actualStatusCode)

	//storing the POST response in responses folder
	String currentDateTime = CustomKeywords.'frameworkFunctions.UtilityLib.CurrentDateTime_UF'()
	def responseFileNameGET = ((((responseFilePath + '/Response_') + testCaseName) + 'GET') + currentDateTime) + '.json' //
	println(responseFileNameGET)
	//Writing to JSON File
	CustomKeywords.'frameworkFunctions.processISON.writeToFile'(responseFileNameGET, textResponseGET)
	//Data Validation
	def textResponseGETParsed = new JsonSlurper().parseText(textResponseGET)
	if (actualStatusCode == expectedStatusCode) {
		KeywordUtil.markPassed('SUCCESS: http status matched') //IF GET Fails
	} else {
		KeywordUtil.markFailed('FAILED: Status code did not matched' )
	}
	//getting attribute from jsonResponse
	//10g. logInfo("Email of user : "+textResponseGETParsed.data.email)

}
catch (Exception e) {
	KeywordUtil.markError(e.getMessage())
}