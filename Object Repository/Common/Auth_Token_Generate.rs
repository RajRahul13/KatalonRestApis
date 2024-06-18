<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Auth_Token_Generate</name>
   <tag></tag>
   <elementGuidId>6d30e1bc-0c6d-4944-b8a4-6c4111c4984f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;client_id\u003d0aaassssd4fsgshbdFD\u0026client_secret\u003dAxnsfbsujhjsbgfusgfsjbfsjbfssjbfjsv\u0026grant_type\u003dclient_credentials\u0026scope\u003dhttps://numadic.com/upi&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>text/plain</value>
   </httpHeaderProperties>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${tokenURL}?client_id=${client_id}&amp;client_secret=${client_secret}&amp;grant_type=${grant_type}&amp;scope=${scope}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.null</defaultValue>
      <description></description>
      <id>e999dcfd-4bcc-4710-9a69-f1d8f09d6d20</id>
      <masked>false</masked>
      <name>client_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.client_secret</defaultValue>
      <description></description>
      <id>d89ab1ff-56ee-4c9f-b006-2c591f73e9b0</id>
      <masked>false</masked>
      <name>client_secret</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.grant_type</defaultValue>
      <description></description>
      <id>d8f1c7ac-292d-4c2c-97d7-f59ad2808cf1</id>
      <masked>false</masked>
      <name>grant_type</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.scope</defaultValue>
      <description></description>
      <id>d376a0ea-a1f1-4135-af97-557ce13c7ef3</id>
      <masked>false</masked>
      <name>scope</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.tokenUrl</defaultValue>
      <description></description>
      <id>884c80a8-2a2c-4cd7-a0b4-a4b4850dfc3a</id>
      <masked>false</masked>
      <name>tokenUrl</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
