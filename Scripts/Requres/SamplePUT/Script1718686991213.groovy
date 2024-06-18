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

KeywordUtil log = new KeywordUtil() //for logging to console
def endPoint = GlobalVariable.EndPoint
def resourcePUT = resourcePUT //Defined in Variables
def actualStatusCode
def expectedStatusCode="200"

try {
	def requestObjectPUT = ((findTestObject('Object Repository/httpRequest/PUT')) as RequestObject)
	
	//Constructing URL
	String fullRequestUrlPUT= endPoint + resourcePUT
	log.logInfo("fullRequestUrlPUT : "+fullRequestUrlPUT)
	
	//Setting Request URL
	requestObjectPUT.setRestUrl(fullRequestUrlPUT)
	//body
	requestObjectPUT.setBodyContent(new HttpTextBodyContent(requestBodyPUT,'UTF-8','application/json'))

	//Sending Request
	def fullResponsePUT = WS.sendRequest(requestObjectPUT)
	log.logInfo("fullResponsePUT :"+fullResponsePUT)

	//getting Response in String
	def textResponsePUT = fullResponsePUT.getResponseText()
	log.logInfo("textResponsePUT :"+textResponsePUT)

	actualStatusCode = fullResponsePUT.getStatusCode().toString()
	log.logInfo("actualStatusCode :"+actualStatusCode)
	
	//Data Validation
	def textResponsePOSTParsed = new JsonSlurper().parseText(textResponsePUT)
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