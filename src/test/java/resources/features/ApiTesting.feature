@apiTest @all
Feature: Automated API Test using restassured
Description: Testing apis using restassured and testNG.

Scenario: GET employee data
	Given GET request on url: "GetEmployees" with searchParam "1"
	Then Check the response status is 200
	And Check the status line is correct for HTTP request
	And Check headers
	And The response Json matches the Json from file "responseData/EmployeeResponseData.Json"
#	And Check response key "employee_name" contains value "Tiger Nixon"
#	And Check response key "employee_salary" contains value 320800

Scenario: POST employee data
	Given POST data to url: "PostEmployee" from the json file: "requestData/EmployeeData.Json"
	Then Check the response status is 200
	And The key "id" is returned in the response
		