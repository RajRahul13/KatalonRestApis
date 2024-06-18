package frameworkFunctions

import static com.kms.katalon. core.checkpoint.CheckpointFactory.findCheckpoint


import static com.kms.katalon.core.testcase. TestCaseFactory.findTestCase


import static com.kms.katalon.core.testdata.TestDataFactory.findTestData


import static com.kms.katalon. core.testobject.ObjectRepository.findTestObject


import static com.kms.katalon. core.testobject.ObjectRepository.findWindowsObject


import com.kms.katalon.core.annotation.Keyword


import com.kms.katalon.core.checkpoint.Checkpoint


import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW


import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


import com.kms.katalon.core.model.FailureHandling


import com.kms.katalon.core.testcase.TestCase


import com.kms.katalon.core.testdata.TestData


import com.kms.katalon.core.testobject. TestObject


import com. kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS


import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


import com.kms.katalon.core.configuration.RunConfiguration

import internal. GlobalVariable


import java.text.DateFormat


import java. text. ParseException


import java.text.SimpleDateFormat

public class UtilityLib {

	@Keyword
	public String CurrentDateTime_UF () {
		String sDate = "";
		//Getting the current date and formatting
		try {
			Date dNow = new Date();
			SimpleDateFormat dtSimple = new SimpleDateFormat("dd_MMM_УУУУ_НН_mm _ss")
			sDate = dtSimple.format(dNow)
		}
		catch (Exception e) {
			e. printStackTrace()
		}
		return sDate;
	}

	//Create a folder for Requests and Responses
	@Keyword
	public String CreateFolder_UF ()
	{
		String sResultPath = "";//Initializing ResultPath
		//Creating Results, Log parent folder
		String sCurrentDateTime = CurrentDateTime_UF() //Initialize for Current Date time
		String sRootPath = RunConfiguration.getProjectDir()//Get Current Project root dir


		String sFolderPath = "Responses/"+"Responses_" + sCurrentDateTime
		sResultPath = sRootPath + "/"+ sFolderPath
		GlobalVariable.sJSONResultPath = sResultPath

		File Resultdir = new File(sResultPath); //Checking existence of Results folder
		if (!Resultdir.exists())
		{
			try {boolean b = Resultdir. mkdir()
			}
			catch (Exception e) {
				e.printStackTrace()
			}
		}
		return sResultPath;
	}

}
