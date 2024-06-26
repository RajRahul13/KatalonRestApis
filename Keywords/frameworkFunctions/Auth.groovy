package frameworkFunctions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import static com.kms.katalon. core.testobject.ObjectRepository.findTestObject

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword

import com. kms.katalon.core.checkpoint.Checkpoint

import com.kms.katalon. core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.model.FailureHandling

import com.kms.katalon.core.testcase.TestCase

import com.kms.katalon.core.testdata.TestData

import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import groovy.util.logging.Commons
import internal. GlobalVariable

public class Auth {
	public static AuthGenerate () {
		//Initial set up to store Requests and Responses
		def response = WS.sendRequest(findTestObject ('Common/Auth_Token_Generate'))
		
		String sResponse = response getResponseText()
		JsonSlurper slurper = new JsonSlurper()
		Map parsedJson = slurper.parseText(sResponse)
		String sAccessToken = parsedJson.token
		
		GlobalVariable.sAccessToken = (('Bearer' + ' ') + sAccessToken)
		println(sAccessToken)
	}
}	
