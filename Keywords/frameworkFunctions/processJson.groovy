package frameworkFunctions
import java.nio.file.Path 
import java.nio. file.Paths
//import com. jayway-jsonpath.Configuration
//import com. jayway jsonpath. JsonPath 
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration

public class processISON { 
@Keyword
	def writeToFile(String sPath, String sResult) {
	//JSONObject myObject = new JSONObjectsResult);
	try {
		//FileWriter file = new FileWriter ("C:/Realogy/DashAPI/DashAPI/Requests_Responses/Test1 ison")
		FileWriter file = new FileWriter(sPath)
		file.write(sResult)
		file.flush()
	}
	catch(IOException e) {
		e.printStackTrace()
	}
}
@Keyword
	def getsonValue(String sJsonPath, String sJsonFilePath) {
		try {
			// json file as input
			Path projectDir = Paths. get (RunConfiguration.getProjectDir())
			Path responseFile = projectDir.resolve(sJsonFilePath)
			// read the file
			def json = responseFile. toFile().getText('UTF-8')
			// parse the text, turn it into a JSON document
			Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
			//Get the. json Path
			def fragment0 = JsonPath.read (document, sJsonPath)
		}
		catch(Exception e) {}
	}

@Keyword
	def getJsonValue(String sJsonPath) {
		// json file as input
		Path projectDir = Paths.get(RunConfiguration.getProjectDir())
		Path responseFile = projectDir.resolve(sJsonFilePath)
		// read the file
		def json = responseFile.toFile().getText('UTF-8')
		// parse the text, turn it into a JSON document
		Object document = Configuration. defaultConfiguration() jsonProvider() parse(json);
		//Get the json Path
		def fragment0 = JsonPath.read(document, sJsonPath)
		print fragment0

	}
}
