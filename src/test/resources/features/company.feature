Feature: Create Company

Background: User is on the Home Page after successful login
	Given user is on the application login page 
	And user logs in with username as "dummycfo" and password as "passw0rd"

Scenario: Create New Company Successfully
	Given user is on the application home page
	When user clicks on on New button from Manage Company tab 
	And User enters Company name as "[randam]"
	And User selects Company type as "IT"
	And User Company Subtype as "Support"
	And User enters Address as "Pune"
	And User enters Phone as "0123456789"
	And User enters Email as "abcdef@gmail.com"
	And User enters Pan Details as "ARPPT3211265498"
	And User enters Tin details as "32165432165487"
	And User selects Country as "INDIA"
	And User selects State as "MAHARASHTRA"
	And User selects City name as "PUNE"
	And User enters Total Employee as "1"
	And User clicks on Save button
	Then new Company should get created successfully and should see on the first row of the table
	Then user gets logged out
	


	