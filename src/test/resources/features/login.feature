Feature: Login Feature 

Scenario Outline: Login Functionality for valid username and password for user with role CFO 
	Given user is on the application login page 
	When user logs in with username as "<username>" and password as "<password>" 
	Then user is on the application home page 
	Then user gets the message starting with Welcome on the top 
	Then user gets logged out 
	
	Examples: 
		| username | password |
		| dummycfo | passw0rd |
		| dummyfm | passw0rd | 
		
Scenario: Login Functionality for invalid username 
	Given user is on the application login page 
	When user logs in with username as "dummytest" and password as "passw0rd" 
	Then user gets the message as "Please Enter Valid Username or Password!!!" on login page 
	
	
	
		